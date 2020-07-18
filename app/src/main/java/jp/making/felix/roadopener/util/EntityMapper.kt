package jp.making.felix.roadopener.util

import jp.making.felix.roadopener.Path
import jp.making.felix.roadopener.data.Entity.PathEntity
import jp.making.felix.roadopener.data.Entity.RoadEntity
import jp.making.felix.roadopener.data.Road

fun Path.toEntity() = PathEntity(this.title, this.isComplete)
fun Road.toEntity() = RoadEntity(this.title, this.desc)