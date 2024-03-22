package composable

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import classes.AssignQuestion
import classes.MultipleChoiceQuestion
import classes.SingleTaskQuestion

@Composable
@Preview
fun QuestionDisplay(question: SingleTaskQuestion, modifier: Modifier){
    Column(modifier = modifier.padding(16.dp).background(MaterialTheme.colorScheme.onBackground)) {
        Text(question.description,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 16.dp))
        Text("Antworten:",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 16.dp))
        Column {
            question.answers.forEach { answer ->
                Text(answer,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 16.dp))
            }
        }
        Text("Antworten:",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 16.dp)
        )


    }

}

@Composable
fun QuestionDisplay(question: MultipleChoiceQuestion){

}
@Composable
fun QuestionDisplay(question: AssignQuestion){

}