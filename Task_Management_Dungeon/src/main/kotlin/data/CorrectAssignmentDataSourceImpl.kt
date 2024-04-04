package data

import Task_Management_Dungeon.Database
import db.Answer

class CorrectAssignmentDataSourceImpl(db:Database): CorrectAnswerDataSource {
    override suspend fun getCorrectAnswerByQuestionId(questionId: Long): Answer? {
        TODO("Not yet implemented")
    }

    override suspend fun insertCorrectAnswer(questionId: Long, answerId: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCorrectAnswerByAnswerId(answerId: Long, questinId: Long) {
        TODO("Not yet implemented")
    }
}