package org.hxl.model

data class Character(
    val id: Int,
    val name: String,
    val gender: String,
    val starships: Int,
    var isFavorite: Boolean = false,
    val films: List<Int> = mutableListOf()
)