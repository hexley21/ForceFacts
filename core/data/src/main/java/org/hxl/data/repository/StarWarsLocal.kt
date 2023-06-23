package org.hxl.data.repository

import org.hxl.model.Character
import org.hxl.model.Film
import org.hxl.model.StarShip

interface StarWarsLocal {
    suspend fun getCharacters(offset: Int): List<Character>
    suspend fun getCharacterById(id: Int): Character
    suspend fun favoriteCharacter(id: String)
    suspend fun unFavoriteCharacter(id: String)
    suspend fun getFavoriteCharacters(): List<Character>

    suspend fun getStarShips(offset: Int): List<StarShip>
    suspend fun getStarShipById(id: Int): StarShip
    suspend fun favoriteStarShip(id: String)
    suspend fun unFavoriteStarShip(id: String)
    suspend fun getFavoriteStarShips(): List<StarShip>

    suspend fun getFilms(offset: Int): List<Film>
    suspend fun getFilmById(id: Int): Film
}