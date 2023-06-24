package org.hxl.cache.starwars.character

import org.hxl.model.Character
import org.hxl.model.FilmInfo

fun CharacterEntity.mapToModel(): Character {
    if (films == "") {
        return Character(id, name, gender, starships, isFavorite)
    }
    return Character(id, name, gender, starships, isFavorite, FilmInfo(films.split(",").map { it.toInt() }) )
}

fun Character.mapToEntity(films: List<Int>): CharacterEntity {
    return CharacterEntity(id, name, gender, starships, isFavorite, films.joinToString(","))
}