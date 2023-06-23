package org.hxl.model

data class Character(
    val name: String,
    val gender: String,
    val starships: Int,
    var isBookmarked: Boolean = false,
    val films: List<Film> = mutableListOf()
)