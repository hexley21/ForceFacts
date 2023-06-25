package org.hxl.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.hxl.data.repository.StarWarsLocal
import org.hxl.data.repository.StarWarsRemote
import org.hxl.domain.repository.StarWarsRepository
import org.hxl.model.Character
import org.hxl.model.Film
import org.hxl.model.FilmInfo
import org.hxl.model.StarShip

class StarWarsRepositoryImpl(
    private val remote: StarWarsRemote,
    private val local: StarWarsLocal
): StarWarsRepository {
    private val cachedCharacters: MutableList<Int> = mutableListOf()
    private val cachedStarShips: MutableList<Int> = mutableListOf()

    override suspend fun searchCharacters(query: String, page: Int): List<Character> {
        var response: List<Character>
        if ((cachedCharacters.size / (10 * page)) >= 1 && query.isEmpty()) {
            response = local.getCharacters((page - 1) * 10)
            if (response.isEmpty()) {
                response = getCharactersRemote(query, page)
            }
        } else {
            response = getCharactersRemote(query, page)
        }
        return response
    }

    private suspend fun getCharactersRemote(query: String, page: Int): List<Character> {
        val response: List<Character> = remote.searchCharacters(query, page)
        response.map {
            it.isFavorite = local.isCharacterFavorite(it.id)

            if (it.id !in cachedCharacters) {
                local.insertCharacter(it)
                cachedCharacters.add(it.id)
            }
        }
        return response
    }

    override suspend fun favoriteCharacter(id: Int) {
        return local.favoriteCharacter(id)
    }

    override suspend fun unFavoriteCharacter(id: Int) {
        return local.unFavoriteCharacter(id)
    }

    override fun getFavoriteCharacters(): Flow<List<Character>> {
        return local.getFavoriteCharacters().map {
            it.onEach { character ->
                character.filmInfo = getFilmInfo(character.filmInfo.ids)
            }
        }
    }

    override suspend fun searchStarShips(query: String, page: Int): List<StarShip> {
        var response: List<StarShip>
        if ((cachedStarShips.size / (10 * page)) >= 1 && query.isEmpty()) {
            response = local.getStarShips((page - 1) * 10)
            if (response.isEmpty()) {
                response = getStarShipsRemote(query, page)
            }
        } else {
            response = getStarShipsRemote(query, page)
        }
        return response
    }

    private suspend fun getStarShipsRemote(query: String, page: Int): List<StarShip> {
        val response: List<StarShip> = remote.searchStarShips(query, page)
        response.map {
            it.isFavorite = local.isStarShipFavorite(it.id)

            if (it.id !in cachedStarShips) {
                local.insertStarShip(it)
                cachedStarShips.add(it.id)
            }
        }
        return response
    }

    override suspend fun favoriteStarShip(id: Int) {
        local.favoriteStarShip(id)
    }

    override suspend fun unFavoriteStarShip(id: Int) {
        local.unFavoriteStarShip(id)
    }

    override fun getFavoriteStarShips(): Flow<List<StarShip>> {
        return local.getFavoriteStarShips().map {
            it.onEach { starShip ->
                starShip.filmInfo = getFilmInfo(starShip.filmInfo.ids)
            }
        }
    }

    override suspend fun getFilmInfo(id: List<Int>): FilmInfo {
        val films: MutableList<Film> = mutableListOf()
        for (i in id) {
            films.add(getFilm(i))
        }
        return films.toInfo()
    }

    private suspend fun getFilm(id: Int): Film {
        return if (local.isFilmCached(id)) {
            local.getFilmById(id)
        } else {
            val response = remote.getFilmById(id)
            local.insertFilm(response)
            response
        }
    }
}