package screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import classes.*
import com.example.compose.AppTheme
import composable.*
import kotlinx.coroutines.launch

/**
 * Screen to choose a Question.
 */
class QuestionChooserScreen(var dependency: Dependency) : Screen {
    private fun filterSearchbar(searchBar: String, item: Question): Boolean {
        if (item.description.lowercase().contains(searchBar.lowercase())) {
            return true
        } else if (item.explanation.lowercase().contains(searchBar.lowercase())) {
            return true
        }
        return false
    }

    @Composable
    override fun Content() {
        val tagFilterList = remember { mutableStateListOf<String>() }
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()
        val questionList = mutableStateListOf(
            SingleChoiceQuestion(
                "Dies ist eine Testfrage, wobei Antwort 2 dieee Lösung ist",
                1, 1, "Die Erklärung hierzu ist echt nicht nötig",
                listOf("Antwort 1", "Antwort 2", "antwoort3"), listOf("tag 1", "tag2"), correctAnswerIndex = 1
            ),
            MultipleChoiceQuestion(
                "AFRAGE",
                1,
                1,
                "Erklärung",
                listOf("Antwort 1", "a2", "a3"),
                listOf("t1", "a", "t3"),
                correctAnswerIndices = listOf(1, 2)
            ),
            AssignQuestion(
                "Frage",
                1,
                1,
                "Erklärung",
                assignments = listOf(
                    Assignment("Antwort 1", "FILTERME"),
                    Assignment("a3", "a5"), Assignment("A", "SOWASVON ASSIGNED")
                ),
                tags = listOf("t1", "t2", "t3")
            ),
            SingleChoiceQuestion(
                "Frageq",
                1,
                1,
                "Erklärung",
                listOf("Antwort 1", "a2", "a3"),
                listOf("t1", "t2", "t3")
            ),
            SingleChoiceQuestion(
                "AFRAGE",
                1,
                1,
                "Erklärung",
                listOf("Antwort 1", "a2", "a3"),
                listOf("t1", "a", "t3")
            ),
            SingleChoiceQuestion(
                "Fragez",
                1,
                1,
                "Erklärunasfasfag",
                listOf("Antwort 1q", "a2", "a3"),
                listOf("t1", "FILTERME", "t3")
            ),
            SingleChoiceQuestion(
                "AAAAüZ",
                1,
                1,
                "Erklärungq",
                listOf("Antwort 1", "a2", "a3"),
                listOf("t1", "a", "31")
            )
        )
        var searchBar by rememberSaveable { mutableStateOf("") }
        var chosenQuestion: Question? = null
        val navigator = LocalNavigator.currentOrThrow
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Scaffold(
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                    topBar = {
                        Column {
                            inputTextField(Modifier, searchBar, onValueChange = { searchBar = it }, "Suche", false)
                            if(dependency.questionA == null){
                                title("Frage 1 zum hinzufügen auswählen")
                            }else{
                                title("Frage 2 zum hinzufügen auswählen")
                            }

                        }
                    },
                    bottomBar = {
                        Row(//verticalAlignment = Alignment.Bottom,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Button(
                                modifier = Modifier.padding(16.dp),
                                colors = ButtonDefaults.buttonColors(),
                                onClick = {
                                    navigator.pop()
                                }) {
                                Text("Zurück")
                            }
                            Button(
                                modifier = Modifier.padding(16.dp),
                                colors = ButtonDefaults.buttonColors(),
                                onClick = {
                                    if(chosenQuestion != null){
                                        if (dependency.questionA !=null){
                                            dependency.questionB = chosenQuestion
                                            navigator.push(CreateDependencyScreen(dependency = dependency))
                                        }else{
                                            dependency.questionA = chosenQuestion
                                            navigator.push(QuestionBChooserScreen(dependency = dependency))
                                        }
                                    }else{
                                        scope.launch {
                                            snackbarHostState.showSnackbar(
                                                message = "Bitte wählen Sie eine Frage aus!",
                                                withDismissAction = true
                                            )
                                        }
                                    }
                                }) {
                                Text("Weiter")
                            }
                        }
                    }
                ) {
//                    Row {
//                        Column(
//                            Modifier.padding(
//                                it
//                            ).weight(1f)
//                        ) {
//                            tagList.forEach { tag ->
//                                checkBoxFilter(tag,  onCheckedTrue = {
//                                    tagFilterList.add(tag)
//                                },
//                                    onCheckedFalse = {
//                                        tagFilterList.remove(tag)
//                                    })
//                            }
//                        }
                    LazyColumn(
                        Modifier.padding(
                            it
                        )
                    ) {
                        item { bodyText("Ausgewählte Frage:") }
                        item {
                            if (chosenQuestion != null) {
                                expandableItem(
                                    question = chosenQuestion!!,
                                    action = {},
                                    modifier = Modifier.fillMaxWidth(),
                                    mode = 3
                                )
                            } else {
                                bodyText("Bitte wählen Sie eine Frage zum hinzufügen aus.\n\nEine Frage wählen Sie mithilfe des hinzufügen Symbols(+) ganz unten in jeder Ausgeklappten Frage aus.", size = 20)
                            }
                        }
                        item {
                            HorizontalDivider(
                                Modifier.padding(12.dp),
                                color = MaterialTheme.colorScheme.onSecondary,
                                thickness = 10.dp
                            )
                        }

                        items(items = questionList) { item ->
                            if (tagFilterList.isNotEmpty() && searchBar.isNotEmpty()) {
                                tagFilterList.forEach {
                                    if (item.tags.contains(it)) {
                                        if (filterSearchbar(it, item)) {
                                            if (filterSearchbar(searchBar, item)) {
                                                expandableItem(
                                                    question = item,
                                                    action = {},
                                                    modifier = Modifier.fillMaxWidth(),
                                                    mode = 1
                                                )
                                            }
                                        }
                                    }
                                }
                            } else if (searchBar.isEmpty() && tagFilterList.isNotEmpty()) {
                                tagFilterList.forEach {
                                    if (item.tags.contains(it)) {
                                        if (filterSearchbar(it, item)) {
                                            expandableItem(
                                                question = item,
                                                action = { chosenQuestion = item },
                                                modifier = Modifier.fillMaxWidth(),
                                                mode = 1
                                            )
                                        }
                                    }
                                }
                            } else if (searchBar.isNotEmpty() && tagFilterList.isEmpty()) {
                                if (filterSearchbar(searchBar, item)) {
                                    expandableItem(
                                        question = item,
                                        action = { chosenQuestion = item },
                                        modifier = Modifier.fillMaxWidth(),
                                        mode = 1
                                    )
                                }

                            }
                            if (searchBar.isEmpty() && tagFilterList.isEmpty()) {
                                expandableItem(
                                    question = item,
                                    action = { chosenQuestion = item },
                                    modifier = Modifier.fillMaxWidth(),
                                    mode = 1
                                )
                            }
                        }
                    }
                }
            }


        }

    }
}

