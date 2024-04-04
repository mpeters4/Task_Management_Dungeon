package data

import Task_Management_Dungeon.Database
import db.Question
import kotlinx.coroutines.flow.Flow


class ProjectQuestionDataSourceImpl(db: Database): ProjectQuestionDataSource {
    override fun getAllQuestionsByProjectId(projectId: Long): Flow<List<Question>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertProjectQuestion(projectId: Long, questionId: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProjectQuestionByQuestionId(projectId: Long, questionId: Long) {
        TODO("Not yet implemented")
    }
}