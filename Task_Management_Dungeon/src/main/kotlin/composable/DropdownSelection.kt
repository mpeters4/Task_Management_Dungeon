
package composable

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun dropdownSelection(
    itemList: List<String>,
    modifier: Modifier,
    onItemClick: (String) -> Unit
) {
    var showDropdown by rememberSaveable { mutableStateOf(false) }
    var selectedIndex by rememberSaveable { mutableStateOf(0) }
    var str by rememberSaveable { mutableStateOf("") }
    ExposedDropdownMenuBox(
        expanded = showDropdown,
        onExpandedChange = {showDropdown = it }
    ){
        TextField(
            value = str,
            modifier = modifier
                .menuAnchor(),
            readOnly = true,
            onValueChange = {},
            label = {},
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = showDropdown)},
        )
        ExposedDropdownMenu(
            expanded = showDropdown,
            onDismissRequest = {showDropdown = false}
        ){
            itemList.forEachIndexed{index, item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        str = item
                        onItemClick(item)
                        selectedIndex = index
                        showDropdown = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
            onItemClick(str)
        }

    }
}


