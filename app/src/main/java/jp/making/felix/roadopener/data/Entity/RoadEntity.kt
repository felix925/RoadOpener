package jp.making.felix.roadopener.data.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "road"
)
data class RoadEntity(
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val desc:String
){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}