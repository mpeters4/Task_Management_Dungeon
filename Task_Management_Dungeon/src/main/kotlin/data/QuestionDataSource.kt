package data

import db.Question
import kotlinx.coroutines.flow.Flow

interface QuestionDataSource {

    suspend fun getQuestionById(id: Long): Question?

    fun getAllQuestions(): Flow<List<Question>>

}