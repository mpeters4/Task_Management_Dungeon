package data

import Task_Management_Dungeon.Database
import db.Answer
import kotlinx.coroutines.flow.Flow

class AnswerDataSourceImpl(db: Database): AnswerDataSource {
    override suspend fun getAnswerById(id: Long): Answer? {
        TODO("Not yet implemented")
    }

    override fun getAnswersByQuestionId(id: Long): Flow<List<Answer>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertAnswer(questionId: Long, answer: String, id: Long?) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAnswerById(id: Long) {
        TODO("Not yet implemented")
    }
}