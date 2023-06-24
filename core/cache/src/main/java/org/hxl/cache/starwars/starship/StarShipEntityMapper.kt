package org.hxl.cache.starwars.starship

import org.hxl.model.StarShip

fun StarShipEntity.mapToModel(): StarShip {
    if (films == "") {
        StarShip(id, name, model, manufacturer, passengers, isFavorite)
    }
    return StarShip(id, name, model, manufacturer, passengers, isFavorite, films.split(",").map { it.toInt() })
}

fun StarShip.mapToEntity(): StarShipEntity {
    return StarShipEntity(id, name, model, manufacturer, passengers, isFavorite, films.joinToString(","))
}
