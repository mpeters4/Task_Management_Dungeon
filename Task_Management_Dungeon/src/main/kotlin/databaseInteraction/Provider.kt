package databaseInteraction

import Task_Management_Dungeon.Database
import app.cash.sqldelight.db.SqlDriver
import data.QuestionDataSource
import data.QuestionDataSourceImpl

object Provider {
    fun provideQuestionDataSource(driver : SqlDriver): QuestionDataSource {
        return QuestionDataSourceImpl(Database(driver))
    }
}