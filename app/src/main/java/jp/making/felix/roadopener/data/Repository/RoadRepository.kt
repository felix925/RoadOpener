package jp.making.felix.roadopener.data.Repository

import android.util.Log
import jp.making.felix.roadopener.data.Dao.PathDao
import jp.making.felix.roadopener.data.Dao.RoadDao
import javax.inject.Inject
import javax.inject.Singleton
import jp.making.felix.roadopener.data.DataBase.DataBase
import jp.making.felix.roadopener.data.Entity.PathEntity
import jp.making.felix.roadopener.data.Entity.RoadEntity


class RoadRepository @Inject constructor(
    private val pathDao: PathDao,
    private val roadDao: RoadDao
) {
    fun loadAllData() = roadDao.getAll()
    fun loadAllRoad() = roadDao.getAllRoad()
    fun insertRoad(roadEntity: RoadEntity) = roadDao.insertRoad(roadEntity)
    fun deleteRoad(roadEntity: RoadEntity) = roadDao.deleteRoad(roadEntity)
    fun updateRoad(roadEntity: RoadEntity) = roadDao.updateRoad(roadEntity)

    fun loadAllPath() = pathDao.getAll()
    fun getPathById(id: Int): List<PathEntity> {
        return pathDao.getPathById(id)
    }
    fun insertPath(pathEntity: PathEntity) = pathDao.insertPath(pathEntity)
    fun deletePath(pathEntity: PathEntity) = pathDao.deletePath(pathEntity)
    fun updatePath(pathEntity: PathEntity) = pathDao.updatePath(pathEntity)
}