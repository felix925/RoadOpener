package jp.making.felix.roadopener.data.Entity

import androidx.room.Embedded
import androidx.room.Relation

data class RoadAndPath (
    @Embedded
    var road: RoadEntity,
    @Relation(parentColumn = "roadId", entityColumn = "parentId")
    var path: List<PathEntity>
)