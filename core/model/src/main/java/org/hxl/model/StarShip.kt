package org.hxl.model

data class StarShip(
    val id: Int,
    val name: String,
    val model: String,
    val manufacturer: String,
    val passengers: String,
    var isFavorite: Boolean = false,
    var filmInfo: FilmInfo = FilmInfo()
)