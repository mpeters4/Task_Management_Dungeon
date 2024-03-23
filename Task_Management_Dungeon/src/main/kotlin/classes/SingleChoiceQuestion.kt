package classes

import androidx.compose.runtime.mutableStateListOf

data class SingleChoiceQuestion(
    var description: String = "",
    var points: Int = 0,
    var pointsToPass: Int = 0,
    var explanation: String = "",
    val answers: List<String> = mutableStateListOf(),
    val tags: List<String> = mutableStateListOf()
) {
    var correctAnswerIndex : Int = -1
}