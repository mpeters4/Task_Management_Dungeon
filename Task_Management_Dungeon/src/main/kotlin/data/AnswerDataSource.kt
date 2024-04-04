package data

import db.Answer
import db.Tag
import kotlinx.coroutines.flow.Flow

interface AnswerDataSource {

    suspend fun getAnswerById(id: Long): Answer?

    fun getAnswersByQuestionId(id: Long): Flow<List<Answer>>

    suspend fun insertAnswer(questionId: Long, answer: String, id: Long? = null)

    suspend fun deleteAnswerById(id: Long)
}