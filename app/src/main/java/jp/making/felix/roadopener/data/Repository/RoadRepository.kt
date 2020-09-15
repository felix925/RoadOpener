package jp.making.felix.roadopener.data.Repository

import jp.making.felix.roadopener.data.Dao.PathDao
import jp.making.felix.roadopener.data.Dao.RoadDao
import jp.making.felix.roadopener.data.Entity.PathEntity
import jp.making.felix.roadopener.data.Entity.RoadEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class RoadRepository @Inject constructor(
    private val pathDao: PathDao,
    private val roadDao: RoadDao
) {
    // GET
    fun loadAllData() = roadDao.getAll()
    fun loadAllRoad() = roadDao.getAllRoad()
    fun loadAllPath() = pathDao.getAll()
    fun getPathByParentId(id: Int): Flow<List<PathEntity>> = pathDao.getPathByParentId(id)
    fun getPathById(id: Int): PathEntity = pathDao.getPathById(id)
    fun getRoadById(id: Int): RoadEntity = roadDao.getRoadById(id)
    fun refreshGetAllRoad(): List<RoadEntity> = roadDao.refreshGetAllRoad()

    // INSERT
    fun insertRoad(roadEntity: RoadEntity) = roadDao.insertRoad(roadEntity)
    fun insertPath(pathEntity: PathEntity) = pathDao.insertPath(pathEntity)

    // DELETE
    fun deleteRoad(roadEntity: RoadEntity) = roadDao.deleteRoad(roadEntity)
    fun deletePath(pathEntity: PathEntity) = pathDao.deletePath(pathEntity)

    // UPDATE
    fun updateRoad(roadEntity: RoadEntity) = roadDao.updateRoad(roadEntity)
    fun updatePath(pathEntity: PathEntity) = pathDao.updatePath(pathEntity)
}