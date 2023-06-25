package org.hxl.data

import org.hxl.model.Film
import org.hxl.model.FilmInfo

fun MutableList<Film>.toInfo(): FilmInfo {
    return FilmInfo(
        map { it.id },
        joinToString { it.title },
        distinctBy { it.director }.joinToString{ it.director },
        distinctBy { it.producer }.joinToString{ it.producer }
    )
}