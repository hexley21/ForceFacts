package org.hxl.cache.starwars.character

import org.hxl.model.Character

fun CharacterEntity.mapToModel(): Character {
    if (films == "") {
        return Character(id, name, gender, starships, isFavorite)
    }
    return Character(id, name, gender, starships, isFavorite, films.split(",").map { it.toInt() } )
}

fun Character.mapToEntity(films: List<Int>): CharacterEntity {
    return CharacterEntity(id, name, gender, starships, isFavorite, films.joinToString(","))
}