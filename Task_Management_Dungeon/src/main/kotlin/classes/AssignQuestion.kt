package classes

import androidx.compose.runtime.mutableStateListOf

data class AssignQuestion(
    var description: String = "",
    var points: Int = 0,
    var pointsToPass: Int = 0,
    var explanation: String = "",
    val tags: List<String> = mutableStateListOf(),
    val assignments: List<Assignment> = mutableStateListOf()
)