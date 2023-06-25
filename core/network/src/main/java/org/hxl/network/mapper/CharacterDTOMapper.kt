package org.hxl.network.mapper

import org.hxl.model.Character
import org.hxl.model.FilmInfo
import org.hxl.network.model.CharacterDTO

fun CharacterDTO.mapToModel(): Character {
    return Character(
        parseUrl(url),
        name,
        gender,
        starships?.size ?: 0,
        false,
        FilmInfo(
            films.map { parseUrl(it) }
        )
    )
}
