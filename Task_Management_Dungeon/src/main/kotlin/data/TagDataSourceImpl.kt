package data

import Task_Management_Dungeon.Database
import db.Tag
import kotlinx.coroutines.flow.Flow

class TagDataSourceImpl(db : Database): TagDataSource {
    override suspend fun getTagById(id: Long): Tag? {
        TODO("Not yet implemented")
    }

    override fun getAllTags(): Flow<List<Tag>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertTag(tag: String, id: Long?) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTagById(id: Long) {
        TODO("Not yet implemented")
    }
}