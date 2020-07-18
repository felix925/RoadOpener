package jp.making.felix.roadopener.data.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "path",
    foreignKeys = [
        ForeignKey(
            entity = RoadEntity::class,
            parentColumns = ["id"],
            childColumns = ["parentId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PathEntity (
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "parentId")
    val parentRoad: Int,
    @ColumnInfo(name = "isComplete")
    var isComplete: Boolean
){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}