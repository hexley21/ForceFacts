package org.hxl.data.repository

import kotlinx.coroutines.flow.Flow
import org.hxl.model.Character
import org.hxl.model.Film
import org.hxl.model.StarShip

interface StarWarsLocal {
    fun getCharacters(offset: Int): Flow<List<Character>>
    fun getCharacterById(id: Int): Flow<Character>
    suspend fun favoriteCharacter(id: Int)
    suspend fun unFavoriteCharacter(id: Int)
    fun getFavoriteCharacters(offset: Int): Flow<List<Character>>
    suspend fun insertCharacter(vararg character: Character)

    fun getStarShips(offset: Int): Flow<List<StarShip>>
    fun getStarShipById(id: Int): Flow<StarShip>
    suspend fun favoriteStarShip(id: Int)
    suspend fun unFavoriteStarShip(id: Int)
    fun getFavoriteStarShips(offset: Int): Flow<List<StarShip>>
    suspend fun insertStarShip(vararg starShip: StarShip)

    fun getFilms(offset: Int): Flow<List<Film>>
    fun getFilmById(id: Int): Flow<Film>
    suspend fun insertFilm(vararg film: Film)
}