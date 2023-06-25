package org.hxl.network.mapper

import org.hxl.model.FilmInfo
import org.hxl.model.StarShip
import org.hxl.network.model.StarShipDTO

fun StarShipDTO.mapToModel(): StarShip {
    return StarShip(
        parseUrl(url),
        name,
        model,
        manufacturer,
        passengers,
        false,
        FilmInfo(films.map { parseUrl(it) })
    )
}