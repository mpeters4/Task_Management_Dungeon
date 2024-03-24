package screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import classes.SingleChoiceQuestion
import com.example.compose.AppTheme
import composable.checkBoxFilter
import composable.expandableItem
import composable.inputTextField
import composable.title

class QuestionOverviewScreen : Screen {
    @Composable
    @Preview
    override fun Content() {
        var tagList = remember { listOf("tag 1", "tag 2", "a", "tag 4") }
        var tagFilterList = remember { mutableStateListOf<String>() }
        var questionList = remember {
            listOf(
                SingleChoiceQuestion(
                    "Dies ist eine Testfrage, wobei Antwort 2 die Lösung ist",
                    1, 1, "Die Erklärung hierzu ist echt nicht nötig",
                    listOf("Antwort 1", "Antwort 2", "antwoort3"), listOf("tag 1", "tag2")
                ),
                SingleChoiceQuestion(
                    "AFRAGE",
                    1,
                    1,
                    "Erklärung",
                    listOf("Antwort 1", "a2", "a3"),
                    listOf("t1", "a", "t3")
                ),
                SingleChoiceQuestion(
                    "Frage",
                    1,
                    1,
                    "Erklärung",
                    listOf("Antwort 1", "FILTERME", "a3"),
                    listOf("t1", "t2", "t3")
                ),
                SingleChoiceQuestion(
                    "Frage",
                    1,
                    1,
                    "Erklärung",
                    listOf("Antwort 1", "a2", "a3"),
                    listOf("t1", "t2", "t3")
                ),
                SingleChoiceQuestion(
                    "AFRAGE",
                    1,
                    1,
                    "Erklärung",
                    listOf("Antwort 1", "a2", "a3"),
                    listOf("t1", "a", "t3")
                ),
                SingleChoiceQuestion(
                    "Frage",
                    1,
                    1,
                    "Erklärunasfasfag",
                    listOf("Antwort 1", "a2", "a3"),
                    listOf("t1", "FILTERME", "t3")
                ),
                SingleChoiceQuestion(
                    "AAAA",
                    1,
                    1,
                    "Erklärung",
                    listOf("Antwort 1", "a2", "a3"),
                    listOf("t1", "a", "t3")
                )
            )
        }
        var searchBar by rememberSaveable { mutableStateOf("") }
        val navigator = LocalNavigator.currentOrThrow
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = androidx.compose.material3.MaterialTheme.colorScheme.background,
            ) {
                Scaffold(
                    topBar = {
                        inputTextField(Modifier,searchBar,onValueChange = { searchBar = it },"Suche", false)
                    }
                ) {
                    Row {
                        Column(
                            Modifier.padding(
                                start = 24.dp,
                                top = 64.dp,
                                end = 24.dp
                            ).weight(1f)
                        ) {
                            tagList.forEach() { tag ->
                                    checkBoxFilter(tag, tagList, onCheckedTrue = {
                                        tagFilterList.add(tag)
                                    },
                                    onCheckedFalse = {
                                        tagFilterList.remove(tag)
                                    })
                            }
                        }
                        LazyColumn(
                            Modifier.padding(
                                start = 24.dp,
                                top = 64.dp,
                                end = 24.dp
                            ).weight(4f)
                        ) {
                            items(items = questionList) { item ->
                                if (tagFilterList.isNotEmpty()){
                                    tagFilterList.forEach() { it ->
                                        if (item.tags.contains(it)) {
                                            expandableItem(item)
                                        }
                                    }
                                }else expandableItem(item)

                            }


                        }
                    }
                }
            }
        }

    }
}
