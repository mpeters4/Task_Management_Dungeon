package data

import db.Question
import db.Tag
import kotlinx.coroutines.flow.Flow

interface TagDataSource {

    suspend fun getTagById(id: Long): Tag?

    fun getAllTags(): Flow<List<Tag>>

    suspend fun insertTag(tag: String, id: Long? = null)

    suspend fun deleteTagById(id: Long)
}