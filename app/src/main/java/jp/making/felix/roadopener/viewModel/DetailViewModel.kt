package jp.making.felix.roadopener.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import jp.making.felix.roadopener.data.Entity.PathEntity
import jp.making.felix.roadopener.data.Repository.RoadRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel @ViewModelInject constructor(
    private val repo: RoadRepository
) : ViewModel() {

    private val _inputErrorText: MutableLiveData<String> = MutableLiveData()
    val inputErrorText
        get() = _inputErrorText

    fun getPath(roadId: Int) = repo.getPathByParentId(roadId).asLiveData()

    fun updatePathData(roadId: Int, pathId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val road = repo.getRoadById(roadId)
            val path = repo.getPathById(pathId)
            if (!path.isComplete) road.complete++ else road.complete--
            path.isComplete = !path.isComplete

            repo.updateRoad(road)
            repo.updatePath(path)
        }
    }

    fun insertPath(roadId: Int, title: String) {
        if (title.isEmpty()) {
            _inputErrorText.value = "Todoを入力してください"
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            val road = repo.getRoadById(roadId)
            repo.insertPath(
                PathEntity(
                    title = title,
                    parentId = road.id,
                    isComplete = false
                )
            )
            road.pathCount += 1
            repo.updateRoad(road)
        }
    }
}