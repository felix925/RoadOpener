package jp.making.felix.roadopener.viewModel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.airbnb.lottie.L
import jp.making.felix.roadopener.data.Entity.PathEntity
import jp.making.felix.roadopener.data.Entity.RoadEntity
import jp.making.felix.roadopener.data.Repository.RoadRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class RoadListViewModel @ViewModelInject constructor(
    private val repo: RoadRepository
): ViewModel() {
    val roadData: LiveData<List<RoadEntity>> = repo.loadAllRoad().asLiveData()
    val pathData: LiveData<List<PathEntity>> = repo.loadAllPath().asLiveData()
    fun hash() {
        Log.d("HASH", repo.toString())
    }
}