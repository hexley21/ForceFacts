package org.hxl.domain.repository

import org.hxl.model.Character
import org.hxl.model.StarShip

interface StarWarsRepository {
    suspend fun getCharacters(page: Int): List<Character>
    suspend fun getCharacterById(id: Int): Character
    suspend fun searchCharacters(query: String, page: Int): List<Character>
    suspend fun favoriteCharacter(id: String)
    suspend fun unFavoriteCharacter(id: String)
    suspend fun getFavoriteCharacters(): List<Character>

    suspend fun getStarShips(page: Int): List<StarShip>
    suspend fun getStarShipById(id: Int): StarShip
    suspend fun searchStarShips(query: String, page: Int): List<StarShip>
    suspend fun favoriteStarShip(id: String)
    suspend fun unFavoriteStarShip(id: String)
    suspend fun getFavoriteStarShips(): List<StarShip>
}