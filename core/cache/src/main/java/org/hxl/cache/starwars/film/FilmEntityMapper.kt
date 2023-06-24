package org.hxl.cache.starwars.film

import org.hxl.model.Film

fun FilmEntity.mapToModel(): Film {
    return Film(id, title, director, producer)
}

fun Film.mapToEntity(): FilmEntity {
    return FilmEntity(id, title, director, producer)
}