package composable

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import classes.AssignQuestion
import classes.MultipleChoiceQuestion
import classes.SingleTaskQuestion

@Composable
fun QuestionDisplay(question: SingleTaskQuestion, modifier: Modifier = Modifier){
    Box (modifier.fillMaxSize().clip(shape = RoundedCornerShape(10.dp)).background(MaterialTheme.colorScheme.onSecondary)){
        Column(modifier = modifier.fillMaxWidth().padding(16.dp)) {
            Row {
                bodyText("Frage: ", modifier =  Modifier.weight(1f))
                bodyText(question.description, modifier = Modifier.weight(4f))
            }
            Row {
                bodyText("Antworten:", modifier = Modifier.weight(1f))
                Column(modifier = Modifier.weight(4f)) {
                    question.answers.forEachIndexed { index, answer ->
                        Row {
                            bodyText("Antwort ${index+1}: ")
                            bodyText(answer)
                        }
                    }
                }
            }
            Row {
                bodyText("Korrekte Antwort:", modifier = Modifier.weight(1f))
                bodyText("Antwort ${question.correctAnswerIndex + 1}", modifier = Modifier.weight(4f))
            }
            Row {
                bodyText("Erklärung:", modifier =  Modifier.weight(1f))
                bodyText(question.explanation, modifier = Modifier.weight(4f))
            }
            Row {
                bodyText("Punkte:", modifier = Modifier.weight(1f))
                bodyText("$${question.points} (Punkte zum Bestehen: ${question.pointsToPass})", modifier = Modifier.weight(4f))
            }
            Row {
                bodyText("Tags:", 20, Modifier.weight(1f))
                if(question.tags.isNotEmpty()){
                    Column(Modifier.weight(4f)) {
                        question.tags.forEach { tag ->
                            bodyText(tag)
                        }
                    }
                }else{
                    bodyText("Keine Tags vorhanden", modifier = Modifier.weight(4f))
                }
            }
        }
    }
}

@Composable
fun QuestionDisplay(question: MultipleChoiceQuestion, modifier: Modifier = Modifier){
    Box (modifier.fillMaxSize().clip(shape = RoundedCornerShape(10.dp)).background(MaterialTheme.colorScheme.onSecondary)){
        Column(modifier = modifier.fillMaxWidth().padding(16.dp)) {
            Row {
                bodyText("Frage: ", modifier =  Modifier.weight(1f))
                bodyText(question.description, modifier = Modifier.weight(4f))
            }
            Row {
                bodyText("Antworten:", modifier = Modifier.weight(1f))
                Column(modifier = Modifier.weight(4f)) {
                    question.answers.forEachIndexed { index, answer ->
                        Row {
                            bodyText("Antwort ${index+1}: ")
                            bodyText(answer)
                        }
                    }
                }
            }
            Row {
                bodyText("Korrekte Antworten:", modifier = Modifier.weight(1f))
                Column(modifier = Modifier.weight(4f)) {
                    question.correctAnswers.forEach(){  index ->
                        bodyText("Antwort ${index+1}: ")
                    }
                }

            }
            Row {
                bodyText("Erklärung:", modifier =  Modifier.weight(1f))
                bodyText(question.explanation, modifier = Modifier.weight(4f))
            }
            Row {
                bodyText("Punkte:", modifier = Modifier.weight(1f))
                bodyText("$${question.points} (Punkte zum Bestehen: ${question.pointsToPass})", modifier = Modifier.weight(4f))
            }
            Row {
                bodyText("Tags:", 20, Modifier.weight(1f))
                if(question.tags.isNotEmpty()){
                    Column(Modifier.weight(4f)) {
                        question.tags.forEach { tag ->
                            bodyText(tag)
                        }
                    }
                }else{
                    bodyText("Keine Tags vorhanden", modifier = Modifier.weight(4f))
                }
            }
        }
    }
}
@Composable
fun QuestionDisplay(question: AssignQuestion){

}