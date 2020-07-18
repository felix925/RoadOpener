package jp.making.felix.roadopener.data.Repository

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton
import jp.making.felix.roadopener.data.DataBase.DataBase


@Singleton
class RoadRepository @Inject constructor(
    private val database: DataBase
) {
    fun log(){
        Log.d("HASH_DB", database.toString())
    }
}