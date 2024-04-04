package data

import db.Question
import db.Tag
import kotlinx.coroutines.flow.Flow

interface QuestionTagDataSource {

    fun getTagsByQuestionId(questionId: Long): Flow<List<Tag>>

    fun getQuestionsByTag(): Flow<List<Question>>

    suspend fun insertQuestionTag(questionId: Long, tagId: Long)

    suspend fun deleteQuestionTag(questionId: Long, tagId: Long)
}