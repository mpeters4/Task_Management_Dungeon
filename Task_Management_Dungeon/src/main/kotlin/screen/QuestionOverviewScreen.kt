package screen

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import classes.SingleChoiceQuestion
import com.example.compose.AppTheme
import composable.expandableItem
import composable.title

class QuestionOverviewScreen : Screen {
    @Composable
    @Preview
    override fun Content() {val navigator = LocalNavigator.currentOrThrow
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = androidx.compose.material3.MaterialTheme.colorScheme.background,
            ) {
                Scaffold(
                    topBar = {
                        title("Suche")
                    }
                ) {
                    LazyColumn(
                        Modifier.padding(
                            start = 24.dp,
                            top = 56.dp,
                            end = 24.dp
                        )
                    ) {
                       items(10){item ->
                           expandableItem(SingleChoiceQuestion("Dies ist eine Testfrage, wobei Antwort 2 die Lösung ist",
                               1,1,"Die Erklärung hierzu ist echt nicht nötig",
                               listOf("Antwort 1","Antwort 2", "antwoort3"), listOf("tag 1", "tag2")))

                       }
                    }
                }
            }
        }
    }
}