package classes

import androidx.compose.runtime.mutableStateListOf

class SingleTaskQuestion(
    var description: String = "",
    var points: Int = 0,
    var pointsToPass: Int = 0,
    var explanation: String = "",
    val answers: List<String> = mutableStateListOf()
) {

    var tags: List<String> = mutableStateListOf<String>()
    var correctAnswerIndex : Int = -1

}