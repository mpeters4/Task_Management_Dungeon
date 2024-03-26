package screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import classes.Project
import com.example.compose.AppTheme
import composable.bodyText
import composable.dropdownSelection
import composable.expandableItem
import composable.title
import icon.addIcon

class EditProjectScreen(val project: Project) : Screen {
    @Composable
    @Preview
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val dependencies = mutableStateListOf("Sequenz", "Wenn Richtig, dann", "Wenn Falsch, dann", "Optionale Unteraufgabe", "Pflicht Unteraufgabe")
        var selectedIndex by remember { mutableStateOf(0) }
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
                                androidx.compose.material3.Text("Zurück")
                            }
                        }
                    }
                ) {
                    LazyColumn(Modifier.padding(it)) {
                        item {
                            title("Spielablauf:")
                        }
                        item {
                            dropdownSelection(dependencies, selectedIndex = selectedIndex, modifier = Modifier, {})

                        }
                        items(items = project.dependencies) {dependency ->
                            Row {
                                expandableItem(dependency.questionA,{})
                                dropdownSelection(dependencies, selectedIndex = selectedIndex, modifier = Modifier, {})
                                expandableItem(dependency.questionB,{})
                            }


                        }

                        item { Row(Modifier.padding(start = 24.dp, end = 24.dp).fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                addIcon(androidx.compose.material3.MaterialTheme.colorScheme.onBackground),
                                "Add",
                                Modifier.padding(4.dp, top = 26.dp).clickable {
                                    navigator.push(QuestionChooserScreen())
                                })
                            bodyText("Neue Frage hinzufügen")
                        } }


                    }
                }

            }
        }
    }
}