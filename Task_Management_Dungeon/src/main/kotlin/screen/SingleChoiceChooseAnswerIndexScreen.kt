package screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import classes.SingleTaskQuestion
import com.example.compose.AppTheme
import composable.QuestionDisplay
import composable.title

class SingleChoiceChooseAnswerIndexScreen(val question: SingleTaskQuestion) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Scaffold() {
                    LazyColumn(
                        Modifier.padding(
                            start = 24.dp,
                            top = 24.dp,
                            end = 24.dp
                        )
                    ) {
                        item {
                            title("Bitte kontrollieren Sie die Angaben und wählen Sie die korrekte Antwort aus der Antwortliste an:")
                        }
                        item {
                            QuestionDisplay(question, Modifier.fillMaxWidth())
                        }
                    }
                }

            }

        }
    }
}