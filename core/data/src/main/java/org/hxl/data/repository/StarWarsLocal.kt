package org.hxl.data.repository

import kotlinx.coroutines.flow.Flow
import org.hxl.model.Character
import org.hxl.model.Film
import org.hxl.model.StarShip

interface StarWarsLocal {
    suspend fun favoriteCharacter(id: Int)
    suspend fun unFavoriteCharacter(id: Int)
    fun getFavoriteCharacters(): Flow<List<Character>>
    suspend fun insertCharacter(character: List<Character>)
    suspend fun insertCharacter(character: Character)
    suspend fun isCharacterFavorite(id: Int): Boolean
    suspend fun isCharacterCached(id: Int): Boolean

    suspend fun favoriteStarShip(id: Int)
    suspend fun unFavoriteStarShip(id: Int)
    fun getFavoriteStarShips(): Flow<List<StarShip>>
    suspend fun insertStarShip(starShip: List<StarShip>)
    suspend fun insertStarShip(starShip: StarShip)
    suspend fun isStarShipFavorite(id: Int): Boolean
    suspend fun isStarShipCached(id: Int): Boolean

    suspend fun getFilmById(id: Int): Film
    suspend fun insertFilm(vararg film: Film)
    suspend fun isFilmCached(id: Int): Boolean
}