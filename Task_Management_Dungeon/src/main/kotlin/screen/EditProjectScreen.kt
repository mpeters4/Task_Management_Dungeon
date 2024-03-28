package screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import classes.*
import com.example.compose.AppTheme
import composable.bodyText
import composable.dropdownSelection
import composable.expandableItem
import composable.title
import icon.addIcon

class EditProjectScreen(var project: Project) : Screen {
    @Composable
    @Preview
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val dependencies = mutableStateListOf("Sequenz", "Wenn Richtig, dann", "Wenn Falsch, dann", "Optionale Unteraufgabe", "Pflicht Unteraufgabe")
        var projectDependencyList = remember { mutableStateListOf<Dependency>() }
        var selectedIndex by remember { mutableStateOf(0) }
        projectDependencyList.add(
            Dependency(SingleChoiceQuestion(
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
        ), DependencyType.SEQUENCE))

        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = androidx.compose.material3.MaterialTheme.colorScheme.background,
            ) {
                Scaffold(
                    topBar = {
                        title(project.name)
                    },
                    bottomBar = {
                        Row(//verticalAlignment = Alignment.Bottom,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start
                        ) {
                            androidx.compose.material3.Button(
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
                    LazyColumn(Modifier.padding(it)) {
                        item {
                            title("Spielablauf:")
                            bodyText("Bitte wählen Sie Fragen aus, die in das Spiel integriert werden sollen. Jede Frage muss in Abhängigkeit zu einer anderen Frage stehen. Die Art der Abhängigkeiten kann dabei frei gewählt werden. Hat eine Frage mehrere Abhängigkeiten, muss die Frage mehrmals ausgewählt und zugeordnet werden.")
                        }
                        items(items = projectDependencyList) {dependency ->
                            Row {
                                if (dependency.questionA != null){
                                    expandableItem(question = dependency.questionA, action = { navigator.push(QuestionChooserScreen()) }, modifier = Modifier.weight(3f))
                                }else{
                                    Text("Frage hinzufügen", modifier = Modifier.clickable { navigator.push(QuestionChooserScreen()) })
                                }
                                dropdownSelection(dependencies, modifier = Modifier, {})
                                if (dependency.questionB != null){
                                    expandableItem(question = dependency.questionB, action = { navigator.push(QuestionChooserScreen()) }, modifier = Modifier.weight(3f))
                                }else{
                                    Text("Frage hinzufügen", modifier = Modifier.weight(1f).clickable { navigator.push(QuestionChooserScreen(),) })
                                }

                            }
                        }

                        item { Row(Modifier.padding(start = 24.dp, end = 24.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                            Image(
                                addIcon(androidx.compose.material3.MaterialTheme.colorScheme.onBackground),
                                "Add",
                                Modifier.padding(4.dp, top = 26.dp).clickable {
                                    //navigator.push(QuestionChooserScreen())
                                    //localProject.dependencies.add(Dependency(null,null, dependency = DependencyType.SEQUENCE))
                                    projectDependencyList.add(Dependency(null,null, dependency = DependencyType.SEQUENCE))
                                    project.dependencies = projectDependencyList
                                    //add(Dependency(null,null, dependency = DependencyType.SEQUENCE))

                                })
                            bodyText("Neue Frage hinzufügen")
                        } }


                    }
                }

            }
        }
    }
}
