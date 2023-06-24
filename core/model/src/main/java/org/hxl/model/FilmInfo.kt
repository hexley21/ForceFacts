package org.hxl.model

data class FilmInfo(
    val ids: List<Int> = emptyList(),
    val films: String = "",
    val directors: String = "",
    val producers: String = ""
)