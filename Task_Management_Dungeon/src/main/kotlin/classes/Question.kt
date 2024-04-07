package classes

import androidx.compose.runtime.mutableStateListOf

open class Question(
    var description: String = "",
    var points: Int = 0,
    var pointsToPass: Int = 0,
    var explanation: String = "",
    val tags: List<String> = mutableStateListOf(),
    val type : QuestionType
) {
}