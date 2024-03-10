package composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun inputTextField(
    modifier: Modifier
) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = modifier.fillMaxWidth().padding(8.dp),
        value = text,
        onValueChange = { text = it },
        label = { Text("Frage eingeben") }
    )
}