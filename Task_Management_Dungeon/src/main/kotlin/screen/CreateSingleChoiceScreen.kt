package screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
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
import composable.inputNumberField
import composable.inputTextField
import composable.inputTextFieldValueTest

class CreateSingleChoiceScreen : Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        //Variablen für Single Choice Frage
        var questionText by rememberSaveable { mutableStateOf("") }
        var answers = remember { mutableStateListOf<String>() }
        var points by rememberSaveable { mutableStateOf("") }
        var pointsToPass by rememberSaveable { mutableStateOf(1) }
        var explanation by rememberSaveable { mutableStateOf("") }
        var tags = remember { mutableStateListOf<String>() }
        var text by rememberSaveable { mutableStateOf("knopp") }
        var correctAnswerIndex by rememberSaveable{ mutableStateOf(0) }
        var task = SingleTaskQuestion()
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                LazyColumn(Modifier.padding(start = 24.dp, top = 24.dp, end = 24.dp)/*Modifier.verticalScroll(rememberScrollState())*/) {
                    item {  Text("Single-Choice Frage erstellen:",
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                        fontSize = 50.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(bottom = 16.dp))}
                    item {  inputTextField(Modifier, questionText, onValueChange = {questionText = it}, "Frage eingeben")}
                    item { createAnswers(Modifier)}
                    item { inputTextField(Modifier,explanation, onValueChange = {explanation = it}, "TEST")}
                    item {  inputTextField(Modifier,questionText, onValueChange = {questionText = it}, "Rissa")}
                    item {
                        Row() {
                            inputNumberField(Modifier.width(200.dp), points,onValueChange = {points = it}, "PUNKTE")
                            inputNumberField(Modifier.width(200.dp), points,onValueChange = {points = it}, "PUNKTE")
                        }
                        }

                    item {
                        Row (//verticalAlignment = Alignment.Bottom,
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End){
                            Button(modifier = Modifier.padding(16.dp), colors = ButtonDefaults.buttonColors(), onClick = {
                                navigator.pop()
                            }) {
                                Text("Zurück")
                            }
                            Button(modifier = Modifier.padding(16.dp), colors = ButtonDefaults.buttonColors(), onClick = {
                                navigator.pop()
                            }) {
                                Text("Weiter")
                            }
                        } }
                    //item {  }
                    //USELESS Buttons
                    item { Button(colors = ButtonDefaults.buttonColors(), onClick = {
                        text = explanation
                    }) {
                        Text(text)
                    }}
                    item { Button(colors = ButtonDefaults.buttonColors(), onClick = {
                        text = task.points.toString()
                    }) {
                        task.points += 5

                        Text(text)
                    }}
                    item {

                        }
                }
            }
        }

    }
}