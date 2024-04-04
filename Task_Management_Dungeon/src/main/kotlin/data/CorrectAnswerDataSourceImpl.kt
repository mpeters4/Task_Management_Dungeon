package data

import Task_Management_Dungeon.Database
import db.Answer

class CorrectAnswerDataSourceImpl(db:Database): CorrectAnswerDataSource {
    override suspend fun getCorrectAnswerByQuestionId(questinId: Long): Answer? {
        TODO("Not yet implemented")
    }

    override suspend fun insertCorrectAnswer(questinId: Long, answerId: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCorrectAnswerByAnswerId(answerId: Long, questinId: Long) {
        TODO("Not yet implemented")
    }
}