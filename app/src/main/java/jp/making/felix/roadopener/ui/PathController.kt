package jp.making.felix.roadopener.ui

import com.airbnb.epoxy.TypedEpoxyController
import jp.making.felix.roadopener.data.Entity.PathEntity
import jp.making.felix.roadopener.modelsPath
import kotlinx.coroutines.withContext

class PathController(
    private val onClick: (PathEntity) -> Unit
) : TypedEpoxyController<List<PathEntity>>() {
    override fun buildModels(path: List<PathEntity>) {
        path.forEach {
            modelsPath {
                id(it.id)
                title(it.title)
                isComplete(it.isComplete)
                onClick { _ ->
                    onClick.invoke(it)
                }
            }
        }
    }
}