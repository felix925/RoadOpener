package jp.making.felix.roadopener.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import jp.making.felix.roadopener.data.Entity.RoadEntity
import jp.making.felix.roadopener.data.Repository.RoadRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import timber.log.Timber

@ExperimentalCoroutinesApi
class RoadListViewModel @ViewModelInject constructor(
    private val repo: RoadRepository
) : ViewModel() {
    val roadData: LiveData<List<RoadEntity>> =
        repo.loadAllRoad().asLiveData()

    private val _refreshRoadData: MutableLiveData<List<RoadEntity>> = MutableLiveData()
    val refreshRoadData: LiveData<List<RoadEntity>>
        get() = _refreshRoadData

    private val _inputErrorText: MutableLiveData<String> = MutableLiveData()
    val inputErrorText: LiveData<String>
        get() = _inputErrorText

    fun insertRoad(title: String) {
        if (title.isEmpty()) {
            _inputErrorText.value = "目標を入力してください"
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertRoad(
                RoadEntity(
                    title = title,
                    complete = 0,
                    pathCount = 0
                )
            )
        }
    }

    fun refreshAllRoadData() {
        viewModelScope.launch(Dispatchers.IO) {
            Timber.d("CallRefresh")
            _refreshRoadData.postValue(repo.refreshGetAllRoad())
        }
    }
}