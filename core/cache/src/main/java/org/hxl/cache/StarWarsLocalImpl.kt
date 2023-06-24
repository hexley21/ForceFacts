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
import javax.inject.Inject

class StarWarsLocalImpl @Inject constructor(
    private val characterDao: CharacterDAO,
    private val starShipDao: StarShipDAO,
    private val filmDao: FilmDAO
): StarWarsLocal {
    override fun getCharacters(offset: Int): Flow<List<Character>> {
        return characterDao.getCharacters(offset).map { it.map { entity -> entity.mapToModel() } }
    }

    override fun getCharacterById(id: Int): Flow<Character> {
        return characterDao.getCharacterById(id).map { it.mapToModel() }
    }

    override suspend fun favoriteCharacter(id: Int) {
        characterDao.favoriteCharacter(id)
    }

    override suspend fun unFavoriteCharacter(id: Int) {
        characterDao.unFavoriteCharacter(id)
    }

    override fun getFavoriteCharacters(offset: Int): Flow<List<Character>> {
        return characterDao.getFavoriteCharacters(offset).map { it.map { entity -> entity.mapToModel() } }
    }

    override suspend fun insertCharacter(vararg character: Character) {
        characterDao.insertCharacter(*character.map { it.mapToEntity(it.films.map { film -> film.id })}.toTypedArray())
    }

    override fun getStarShips(offset: Int): Flow<List<StarShip>> {
        return starShipDao.getStarShips(offset).map { it.map { entity -> entity.mapToModel() } }
    }

    override fun getStarShipById(id: Int): Flow<StarShip> {
        return starShipDao.getStarShipById(id).map { it.mapToModel() }
    }

    override suspend fun favoriteStarShip(id: Int) {
        starShipDao.favoriteStarShip(id)
    }

    override suspend fun unFavoriteStarShip(id: Int) {
        starShipDao.unFavoriteStarShip(id)
    }

    override fun getFavoriteStarShips(offset: Int): Flow<List<StarShip>> {
        return starShipDao.getFavoriteStarShips(offset).map { it.map { entity -> entity.mapToModel() } }
    }

    override suspend fun insertStarShip(vararg starShip: StarShip) {
        starShipDao.insertStarShip(*starShip.map { it.mapToEntity(it.films.map { film -> film.id })}.toTypedArray())
    }

    override fun getFilms(offset: Int): Flow<List<Film>> {
        return filmDao.getFilms(offset).map { it.map { entity -> entity.mapToModel() } }
    }

    override fun getFilmById(id: Int): Flow<Film> {
        return filmDao.getFilmById(id).map { entity -> entity.mapToModel() } }

    override suspend fun insertFilm(vararg film: Film) {
        filmDao.insertFilm(*film.map { it.mapToEntity() }.toTypedArray())
    }
}