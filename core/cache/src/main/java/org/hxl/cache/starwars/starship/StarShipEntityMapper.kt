package org.hxl.cache.starwars.starship

import org.hxl.model.StarShip

fun StarShipEntity.mapToModel(): StarShip {
    return StarShip(id, name, model, manufacturer, passengers, isFavorite)
}

fun StarShip.mapToEntity(films: List<Int>): StarShipEntity {
    return StarShipEntity(id, name, model, manufacturer, passengers, isFavorite, films)
}