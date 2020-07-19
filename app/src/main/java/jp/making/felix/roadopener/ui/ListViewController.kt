package jp.making.felix.roadopener.ui

import com.airbnb.epoxy.Typed2EpoxyController
import jp.making.felix.roadopener.data.Entity.RoadEntity

class ListViewController():Typed2EpoxyController<List<RoadEntity>, Boolean>() {
    override fun buildModels(road: List<RoadEntity>, data2: Boolean?) {
        road.forEach {
            
        }
    }
}