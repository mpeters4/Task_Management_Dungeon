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
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import classes.Dependency
import classes.DependencyType
import classes.MultipleChoiceQuestion
import classes.Project
import com.example.compose.AppTheme
import composable.bodyText
import composable.dropdownSelection
import composable.expandableItem
import composable.title
import icon.addIcon

class ProjectOverviewScreen(val project : Project) : Screen {
    @Composable
    @Preview
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val dependencies = mutableStateListOf(
            "Sequenz",
            "Wenn Richtig, dann",
            "Wenn Falsch, dann",
            "Optionale Unteraufgabe",
            "Pflicht Unteraufgabe"
        )
        var projectDependencyList = remember { mutableStateListOf<Dependency>() }
        var selectedIndex by remember { mutableStateOf(0) }
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
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
                    LazyColumn(Modifier.padding(it)) {
                        item {
                            title("Spielablauf:")
                        }
                        items(items = project.dependencies) { dependency ->
                            Row(modifier = Modifier.padding(start = 48.dp, end = 48.dp)) {
                                if (dependency.questionA != null) {
                                    expandableItem(
                                        question = dependency.questionA!!,
                                        action = { navigator.push(QuestionChooserScreen()) },
                                        modifier = Modifier.weight(5f)
                                    )
                                }
                                bodyText(dependency.dependency)
                                if (dependency.questionB != null) {
                                    expandableItem(
                                        question = dependency.questionB!!,
                                        action = { navigator.push(QuestionChooserScreen()) },
                                        modifier = Modifier.weight(5f)
                                    )
                                }

                            }
                        }

                        item {
                            Row(
                                Modifier.padding(start = 48.dp, end = 48.dp).fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    addIcon(MaterialTheme.colorScheme.onBackground),
                                    "Add",
                                    Modifier.padding(4.dp, top = 26.dp).clickable {
                                        //navigator.push(QuestionChooserScreen())
                                        //localProject.dependencies.add(Dependency(null,null, dependency = DependencyType.SEQUENCE))
                                        //projectDependencyList.add(Dependency(null,null, dependency = DependencyType.SEQUENCE))

                                        //add(Dependency(null,null, dependency = DependencyType.SEQUENCE))
                                        projectDependencyList.add(
                                            Dependency()
                                        )
                                    })
                                bodyText("Neue Frage hinzufügen")
                            }
                        }
                    }
                }
            }
        }
    }

}