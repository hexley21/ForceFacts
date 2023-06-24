package org.hxl.cache.starwars.character

import org.hxl.cache.starwars.film.FilmEntity
import org.hxl.cache.starwars.film.mapToModel
import org.hxl.model.Character
import org.hxl.model.Film

fun CharacterEntity.mapToModel(films: List<FilmEntity> = emptyList()): Character {
    return Character(id, name, gender, starships, isFavorite, films.map { it.mapToModel() })
}

fun Character.mapToEntity(films: List<Film>): CharacterEntity {
    return CharacterEntity(id, name, gender, starships, isFavorite, films.map { it.id }.joinToString(","))
}