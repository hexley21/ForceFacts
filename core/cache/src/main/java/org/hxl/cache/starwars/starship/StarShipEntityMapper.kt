package org.hxl.cache.starwars.starship

import org.hxl.model.FilmInfo
import org.hxl.model.StarShip

fun StarShipEntity.mapToModel(): StarShip {
    if (films == "") {
        StarShip(id, name, model, manufacturer, passengers, isFavorite)
    }
    return StarShip(id, name, model, manufacturer, passengers, isFavorite, FilmInfo(films.split(",").map { it.toInt() }))
}

fun StarShip.mapToEntity(films: List<Int>): StarShipEntity {
    return StarShipEntity(id, name, model, manufacturer, passengers, isFavorite, films.joinToString(","))
}
