
package composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
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
    onItemClick: (Int) -> Unit
) {
    var showDropdown by rememberSaveable { mutableStateOf(false) }
    var selectedIndex by rememberSaveable { mutableStateOf(0) }
    val scrollState = rememberScrollState()


    ExposedDropdownMenuBox(
        expanded = showDropdown,
        onExpandedChange = {showDropdown = it }
    ){
        TextField(
            value = itemList[selectedIndex],
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
                        selectedIndex = index
                        showDropdown = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }

        }
    }
}


