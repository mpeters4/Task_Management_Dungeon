package data

import db.Answer
import db.Assignment
import kotlinx.coroutines.flow.Flow

interface AssignmentDataSource {
    suspend fun getAssignmentById(id: Long): Assignment?

    fun getAssignmentsByQuestionId(id: Long): Flow<List<Assignment>>

    suspend fun insertAssignment(questionId: Long, termA: String, termB: String, id: Long? = null)

    suspend fun deleteAssignmentById(id: Long)
}