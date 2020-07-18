package jp.making.felix.roadopener.data.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "path"
)
data class PathEntity (
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "isComplete")
    val isComplete: Boolean
){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}