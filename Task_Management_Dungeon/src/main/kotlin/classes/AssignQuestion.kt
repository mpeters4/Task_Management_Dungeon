package classes

import androidx.compose.runtime.mutableStateListOf

class AssignQuestion(
    description: String = "",
    points: Int = 0,
    pointsToPass: Int = 0,
    explanation: String = "",
    tags: List<String> = mutableStateListOf(),
    val assignments: List<Assignment> = mutableStateListOf()
): Question(
    description = description,
    points = points,
    pointsToPass = pointsToPass,
    explanation = explanation,
    tags = tags,
    type = QuestionType.Assign
)