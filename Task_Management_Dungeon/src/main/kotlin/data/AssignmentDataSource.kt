package data

import db.Answer
import db.Assignment
import kotlinx.coroutines.flow.Flow

interface AssignmentDataSource {
    suspend fun getAnswerById(id: Long): Assignment?

    fun getAnswersByQuestionId(id: Long): Flow<List<Assignment>>

    suspend fun insertAssignment(questionId: Long, assignment: String, id: Long? = null)

    suspend fun deleteAssignmentById(id: Long)
}