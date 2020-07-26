package jp.making.felix.roadopener.ui.util

import com.airbnb.epoxy.CarouselModelBuilder
import com.airbnb.epoxy.EpoxyModel

inline fun <T> CarouselModelBuilder.withModelsFrom(
    items: List<T>,
    modelBuilder: (T) -> EpoxyModel<*>
) {
    models(items.map { modelBuilder(it) })
}