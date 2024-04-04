package data

import Task_Management_Dungeon.Database
import db.Project
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProjectDataSourceImpl(db: Database): ProjectDataSource {
    private val queries = db.projectQueries
    override suspend fun getProjectById(id: Long): Project? {
        return withContext(Dispatchers.IO){
            queries.getProjectById(id).executeAsOneOrNull()
        }
    }

    override suspend fun insertProject(name: String, id: Long?) {
        return withContext(Dispatchers.IO){
            queries.insertProject(id,name)
        }
    }

    override suspend fun deleteProjectById(id: Long) {
        return withContext(Dispatchers.IO){
            queries.deleteProjectById(id)
        }
    }
}