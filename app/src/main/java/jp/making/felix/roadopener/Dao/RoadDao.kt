package jp.making.felix.roadopener.Dao

import androidx.room.*
import jp.making.felix.roadopener.data.Entity.RoadEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RoadDao {
    @Query("SELECT * FROM roadentity")
    fun getAll(): Flow<List<RoadEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRoad(vararg road: RoadEntity)

    @Delete
    fun deleteRoad(vararg road: RoadEntity)

    @Update
    fun updateRoad(vararg road: RoadEntity)

}