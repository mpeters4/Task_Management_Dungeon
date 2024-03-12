package composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun inputNumberField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label : String
) {
    var text by remember { mutableStateOf(value) }

    OutlinedTextField(
        modifier = modifier.padding(8.dp),
        value = text,
        onValueChange = {
            text = it.filter { symbol ->
                symbol.isDigit()
            }
            onValueChange(it)},
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

