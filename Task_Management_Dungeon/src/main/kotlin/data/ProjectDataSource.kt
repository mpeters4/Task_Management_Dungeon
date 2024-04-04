package data

import db.Project

interface ProjectDataSource {

    suspend fun getProjectById(id: Long): Project?

    suspend fun insertProject(name: String, id: Long? = null)

    suspend fun deleteProjectById(id: Long)

}