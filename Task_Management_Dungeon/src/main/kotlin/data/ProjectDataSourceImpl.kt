package data

import Task_Management_Dungeon.Database
import db.Project

class ProjectDataSourceImpl(db: Database): ProjectDataSource {
    override suspend fun getProjectById(id: Long): Project {
        TODO("Not yet implemented")
    }

    override suspend fun insertProject(name: String, id: Long?) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteProjectById(id: Long) {
        TODO("Not yet implemented")
    }
}