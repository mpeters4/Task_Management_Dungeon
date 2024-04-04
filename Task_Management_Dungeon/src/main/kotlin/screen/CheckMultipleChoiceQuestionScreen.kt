package screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import classes.MultipleChoiceQuestion
import com.example.compose.AppTheme
import composable.QuestionDisplay
import composable.title
import databaseInteraction.Driver
import databaseInteraction.Provider
import kotlinx.coroutines.runBlocking

/**
 * Screen to check multiple question before saving
 * @param question Question to check
 */
class CheckMultipleChoiceQuestionScreen(val question: MultipleChoiceQuestion): Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        AppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background,
            ) {
                Scaffold {
                    LazyColumn(
                        Modifier.padding(
                            start = 24.dp,
                            top = 24.dp,
                            end = 24.dp
                        )
                    ) {
                        item {
                            title("Bitte kontrollieren Sie die Angaben")
                        }
                        item {
                            QuestionDisplay(question, Modifier.fillMaxWidth())
                        }
                        item {
                            Row(//verticalAlignment = Alignment.Bottom,
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                Button(
                                    modifier = Modifier.padding(16.dp),
                                    colors = ButtonDefaults.buttonColors(),
                                    onClick = {
                                        navigator.pop()
                                    }) {
                                    Text("Zurück")
                                }
                                Button(
                                    modifier = Modifier.padding(16.dp),
                                    colors = ButtonDefaults.buttonColors(),
                                    onClick = {
                                        //ADD QUESTION TO DATABASE
                                        addMultipleChoiceQuestion(question)
                                        navigator.popUntilRoot()
                                    }) {
                                    Text("Speichern")
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    private fun addMultipleChoiceQuestion(question : MultipleChoiceQuestion) {
        val questionData = Provider.provideQuestionDataSource(Driver.createDriver())
        val answerData = Provider.provideAnswerDataSource(Driver.createDriver())
        runBlocking {
            //Frage einfügen
            questionData.insertQuestion(
                question.description,
                question.explanation,
                question.points.toLong(),
                question.pointsToPass.toLong(),
                "MULTIPLE_CHOICE_QUESTION",
            )
            //Antworten einfügen
            question.answers.forEachIndexed { index, answer ->
                answerData.insertAnswer(
                    answer = answer,
                    questionId = questionData.getQuestionId(
                        question.description,
                        question.explanation,
                        question.points.toLong(),
                        question.pointsToPass.toLong()
                    )!!
                )
                //Korrekte Anworten anfügen
                if (question.correctAnswerIndices.contains(index)) {
                    answerData.setCorrectAnswer(
                        answerData.getAnswerId(
                            answer = answer,
                            questionId = questionData.getQuestionId(
                                question.description,
                                question.explanation,
                                question.points.toLong(),
                                question.pointsToPass.toLong()
                            )!!
                        )!!
                    )
                }
                //TAGS einfügen
            }
        }
    }
}