package classes

abstract class Question(
    val questionID: Int,
    val description: String,
    val points: Int,
    val pointsToPass: Int,
    val explanation: String,
    val tags : List<String>
) {
    
}