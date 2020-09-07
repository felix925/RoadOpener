package jp.making.felix.roadopener.util

import jp.making.felix.roadopener.data.Entity.PathEntity

fun ConvertToPath(data: PathEntity) = Path(
    title = data.title,
    isComplete = data.isComplete
)