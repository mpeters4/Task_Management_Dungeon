package screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.compose.AppTheme
import composable.createAnswers
import composable.inputTextField

class CreateSingleChoiceScreen : Screen {
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(/*Modifier.verticalScroll(rememberScrollState())*/) {
                    inputTextField(Modifier)
                    createAnswers(Modifier)
                    Button(colors = ButtonDefaults.buttonColors(), onClick = {
                        navigator.pop()
                    }) {
                        Text("Zurück!")
                    }
                }
            }
        }

    }
}