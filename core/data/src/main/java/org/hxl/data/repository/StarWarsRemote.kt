package org.hxl.data.repository

import org.hxl.model.Character
import org.hxl.model.Film
import org.hxl.model.StarShip

interface StarWarsRemote {
    suspend fun getCharacters(page: Int): List<Character>
    suspend fun getCharacterById(id: Int): Character
    suspend fun searchCharacters(query: String, page: Int): List<Character>

    suspend fun getStarShips(page: Int): List<StarShip>
    suspend fun getStarShipById(id: Int): StarShip
    suspend fun searchStarShips(query: String, page: Int): List<StarShip>

    suspend fun getFilms(page: Int): List<Film>
    suspend fun getFilmById(id: Int): Film
}