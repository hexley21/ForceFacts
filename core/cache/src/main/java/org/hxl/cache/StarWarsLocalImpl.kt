package org.hxl.cache

import android.util.Log
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
    companion object {
        const val TAG = "STAR_WARS_DB"
    }

    override suspend fun getCharacters(offset: Int): List<Character> {
        Log.d(TAG, "getCharacters: offset:$offset")
        return characterDao.getCharacters(offset).map { it.mapToModel() }
    }

    override suspend fun favoriteCharacter(id: Int) {
        characterDao.favoriteCharacter(id)
        Log.d(TAG, "favoriteCharacter: $id")
    }

    override suspend fun unFavoriteCharacter(id: Int) {
        characterDao.unFavoriteCharacter(id)
        Log.d(TAG, "unFavoriteCharacter: $id")
    }

    override fun getFavoriteCharacters(): Flow<List<Character>> {
        Log.d(TAG, "getFavoriteCharacters")
        return characterDao.getFavoriteCharacters().map { it.map {
            entity -> entity.mapToModel()
        }}
    }

    override suspend fun insertCharacter(character: List<Character>) {
        val characters = character.map { it.mapToEntity(it.filmInfo.ids) }
        characterDao.insertCharacter(*characters.toTypedArray())
        Log.d(TAG, "inserted characters: ${characters.size}")
    }

    override suspend fun insertCharacter(character: Character) {
        characterDao.insertCharacter(character.mapToEntity(character.filmInfo.ids))
        Log.d(TAG, "insertCharacter: id{${character.id}}")
    }

    override suspend fun isCharacterFavorite(id: Int): Boolean {
        Log.d(TAG, "isCharacterFavorite: $id")
        return characterDao.isFavorite(id)
    }

    override suspend fun isCharacterCached(id: Int): Boolean {
        Log.d(TAG, "isCharacterCached: $id")
        return characterDao.isCached(id)
    }

    override suspend fun getStarShips(offset: Int): List<StarShip> {
        Log.d(TAG, "getStarShips: $offset")
        return starShipDao.getStarShips(offset).map { it.mapToModel() }
    }

    override suspend fun favoriteStarShip(id: Int) {
        starShipDao.favoriteStarShip(id)
        Log.d(TAG, "favoriteStarShip: $id")
    }

    override suspend fun unFavoriteStarShip(id: Int) {
        starShipDao.unFavoriteStarShip(id)
        Log.d(TAG, "unFavoriteStarShip: $id")
    }

    override fun getFavoriteStarShips(): Flow<List<StarShip>> {
        Log.d(TAG, "getFavoriteStarShips")
        return starShipDao.getFavoriteStarShips().map { it.map { entity -> entity.mapToModel() } }
    }

    override suspend fun insertStarShip(starShip: List<StarShip>) {
        starShipDao.insertStarShip(*starShip.map { it.mapToEntity(it.filmInfo.ids) }.toTypedArray())
        Log.d(TAG, "inserted StarShips: ${starShip.size}")
    }

    override suspend fun insertStarShip(starShip: StarShip) {
        starShipDao.insertStarShip(starShip.mapToEntity(starShip.filmInfo.ids))
        Log.d(TAG, "insertStarShip: id{${starShip.id}}")
    }

    override suspend fun isStarShipFavorite(id: Int): Boolean {
        Log.d(TAG, "isStarShipFavorite: $id")
        return starShipDao.isFavorite(id)
    }

    override suspend fun isStarShipCached(id: Int): Boolean {
        Log.d(TAG, "isStarShipCached: $id")
        return starShipDao.isCached(id)
    }

    override suspend fun getFilmById(id: Int): Film {
        Log.d(TAG, "getFilmById: $id")
        return filmDao.getFilmById(id).mapToModel()
    }

    override suspend fun insertFilm(vararg film: Film) {
        filmDao.insertFilm(*film.map { it.mapToEntity() }.toTypedArray())
        Log.d(TAG, "inserted Films: ${film.size}")
    }

    override suspend fun isFilmCached(id: Int): Boolean {
        return filmDao.isCached(id)
    }
}