package composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun inputTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label : String,
    isError: Boolean
) {
    var text by remember { mutableStateOf(value) }
    OutlinedTextField(
        modifier = modifier.fillMaxWidth().padding(8.dp),
        value = text,
        onValueChange = { text = it
            onValueChange(it)},
        label = { Text(label) },
        isError = isError
    )
}