package org.hxl.network

import org.hxl.data.repository.StarWarsRemote
import org.hxl.model.Character
import org.hxl.model.Film
import org.hxl.model.StarShip
import org.hxl.network.api.StarWarsService
import org.hxl.network.mapper.mapToModel
import javax.inject.Inject

class StarWarsRemoteImpl @Inject constructor(private val service: StarWarsService): StarWarsRemote {
    override suspend fun getCharacters(page: Int): List<Character> {
        return service.getCharacters(page).results.map { it.mapToModel() }
    }

    override suspend fun getCharacterById(id: Int): Character {
        return service.getCharacterById(id).mapToModel()
    }

    override suspend fun searchCharacters(query: String, page: Int): List<Character> {
        return service.searchCharacters(query, page).results.map { it.mapToModel() }
    }

    override suspend fun getStarShips(page: Int): List<StarShip> {
        return service.getStarShips(page).results.map { it.mapToModel() }
    }

    override suspend fun getStarShipById(id: Int): StarShip {
        return service.getStarShipById(id).mapToModel()
    }

    override suspend fun searchStarShips(query: String, page: Int): List<StarShip> {
        return service.searchStarShips(query, page).results.map { it.mapToModel() }
    }

    override suspend fun getFilms(page: Int): List<Film> {
        return service.getFilms(page).results.map { it.mapToModel() }
    }

    override suspend fun getFilmById(id: Int): Film {
        return service.getFilmById(id).mapToModel()
    }
}