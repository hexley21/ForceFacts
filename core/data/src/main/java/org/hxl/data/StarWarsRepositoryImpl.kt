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
    override suspend fun getCharacters(page: Int): List<Character> {
        return try {
            val response: List<Character> = remote.getCharacters(page)
            local.insertCharacter(*response.toTypedArray())
            response
        } catch (e: Exception) {
            local.getCharacters(page)
        }
    }

    override suspend fun getCharacterById(id: Int): Character {
        return try {
            val response: Character = remote.getCharacterById(id)
            local.insertCharacter(response)
            response
        } catch (e: Exception) {
            local.getCharacterById(id)
        }
    }

    override suspend fun searchCharacters(query: String, page: Int): List<Character> {
        return remote.searchCharacters(query, page)
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

    override suspend fun getStarShips(page: Int): List<StarShip> {
        return remote.getStarShips(page)
    }

    override suspend fun getStarShipById(id: Int): StarShip {
        return remote.getStarShipById(id)
    }

    override suspend fun searchStarShips(query: String, page: Int): List<StarShip> {
        return remote.searchStarShips(query, page)
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