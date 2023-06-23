package org.hxl.network.mapper

import org.hxl.model.StarShip
import org.hxl.network.model.StarShipDTO

fun StarShipDTO.mapToModel(): StarShip {
    return StarShip(
        name,
        model,
        manufacturer,
        passengers
    )
}