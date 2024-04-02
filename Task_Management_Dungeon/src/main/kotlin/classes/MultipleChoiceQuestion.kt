package classes

import androidx.compose.runtime.mutableStateListOf

class MultipleChoiceQuestion(
    description: String = "",
    points: Int = 0,
    pointsToPass: Int = 0,
    explanation: String = "",
    tags: List<String> = mutableStateListOf(),
    val answers: List<String> = mutableStateListOf(),
    var correctAnswerIndices: List<Int> = mutableStateListOf()
) : Question(
    description = description,
    points = points,
    pointsToPass = pointsToPass,
    explanation = explanation,
    tags = tags,
    type = QuestionType.MultipleChoice
) {

}