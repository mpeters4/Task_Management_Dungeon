package classes

import androidx.compose.runtime.mutableStateListOf

class SingleTaskQuestion(
    
) {

    var correctAnswerIndex : Int = -1
    var questionID : Int = 0
        get() = field
        set(value) {
            field = value
        }
    var description: String = ""
    var points: Int = 0
    var pointsToPass: Int = 0
    var explanation: String = ""
    val answers: List<String> = mutableStateListOf<String>()
    var tags: List<String> = mutableStateListOf<String>()


}