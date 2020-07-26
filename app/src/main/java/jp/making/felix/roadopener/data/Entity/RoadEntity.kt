package jp.making.felix.roadopener.data.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "road")
data class RoadEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "roadId")
    var id: Int = 0,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val desc:String
)