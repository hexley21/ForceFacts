package org.hxl.domain.repository

import kotlinx.coroutines.flow.Flow
import org.hxl.model.Character
import org.hxl.model.FilmInfo
import org.hxl.model.StarShip

interface StarWarsRepository {
    suspend fun searchCharacters(query: String, page: Int): List<Character>
    suspend fun favoriteCharacter(id: Int)
    suspend fun unFavoriteCharacter(id: Int)
    fun getFavoriteCharacters(): Flow<List<Character>>

    suspend fun searchStarShips(query: String, page: Int): List<StarShip>
    suspend fun favoriteStarShip(id: Int)
    suspend fun unFavoriteStarShip(id: Int)
    fun getFavoriteStarShips(): Flow<List<StarShip>>

    suspend fun getFilmInfo(id: List<Int>): FilmInfo
}