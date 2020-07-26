package jp.making.felix.roadopener.data.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "path")
data class PathEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pathId")
    var id: Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "parentId")
    val parentId: Int,
    @ColumnInfo(name = "isComplete")
    var isComplete: Boolean
)