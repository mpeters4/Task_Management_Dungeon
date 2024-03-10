package classes

class SingleTaskQuestion(
    questionID: Int,
    description: String,
    points: Int,
    pointsToPass: Int,
    explanation: String,
    val answers: List<Answer>,
    val correctAnswerIndex: Int,
    tags: List<String>
) : Question(questionID, description, points, pointsToPass, explanation, tags) {

}