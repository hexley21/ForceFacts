package org.hxl.network.mapper

import org.hxl.model.Film
import org.hxl.network.model.FilmDTO

fun FilmDTO.mapToModel(): Film {
    return Film(
        parseUrl(url),
        title,
        director,
        producer,
    )
}