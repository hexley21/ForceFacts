package org.hxl.model

data class StarShip(
    val name: String,
    val model: String,
    val manufacturer: String,
    val passengers: Double,
    var isBookmarked: Boolean = false,
    val films: List<Film> = mutableListOf()
)