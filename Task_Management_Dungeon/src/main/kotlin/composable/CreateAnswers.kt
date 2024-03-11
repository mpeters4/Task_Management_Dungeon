package composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import icon.addIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun createAnswers(
    modifier: Modifier
) {
    var text by rememberSaveable { mutableStateOf("") }
    var answers = remember { mutableStateListOf<String>() }
    Column() {

        Text(
            text = "Bitte geben Sie die möglichen Antworten ein:",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Row(content = {
            Image(
                addIcon(MaterialTheme.colorScheme.onBackground),
                "Add",
                Modifier.padding(4.dp, top = 26.dp).clickable {
                    answers.add(text)
                    text = ""
                })
            OutlinedTextField(
                modifier = modifier.padding(8.dp).fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                label = { Text("Antwort eingeben") }
            )

        })
        Text(
            text = "Antworten:",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        LazyColumn() {
            items(items = answers) { answer ->
                Card(
                    modifier= modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.onSecondary
                )){
                    Box(){
                        Row(modifier.align(Alignment.Center),
                            verticalAlignment = Alignment.CenterVertically) {
                            Image(addIcon(MaterialTheme.colorScheme.onSurfaceVariant), "Remove Item", Modifier.padding(10.dp).clickable { answers.remove(answer)})
                            Text("Antwort: " + answer,style = MaterialTheme.typography.bodyMedium, fontSize = 24.sp, lineHeight = 25.sp, modifier = modifier.clickable {})
                        }
                    }
                }
            }
        }
    }
}
