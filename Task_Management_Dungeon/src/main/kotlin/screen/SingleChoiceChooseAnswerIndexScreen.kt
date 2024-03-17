package screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import classes.SingleTaskQuestion

class SingleChoiceChooseAnswerIndexScreen(val question: SingleTaskQuestion) :Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        LazyColumn {
            item {Text("Bitte wählen Sie die korrekte Antwort aus:")  }
            item {Text(question.description)}
            item {Text(question.explanation)}
            item {Text(question.points.toString())}
            item {Text(question.pointsToPass.toString())}
            items(items = question.answers){answer ->
                Text(text = answer, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.clickable {

                })
                Button(modifier = Modifier.padding(16.dp), colors = ButtonDefaults.buttonColors(), onClick = {
                    navigator.pop()
                }) {
                    Text("Back")
                }

            }


        }
    }
}