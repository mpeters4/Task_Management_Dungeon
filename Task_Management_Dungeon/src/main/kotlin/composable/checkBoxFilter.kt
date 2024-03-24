package composable

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment

@Composable
fun checkBoxFilter(
    text : String,
    tags : List<String>,
    onCheckedTrue: (SnapshotStateList<String>) -> Unit,
    onCheckedFalse: (SnapshotStateList<String>) -> Unit
){
    var isChecked = remember { mutableStateOf(false) }
    var tagList = remember { mutableStateListOf<String>() }


    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { checked -> isChecked.value = checked
                if (isChecked.value) {
                    onCheckedTrue(tagList)
                }else{
                    onCheckedFalse(tagList)
                }
            },

        )
        Text(text )


    }

}