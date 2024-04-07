package databaseInteraction

import androidx.compose.runtime.mutableStateListOf
import classes.*
import kotlinx.coroutines.flow.firstOrNull

object DataBaseCommunication {
    suspend fun getAnswersToQuestionId(questionId: Long): List<String> {
        val answerData = Provider.provideAnswerDataSource(Driver.createDriver())
        val answerDataList = answerData.getAnswersByQuestionId(questionId).firstOrNull()
        //sval aaa = answerDataList.forEach {  }
        var answers = mutableListOf<String>()
        answerDataList!!.forEach(){answer ->
            answers.add(answer.answer)
        }
        //LOAD ANSWER
        return answers
    }

    suspend fun getCorrectAnswersByQuestionId(questionId: Long): List<String> {
        val answerData = Provider.provideAnswerDataSource(Driver.createDriver())
        val answerList = answerData.getCorrectAnswersByQuestionId(questionId).firstOrNull()
        //LOAD ANSWER
        var answers = mutableListOf<String>()
        answerList!!.forEach(){answer ->
            answers.add(answer.answer)
        }
        //LOAD ANSWER
        return answers
    }

    suspend fun getAssignmentsToQuestionId(questionId: Long): List<Assignment> {
        val assignmentData = Provider.provideAssignmentDataSource(Driver.createDriver())
        val assignmentList = mutableStateListOf<Assignment>()
        assignmentList.add(Assignment())
        assignmentList.add(Assignment("TERMa", "TermB"))
        assignmentList.add(Assignment(termB = "TermB"))
        assignmentList.add(Assignment("TERMa"))
        //LOAD ANSWER
        return assignmentList
    }

    suspend fun getQuestionAsClass(question: db.Question): Question? {
        when (question.type) {
            "SINGLE_CHOICE_QUESTION" -> {
                var answers = getAnswersToQuestionId(question.id)
                var correctAnswers = getCorrectAnswersByQuestionId(question.id)
                var correctAnswerIndices: List<Int> = mutableListOf()
                answers.forEachIndexed() { index, answer ->
                    if (correctAnswers.contains(answer)) {
                        correctAnswerIndices.addLast(index)
                    }
                }
                return SingleChoiceQuestion(
                    description = question.description,
                    explanation = question.explanation,
                    points = question.points.toInt(),
                    pointsToPass = question.pointsToPass.toInt(),
                    answers = answers,
                    correctAnswerIndex =correctAnswerIndices[0]
                )
            }

            "MULTIPLE_CHOICE_QUESTION" -> {
                var answers = getAnswersToQuestionId(question.id)
                var correctAnswers = getCorrectAnswersByQuestionId(question.id)
                var correctAnswerIndices: List<Int> = mutableListOf()
                answers.forEachIndexed() { index, answer ->
                    if (correctAnswers.contains(answer)) {
                        correctAnswerIndices.addLast(index)
                    }
                }
                return MultipleChoiceQuestion(
                    description = question.description,
                    explanation = question.explanation,
                    points = question.points.toInt(),
                    pointsToPass = question.pointsToPass.toInt(),
                    answers = answers,
                    correctAnswerIndices =correctAnswerIndices
                )
            }

            "ASSIGN_QUESTION" -> {
                return AssignQuestion(
                    description = question.description,
                    explanation = question.explanation,
                    points = question.points.toInt(),
                    pointsToPass = question.pointsToPass.toInt(),
                    assignments = getAssignmentsToQuestionId(questionId = question.id)
                )
            }

        }
        return null
    }
}