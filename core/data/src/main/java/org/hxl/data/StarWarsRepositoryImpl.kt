package org.hxl.data

import kotlinx.coroutines.flow.Flow
import org.hxl.data.repository.StarWarsLocal
import org.hxl.data.repository.StarWarsRemote
import org.hxl.domain.repository.StarWarsRepository
import org.hxl.model.Character
import org.hxl.model.StarShip
import javax.inject.Inject

class StarWarsRepositoryImpl @Inject constructor(
    private val remote: StarWarsRemote,
    private val local: StarWarsLocal
): StarWarsRepository {

    private val cachedCharacters: MutableList<Int> = mutableListOf()
    private val cachedStarShips: MutableList<Int> = mutableListOf()

    override suspend fun searchCharacters(query: String, page: Int): List<Character> {
        val response: List<Character> = remote.searchCharacters(query, page)
        response.map {
            it.isFavorite = local.isCharacterFavorite(it.id)

            it.films.forEach { film ->
                if (!local.isFilmCached(film)) {
                    local.insertFilm(
                        remote.getFilmById(film)
                    )
                }
            }
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
        return local.getFavoriteCharacters()
    }

    override suspend fun searchStarShips(query: String, page: Int): List<StarShip> {
        val response: List<StarShip> = remote.searchStarShips(query, page)
        response.map {
            it.isFavorite = local.isStarShipFavorite(it.id)

            it.films.forEach { film ->
                if (!local.isFilmCached(film)) {
                    local.insertFilm(
                        remote.getFilmById(film)
                    )
                }
            }
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
        return local.getFavoriteStarShips()
    }
}