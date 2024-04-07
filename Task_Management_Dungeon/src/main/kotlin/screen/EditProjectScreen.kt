package screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import classes.Dependency
import classes.Project
import com.example.compose.AppTheme
import composable.bodyText
import composable.dropdownSelection
import composable.expandableItem
import composable.title
import icon.addIcon
import kotlinx.coroutines.launch

/**
 * Screen to edit a project
 * @param project Project to edit
 */
class EditProjectScreen(private var project: Project) : Screen {
    @Composable
    @Preview
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val snackbarHostState = remember { SnackbarHostState() }
        val scope = rememberCoroutineScope()
        //Ab hier existieren nur Beispieldaten
        val dependencies = mutableStateListOf(
            "Sequenz",
            "Wenn Richtig, dann",
            "Wenn Falsch, dann",
            "Optionale Unteraufgabe",
            "Pflicht Unteraufgabe"
        )
        var test by remember { mutableStateOf("") }
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Scaffold(
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                    topBar = {
                        title(project.name)
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
                                        if (!checkProject(project)) {
                                            scope.launch {
                                                snackbarHostState.showSnackbar(
                                                    message = "Bitte füllen Sie alle Felder aus und fügen Sie alle Fragen hinzu",
                                                    withDismissAction = true
                                                )
                                            }
                                        } else  {
                                            navigator.popUntilRoot()
                                        }
                                }) {
                                Text("Speichern")
                            }
                        }
                    }
                ) { it ->
                    LazyColumn(Modifier.padding(it)) {
                        item {
                            title("Spielablauf:")
                            bodyText("Bitte wählen Sie Fragen aus, die in das Spiel integriert werden sollen. Jede Frage muss in Abhängigkeit zu einer anderen Frage stehen. Die Art der Abhängigkeiten kann dabei frei gewählt werden. Hat eine Frage mehrere Abhängigkeiten, muss die Frage mehrmals ausgewählt und zugeordnet werden.")

                        }
                        items(items = project.dependencies) { dependency ->
                            Row(
                                modifier = Modifier.padding(start = 48.dp, end = 48.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                if (dependency.questionA != null) {
                                    expandableItem(
                                        question = dependency.questionA!!,
                                        action = {  /*navigator.push(QuestionChooserScreen())*/ },
                                        modifier = Modifier.weight(5f)
                                    )
                                } else {
                                    Text(
                                        "Frage hinzufügen",
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.weight(5f)
                                            .clickable { /*navigator.push(QuestionChooserScreen())*/ })
                                }
                                dropdownSelection(
                                    itemList = dependencies,
                                    modifier = Modifier,
                                    onItemClick = { test = it },
                                    value = dependency.dependency
                                )
                                if (dependency.questionB != null) {
                                    expandableItem(
                                        question = dependency.questionB!!,
                                        action = { /*navigator.push(QuestionChooserScreen())*/ },
                                        modifier = Modifier.weight(5f)
                                    )
                                } else {
                                    Text(
                                        "Frage hinzufügen",
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.weight(5f)
                                            .clickable { /*navigator.push(QuestionChooserScreen())*/ })
                                }
                            }
                        }

                        item {
                            Card(
                                Modifier.padding(top = 16.dp, start = 128.dp, end = 128.dp).clickable {
                                    navigator.push(QuestionChooserScreen(Dependency()))
                                }
                            ) {
                                Row(
                                    Modifier.padding(start = 48.dp, end = 48.dp).fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Image(
                                        addIcon(MaterialTheme.colorScheme.onBackground),
                                        "Add",
                                        Modifier.padding(4.dp)
                                    )
                                    Text("Neuen Aufgabenteil hinzufügen", textAlign = TextAlign.Center)
                                }
                            }

                        }
                    }
                }
            }
        }
    }

    private fun checkProject(project: Project): Boolean {
        project.dependencies.forEach { dependency ->
            if (dependency.dependency.isEmpty()) {
                return false
            } else if (dependency.questionB == null || dependency.questionA == null) {
                return false
            }
        }
        return true
    }
}
