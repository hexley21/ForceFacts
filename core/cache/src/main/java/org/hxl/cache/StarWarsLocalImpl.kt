package org.hxl.cache

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.hxl.cache.starwars.character.CharacterDAO
import org.hxl.cache.starwars.character.mapToEntity
import org.hxl.cache.starwars.character.mapToModel
import org.hxl.cache.starwars.film.FilmDAO
import org.hxl.cache.starwars.film.mapToEntity
import org.hxl.cache.starwars.film.mapToModel
import org.hxl.cache.starwars.starship.StarShipDAO
import org.hxl.cache.starwars.starship.mapToEntity
import org.hxl.cache.starwars.starship.mapToModel
import org.hxl.data.repository.StarWarsLocal
import org.hxl.model.Character
import org.hxl.model.Film
import org.hxl.model.StarShip

class StarWarsLocalImpl(
    private val characterDao: CharacterDAO,
    private val starShipDao: StarShipDAO,
    private val filmDao: FilmDAO
): StarWarsLocal {
    override suspend fun getCharacters(offset: Int): List<Character> {
        return characterDao.getCharacters(offset).map { it.mapToModel() } }

    override suspend fun getCharacterById(id: Int): Character {
        return characterDao.getCharacterById(id).mapToModel()
    }

    override suspend fun favoriteCharacter(id: Int) {
        characterDao.favoriteCharacter(id)
    }

    override suspend fun unFavoriteCharacter(id: Int) {
        characterDao.favoriteCharacter(id)
    }

    override fun getFavoriteCharacters(): Flow<List<Character>> {
        return characterDao.getFavoriteCharacters().map { it.map {
            entity -> entity.mapToModel(entity.films.split(",").map { id -> getFilmById(id.toInt()).mapToEntity() })
        }}
    }

    override suspend fun insertCharacter(vararg character: Character) {
        characterDao.insertCharacter(*character.map { it.mapToEntity(it.films) }.toTypedArray())
    }

    override suspend fun getStarShips(offset: Int): List<StarShip> {
        return starShipDao.getStarShips(offset).map { it.mapToModel() }
    }

    override suspend fun getStarShipById(id: Int): StarShip {
        return starShipDao.getStarShipById(id).mapToModel()
    }

    override suspend fun favoriteStarShip(id: Int) {
        starShipDao.favoriteStarShip(id)
    }

    override suspend fun unFavoriteStarShip(id: Int) {
        starShipDao.unFavoriteStarShip(id)
    }

    override fun getFavoriteStarShips(): Flow<List<StarShip>> {
        return starShipDao.getFavoriteStarShips().map { it.map { entity -> entity.mapToModel() } }
    }

    override suspend fun insertStarShip(vararg starShip: StarShip) {
        starShipDao.insertStarShip(*starShip.map { it.mapToEntity() }.toTypedArray())
    }

    override suspend fun getFilms(): List<Film> {
        return filmDao.getFilms().map { it.mapToModel() }
    }

    override suspend fun getFilmById(id: Int): Film {
        return filmDao.getFilmById(id).mapToModel()
    }

    override suspend fun insertFilm(vararg film: Film) {
        filmDao.insertFilm(*film.map { it.mapToEntity() }.toTypedArray())
    }
}