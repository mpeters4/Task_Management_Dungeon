package data

import Task_Management_Dungeon.Database
import db.Question
import db.Tag
import kotlinx.coroutines.flow.Flow

class QuestionTagDataSourceImpl(db : Database): QuestionTagDataSource {
    override fun getTagsByQuestionId(questionId: Long): Flow<List<Tag>> {
        TODO("Not yet implemented")
    }

    override fun getQuestionsByTag(): Flow<List<Question>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertQuestionTag(questionId: Long, tagId: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteQuestionTag(questionId: Long, tagId: Long) {
        TODO("Not yet implemented")
    }
}