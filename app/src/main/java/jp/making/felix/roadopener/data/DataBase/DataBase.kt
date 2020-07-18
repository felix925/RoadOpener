package jp.making.felix.roadopener.data.DataBase

import androidx.room.Database
import jp.making.felix.roadopener.data.Entity.PathEntity
import jp.making.felix.roadopener.data.Entity.RoadEntity

@Database(entities = [
    PathEntity::class,
    RoadEntity::class
], version = 0)
abstract class DataBase {
}