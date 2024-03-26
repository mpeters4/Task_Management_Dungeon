package screen

import androidx.compose.desktop.ui.tooling.preview.Preview
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
import composable.checkBoxFilter
import composable.expandableItem
import composable.inputTextField

class QuestionOverviewScreen : Screen {
    private fun filterSearchbar(searchBar: String, item: Question): Boolean {
        if (item.description.lowercase().contains(searchBar.lowercase())) {
            return true
        }else if (item.explanation.lowercase().contains(searchBar.lowercase())) {
            return true
        }
        return false
    }

    @Composable
    @Preview
    override fun Content() {
        val tagList = remember { listOf("tag 1", "tag 2", "a", "31") }
        val tagFilterList = remember { mutableStateListOf<String>() }
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
                    correctAnswerIndices = listOf(1,2)
                ),
                AssignQuestion(
                    "Frage",
                    1,
                    1,
                    "Erklärung",
                    assignments = listOf(Assignment("Antwort 1", "FILTERME"),
                        Assignment("a3", "a5"), Assignment("A", "SOWASVON ASSIGNED")),
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
        val navigator = LocalNavigator.currentOrThrow
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Scaffold(
                    topBar = {
                        inputTextField(Modifier, searchBar, onValueChange = { searchBar = it }, "Suche", false)
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
                        }
                    }

                ) {
                    Row {
                        Column(
                            Modifier.padding(
                                it
                            ).weight(1f)
                        ) {
                            tagList.forEach { tag ->
                                checkBoxFilter(tag, tagList, onCheckedTrue = {
                                    tagFilterList.add(tag)
                                },
                                    onCheckedFalse = {
                                        tagFilterList.remove(tag)
                                    })
                            }
                        }
                        LazyColumn(
                            Modifier.padding(
                                it
                            ).weight(5f)
                        ) {
                            items(items = questionList) { item ->
                                if (tagFilterList.isNotEmpty() && searchBar.isNotEmpty()) {
                                    tagFilterList.forEach {
                                        if (item.tags.contains(it)) {
                                            if (filterSearchbar(it, item)) {
                                                if (filterSearchbar(searchBar, item)) {
                                                    expandableItem(item) { questionList.remove(item) }
                                                }
                                            }
                                        }
                                    }
                                } else if (searchBar.isEmpty() && tagFilterList.isNotEmpty()) {
                                    tagFilterList.forEach {
                                        if (item.tags.contains(it)) {
                                            if (filterSearchbar(it, item)) {
                                                expandableItem(item) { questionList.remove(item) }
                                            }
                                        }
                                    }
                                } else if (searchBar.isNotEmpty() && tagFilterList.isEmpty()) {
                                    if (filterSearchbar(searchBar, item)) {
                                        expandableItem(item) { questionList.remove(item) }
                                    }

                                }
                                if (searchBar.isEmpty() && tagFilterList.isEmpty()) {
                                    expandableItem(item) { questionList.remove(item) }
                                }
                            }
                        }
                    }
                }

            }
        }

    }
}
