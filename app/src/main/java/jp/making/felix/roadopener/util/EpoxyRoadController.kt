package jp.making.felix.roadopener.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import com.airbnb.epoxy.TypedEpoxyController
import jp.making.felix.roadopener.data.Entity.RoadEntity
import jp.making.felix.roadopener.modelsRoad
import jp.making.felix.roadopener.viewModel.RoadListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

@ExperimentalCoroutinesApi
class EpoxyRoadController constructor(
    lifecycleOwner: LifecycleOwner,
    viewModel: RoadListViewModel,
    private val clickRoad: ClickRoadListener
) : TypedEpoxyController<List<RoadEntity>>() {
    init {
        viewModel.roadData.observe(lifecycleOwner, ::Loggers)
    }

    override fun buildModels(data: List<RoadEntity>) {
        data.forEach {
            modelsRoad {
                id(it.id)
                title(it.title)
                complete(it.complete)
                notComplete(it.pathCount - it.complete)
                onClick { _ ->
                    clickRoad.onClick(it.id)
                }
            }
        }
    }

    fun Loggers(data: List<RoadEntity>) {
        Timber.d(data.toString(), "observe_Logger")
        setData(data)
    }
}

interface ClickRoadListener {
    fun onClick(roadId: Int)
}