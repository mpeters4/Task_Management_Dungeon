package composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import icon.addIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun createAnswers(
    modifier: Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }
    var answers = remember { mutableStateListOf<String>()}
    Column {

        Text(
            text = "Bitte geben Sie die möglichen Antworten ein:",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant)
        Row {
            OutlinedTextField(
                modifier = modifier.padding(8.dp),
                value = text,
                onValueChange = { text = it },
                label = { Text("Antwort eingeben") }
            )
            Image(addIcon(MaterialTheme.colorScheme.onBackground), "Add", Modifier.padding(4.dp, top = 26.dp).clickable {
                answers.add(text)
                text = ""
            })
        }
        Text(
            text = "Antworten:",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant)
        LazyColumn {
            items(items = answers) {
                    answer -> Text("Antwort: " + answer, modifier = Modifier.clickable { answers.remove(answer) })
            }
        }
    }
}
