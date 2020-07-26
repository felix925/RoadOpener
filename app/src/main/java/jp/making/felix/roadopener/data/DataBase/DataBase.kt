package jp.making.felix.roadopener.data.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import jp.making.felix.roadopener.data.Dao.PathDao
import jp.making.felix.roadopener.data.Dao.RoadDao
import jp.making.felix.roadopener.data.Entity.PathEntity
import jp.making.felix.roadopener.data.Entity.RoadAndPath
import jp.making.felix.roadopener.data.Entity.RoadEntity

@Database(
    entities = [
        PathEntity::class,
        RoadEntity::class
    ], version = 1
)
abstract class DataBase : RoomDatabase() {
    abstract fun roadDao(): RoadDao
    abstract fun pathDao(): PathDao
}