@file:OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)

package composable


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun correctAnswerSelector(list: List<String>) {
    Scaffold(
    ) {
        LazyColumn(
            modifier = Modifier,
        ) {
            items(items = list){
                {

                }
            }
        }
    }
}