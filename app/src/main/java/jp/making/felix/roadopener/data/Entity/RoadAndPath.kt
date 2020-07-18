package jp.making.felix.roadopener.data.Entity

import androidx.room.Embedded
import androidx.room.Relation

class RoadAndPath {
    @Embedded
    lateinit var road: RoadEntity
    @Relation(parentColumn = "id", entityColumn = "parentId")
    lateinit var path: List<PathEntity>
}