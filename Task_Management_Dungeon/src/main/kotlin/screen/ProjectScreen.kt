package screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import classes.*
import com.example.compose.AppTheme
import composable.bodyText
import composable.inputTextField
import composable.title
import kotlinx.coroutines.launch

/**
 * Welcome project screen. Passes the chosen project to the next screen
 */
class ProjectScreen : Screen {
    @Composable
    @Preview
    override fun Content() {
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()
        val navigator = LocalNavigator.currentOrThrow
        var newProjectName by rememberSaveable { mutableStateOf("") }
        var selectedIndex by rememberSaveable { mutableStateOf(-1) }
        val projects = remember { mutableStateListOf<Project>() }
        projects.add(Project(name = "Projekt A"))
        projects.add(Project(name = "Projekt B"))
        projects.add(Project(name = "Mathe Oberstufe"))

        //Beispieldaten

            projects.get(0).dependencies.add(Dependency())
            projects.get(0).dependencies.add(Dependency())
        //DEP 1
            projects.get(0).dependencies.get(0).dependency = "Sequenz"
            projects.get(0).dependencies.get(0).questionA = MultipleChoiceQuestion(
                "AFRAGE",
                1,
                1,
                "Erklärung",
                listOf("Antwort 1", "a2", "a3"),
                listOf("t1", "a", "t3"),
                correctAnswerIndices = listOf(1, 2)
            )
            projects.get(0).dependencies.get(0).questionB = AssignQuestion(
                "Frage",
                1,
                1,
                "Erklärung",
                assignments = listOf(
                    Assignment("Antwort 1", "FILTERME"),
                    Assignment("a3", "a5"), Assignment("A", "SOWASVON ASSIGNED")
                ),
                tags = listOf("t1", "t2", "t3")
            )
        //DEP2
            projects.get(0).dependencies.get(1).dependency = "Wenn richtig, dann"
            projects.get(0).dependencies.get(1).questionA = MultipleChoiceQuestion(
                "AFRAGE",
                1,
                1,
                "Erklärung",
                listOf("Antwort 1", "a2", "a3"),
                listOf("t1", "a", "t3"),
                correctAnswerIndices = listOf(1, 2)
            )
            projects.get(0).dependencies.get(1).questionB = AssignQuestion(
                "Frage",
                1,
                1,
                "Erklärung",
                assignments = listOf(
                    Assignment("Antwort 1", "FILTERME"),
                    Assignment("a3", "a5"), Assignment("A", "SOWASVON ASSIGNED")
                ),
                tags = listOf("t1", "t2", "t3")
            )

            projects.get(0).dependencies.add(Dependency())
            projects.get(0).dependencies.add(Dependency())
        //DEP 3
            projects.get(0).dependencies.get(2).dependency = "Sequenz"
            projects.get(0).dependencies.get(2).questionA = MultipleChoiceQuestion(
                "AFRAGE",
                1,
                1,
                "Erklärung",
                listOf("Antwort 1", "a2", "a3"),
                listOf("t1", "a", "t3"),
                correctAnswerIndices = listOf(1, 2)
            )
            projects.get(0).dependencies.get(2).questionB = AssignQuestion(
                "Frage",
                1,
                1,
                "Erklärung",
                assignments = listOf(
                    Assignment("Antwort 1", "FILTERME"),
                    Assignment("a3", "a5"), Assignment("A", "SOWASVON ASSIGNED")
                ),
                tags = listOf("t1", "t2", "t3")
            )
            //DEP4
            projects.get(0).dependencies.get(3).dependency = "Wenn richtig, dann"
            projects.get(0).dependencies.get(3).questionA = MultipleChoiceQuestion(
                "AFRAGE",
                1,
                1,
                "Erklärung",
                listOf("Antwort 1", "a2", "a3"),
                listOf("t1", "a", "t3"),
                correctAnswerIndices = listOf(1, 2)
            )
            projects.get(0).dependencies.get(3).questionB = AssignQuestion(
                "Frage",
                1,
                1,
                "Erklärung",
                assignments = listOf(
                    Assignment("Antwort 1", "FILTERME"),
                    Assignment("a3", "a5"), Assignment("A", "ASSIGNED")
                ),
                tags = listOf("t1", "t2", "t3")
            )

        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Scaffold(
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) } ,
                    topBar = {
                        Column {
                            title("Projekte")
                            bodyText(
                                "Erstellen Sie ein neues Projekt erstellen oder bearbeiten Sie ein vorhandenes",
                                modifier = Modifier.padding(start = 24.dp, end = 24.dp)
                            )
                        }
                    },
                    bottomBar = {
                        Row(//verticalAlignment = Alignment.Bottom,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
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
                                    scope.launch {
                                        if (selectedIndex == -1 && newProjectName.isEmpty()){
                                            snackbarHostState.showSnackbar(
                                                message = "Bitte wählen Sie ein Projekt aus oder tragen Sie einen Namen für das neue Projekt ein",
                                                withDismissAction = true
                                            )
                                        }else if (selectedIndex != -1 && newProjectName.isNotEmpty()){
                                            snackbarHostState.showSnackbar(
                                                message = "Bitte wählen Sie ein Projekt aus oder tragen Sie einen Namen für das neue Projekt ein.\nBeides ist nicht zulässig!",
                                                withDismissAction = true
                                            )
                                        }else if(selectedIndex != -1){
                                            navigator.push(EditProjectScreen(projects.get(selectedIndex)))
                                        }else{
                                            navigator.push(EditProjectScreen(Project(name = newProjectName)))
                                        }
                                    }
                                }) {
                                Text("Weiter")
                            }

                        }
                    }
                ) {
                    Column(modifier = Modifier.padding(it)) {
                        inputTextField(
                            label = "Neues Projekt anlegen",
                            modifier = Modifier.padding(start = 24.dp, end = 24.dp),
                            value = newProjectName,
                            onValueChange = { newProjectName = it },
                            isError = false
                        )
                        LazyColumn(
                            Modifier.padding(
                                start = 24.dp,
                                top = 24.dp,
                                end = 24.dp
                            ).fillMaxSize()
                        ) {
                            item {
                                title("Vorhandene Projekte")
                            }
                            itemsIndexed(items = projects) { index, project ->
                                bodyText(project.name, modifier = Modifier.selectable(
                                    selected = selectedIndex == index,
                                    onClick = {
                                        selectedIndex = if(selectedIndex != index) {
                                            index
                                        } else {
                                            -1
                                        }
                                    }
                                ).clip(shape = RoundedCornerShape(10.dp)).background(
                                    if (index == selectedIndex) {
                                        MaterialTheme.colorScheme.onSecondary
                                    } else MaterialTheme.colorScheme.background
                                ).fillParentMaxWidth().padding(start = 16.dp, end = 16.dp))
                                Spacer(modifier = Modifier.padding(8.dp))
                            }


                        }

                    }
                }

            }
        }
    }
}