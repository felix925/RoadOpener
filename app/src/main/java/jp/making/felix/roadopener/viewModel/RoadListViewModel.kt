package jp.making.felix.roadopener.viewModel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import jp.making.felix.roadopener.data.Repository.RoadRepository

class RoadListViewModel @ViewModelInject constructor(
    private val repo: RoadRepository
): ViewModel() {
    fun hash() {
        Log.d("HASH", repo.toString())
        repo.log()
    }
}