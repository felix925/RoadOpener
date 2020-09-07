package jp.making.felix.roadopener.viewModel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import jp.making.felix.roadopener.data.Entity.PathEntity
import jp.making.felix.roadopener.data.Entity.RoadEntity
import jp.making.felix.roadopener.data.Repository.RoadRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class RoadListViewModel @ViewModelInject constructor(
    private val repo: RoadRepository
) : ViewModel() {
    val roadData: LiveData<List<RoadEntity>> =
        repo.loadAllRoad().asLiveData()
    val pathData: LiveData<List<PathEntity>> =
        repo.loadAllPath().asLiveData()

    fun insertPath(road: RoadEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertPath(
                PathEntity(
                    title = "hoge",
                    parentId = road.id,
                    isComplete = false
                )
            )
            road.pathCount += 1
            repo.updateRoad(road)
        }
        Log.d("HASH", repo.toString())
    }

    fun insertRoad() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertRoad(
                RoadEntity(
                    title = "HOGE",
                    complete = 0,
                    pathCount = 0
                )
            )
        }
    }

    fun getPathByParentRoad(id: Int) = repo.getPathById(id).asLiveData()
}