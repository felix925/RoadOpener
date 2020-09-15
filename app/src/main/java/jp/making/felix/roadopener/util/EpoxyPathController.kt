package jp.making.felix.roadopener.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.TypedEpoxyController
import jp.making.felix.roadopener.ModelsPathBindingModelBuilder
import jp.making.felix.roadopener.ModelsPathBindingModel_
import jp.making.felix.roadopener.data.Entity.PathEntity
import jp.making.felix.roadopener.viewModel.DetailViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class EpoxyPathController constructor(
    lifecycleOwner: LifecycleOwner,
    viewModel: DetailViewModel,
    private val roadId: Int,
    private val clickRoad: ClickPathListener
) : TypedEpoxyController<List<PathEntity>>() {
    init {
        viewModel.getPath(roadId).observe(lifecycleOwner, ::setData)
    }

    override fun buildModels(data: List<PathEntity>) {
        data.forEach {
            modelsPath {
                id(it.id)
                title(it.title)
                onClick { _ ->
                    clickRoad.onClick(it.id)
                }
                isComplete(it.isComplete)
            }
        }
    }
}

interface ClickPathListener {
    fun onClick(pathId: Int)
}

inline fun EpoxyController.modelsPath(modelInitializer: ModelsPathBindingModelBuilder.() -> Unit) {
    ModelsPathBindingModel_().apply {
        modelInitializer()
    }
        .addTo(this)
}