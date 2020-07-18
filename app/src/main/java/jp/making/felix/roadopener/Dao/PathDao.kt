package jp.making.felix.Pathopener.Dao

import androidx.room.*
import jp.making.felix.roadopener.data.Entity.PathEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PathDao {
    @Query("SELECT * FROM pathentity")
    fun getAll(): Flow<List<PathEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPath(vararg path: PathEntity)

    @Delete
    fun deletePath(vararg path: PathEntity)

    @Update
    fun updatePath(vararg path: PathEntity)

}