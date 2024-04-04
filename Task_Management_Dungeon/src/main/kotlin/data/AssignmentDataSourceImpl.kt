package data

import Task_Management_Dungeon.Database
import db.Assignment
import kotlinx.coroutines.flow.Flow

class AssignmentDataSourceImpl(db:Database): AssignmentDataSource {
    override suspend fun getAnswerById(id: Long): Assignment? {
        TODO("Not yet implemented")
    }

    override fun getAnswersByQuestionId(id: Long): Flow<List<Assignment>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertAssignment(questionId: Long, assignment: String, id: Long?) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAssignmentById(id: Long) {
        TODO("Not yet implemented")
    }
}