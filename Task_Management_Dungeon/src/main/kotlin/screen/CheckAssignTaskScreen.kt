package screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import classes.AssignQuestion
import com.example.compose.AppTheme
import composable.QuestionDisplay
import composable.title

/**
 * Screen to check assign question before saving
 * @param question Question to check
 */
class CheckAssignTaskScreen(val question : AssignQuestion) : Screen{
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Scaffold {
                    LazyColumn(
                        Modifier.padding(
                            start = 24.dp,
                            top = 24.dp,
                            end = 24.dp
                        )
                    ) {
                        item {
                            title("Bitte kontrollieren Sie die Angaben")
                        }
                        item {
                            QuestionDisplay(question, Modifier.fillMaxWidth())
                        }
                        item {
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
                                        //ADD QUESTION TO DATABASE
                                        navigator.popUntilRoot()
                                    }) {
                                    Text("Speichern")
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}