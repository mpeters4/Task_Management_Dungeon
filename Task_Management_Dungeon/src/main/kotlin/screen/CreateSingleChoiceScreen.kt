package screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.example.compose.AppTheme
import composable.createAnswers
import composable.inputTextField
import composable.inputTextFieldValueTest

class CreateSingleChoiceScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var questionText by rememberSaveable { mutableStateOf("") }
        var answers = remember { mutableStateListOf<String>() }
        var points by rememberSaveable { mutableStateOf(1) }
        var pointsToPass by rememberSaveable { mutableStateOf(1) }
        var explanation by rememberSaveable { mutableStateOf("") }
        var tags = remember { mutableStateListOf<String>() }
        var text by rememberSaveable { mutableStateOf("knopp") }

        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Column(Modifier.padding(start = 24.dp, top = 24.dp, end = 24.dp)/*Modifier.verticalScroll(rememberScrollState())*/) {
                    Text("Single-Choice Frage erstellen:",
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                        fontSize = 50.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(bottom = 16.dp))
                    inputTextField(Modifier)
                    createAnswers(Modifier)
                    inputTextFieldValueTest(Modifier,explanation, onValueChange = {explanation = it}, "TEST")
                    inputTextFieldValueTest(Modifier,questionText, onValueChange = {questionText = it}, "Rissa")
                    Button(colors = ButtonDefaults.buttonColors(), onClick = {
                        navigator.pop()
                    }) {
                        Text("Zurück!")
                    }
                    Button(colors = ButtonDefaults.buttonColors(), onClick = {
                        text = explanation
                    }) {
                        Text(text)
                    }
                    Button(colors = ButtonDefaults.buttonColors(), onClick = {
                        text = questionText
                    }) {
                        Text(questionText)
                    }
                }
            }
        }

    }
}