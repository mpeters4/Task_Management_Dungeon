package data

import Task_Management_Dungeon.Database
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import db.Question
import db.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class QuestionTagDataSourceImpl(db : Database): QuestionTagDataSource {
    private val queries = db.questionTagQueries
    override fun getTagsByQuestionId(questionId: Long): Flow<List<String>> {
        return queries.getTagsByQuestionId(questionId).asFlow().mapToList(Dispatchers.IO)
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