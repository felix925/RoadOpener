package jp.making.felix.roadopener.data.Dao

import androidx.room.*
import jp.making.felix.roadopener.data.Entity.PathEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PathDao {
    @Query("SELECT * FROM path")
    fun getAll(): Flow<List<PathEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPath(vararg path: PathEntity)

    @Delete
    fun deletePath(vararg path: PathEntity)

    @Update
    fun updatePath(vararg path: PathEntity)

}