package data

import Task_Management_Dungeon.Database
import db.Dependency
import kotlinx.coroutines.flow.Flow

class DependencyDataSourceImpl(db: Database): DependencyDataSource {
    override suspend fun getDependencyById(id: Long): Dependency? {
        TODO("Not yet implemented")
    }

    override fun getAllDependenciesByProjectId(projectId: Long): Flow<List<Dependency>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertDependency(
        questionAId: Long,
        questionBId: Long,
        projectId: Long,
        position: Long,
        dependency: String,
        id: Long?
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDependencyById(id: Long) {
        TODO("Not yet implemented")
    }
}