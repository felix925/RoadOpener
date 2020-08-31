package jp.making.felix.roadopener.ui

import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import jp.making.felix.roadopener.ModelsRoadBindingModel_
import jp.making.felix.roadopener.data.Entity.RoadEntity
import jp.making.felix.roadopener.ui.util.withModelsFrom

class RoadController(
    private val onClick: (RoadEntity) -> Unit
) : TypedEpoxyController<List<RoadEntity>>() {
    override fun buildModels(road: List<RoadEntity>) {
        carousel {
            id("carousel")
            numViewsToShowOnScreen(2.75f)
            withModelsFrom(road) {
                ModelsRoadBindingModel_()
                    .id(it.id)
                    .title(it.title)
                    .onClick { _ ->
                        onClick.invoke(it)
                    }
            }
        }
    }
}