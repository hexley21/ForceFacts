package org.hxl.data.repository

import kotlinx.coroutines.flow.Flow
import org.hxl.model.Character
import org.hxl.model.Film
import org.hxl.model.StarShip

interface StarWarsLocal {
    suspend fun getCharacters(offset: Int): List<Character>
    suspend fun getCharacterById(id: Int): Character
    suspend fun favoriteCharacter(id: Int)
    suspend fun unFavoriteCharacter(id: Int)
    fun getFavoriteCharacters(): Flow<List<Character>>
    suspend fun insertCharacter(vararg character: Character)

    suspend fun getStarShips(offset: Int): List<StarShip>
    suspend fun getStarShipById(id: Int): StarShip
    suspend fun favoriteStarShip(id: Int)
    suspend fun unFavoriteStarShip(id: Int)
    fun getFavoriteStarShips(): Flow<List<StarShip>>
    suspend fun insertStarShip(vararg starShip: StarShip)

    suspend fun getFilms(): List<Film>
    suspend fun getFilmById(id: Int): Film
    suspend fun insertFilm(vararg film: Film)
}