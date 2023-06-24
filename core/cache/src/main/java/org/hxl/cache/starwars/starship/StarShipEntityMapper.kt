package org.hxl.cache.starwars.starship

import org.hxl.model.StarShip

fun StarShipEntity.mapToModel(): StarShip {
    return StarShip(id, name, model, manufacturer, passengers, isFavorite)
}

fun StarShip.mapToEntity(): StarShipEntity {
    return StarShipEntity(id, name, model, manufacturer, passengers, isFavorite)
}
