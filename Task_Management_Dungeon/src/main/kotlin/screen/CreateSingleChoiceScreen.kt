package screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import classes.SingleTaskQuestion
import com.example.compose.AppTheme
import composable.createAnswers
import composable.createStringList
import composable.inputNumberField
import composable.inputTextField

class CreateSingleChoiceScreen : Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        //Variablen für Single Choice Frage
        var questionText by rememberSaveable { mutableStateOf("") }
        var answers = remember { mutableStateListOf<String>() }
        var points by rememberSaveable { mutableStateOf("") }
        var pointsToPass by rememberSaveable { mutableStateOf("") }
        var explanation by rememberSaveable { mutableStateOf("") }
        var tags = remember { mutableStateListOf<String>() }
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                LazyColumn(
                    Modifier.padding(
                        start = 24.dp,
                        top = 24.dp,
                        end = 24.dp
                    )/*Modifier.verticalScroll(rememberScrollState())*/
                ) {
                    item {
                        Text(
                            "Single-Choice Frage erstellen:",
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center,
                            fontSize = 50.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }
                    //Single_Choice_Frage erstellen
                    item {
                        inputTextField(
                            Modifier,
                            questionText,
                            onValueChange = { questionText = it },
                            "Frage eingeben"
                        )
                    }
                    item { createAnswers(Modifier, answers, onValueChange = { answers = it }) }
                    item { createStringList(Modifier, tags, onValueChange = { tags = it }, taskLabel = "Bitte Tags angeben", outputLabel = "Tags:", textFieldLabel = "Tag angeben") }
                    item {
                        inputTextField(
                            Modifier,
                            explanation,
                            onValueChange = { explanation = it },
                            "Erklärung angeben"
                        )
                    }
                    item {
                        Row{
                            inputNumberField(Modifier.width(300.dp), points, onValueChange = { points = it }, "Punkte")
                            inputNumberField(
                                Modifier.width(300.dp),
                                points,
                                onValueChange = { pointsToPass = it },
                                "Punkte zum bestehen"
                            )
                        }
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
                                    navigator.push(
                                        SingleChoiceChooseAnswerIndexScreen(
                                            SingleTaskQuestion(
                                                questionText,
                                                points.toInt(),
                                                pointsToPass.toInt(),
                                                explanation,
                                                answers
                                            )
                                        )
                                    )
                                }) {
                                Text("Weiter")
                            }
                        }
                    }
                    //item {  }

                }
            }
        }

    }
}