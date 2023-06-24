package org.hxl.cache.starwars.character

import org.hxl.model.Character

fun CharacterEntity.mapToModel(): Character {
    return Character(id, name, gender, starships, isFavorite)
}

fun Character.mapToEntity(ids: List<Int>): CharacterEntity {
    return CharacterEntity(id, name, gender, starships, isFavorite, ids)
}