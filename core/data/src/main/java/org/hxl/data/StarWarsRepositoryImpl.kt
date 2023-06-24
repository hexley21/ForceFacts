package org.hxl.data

import org.hxl.data.repository.StarWarsLocal
import org.hxl.data.repository.StarWarsRemote
import org.hxl.domain.repository.StarWarsRepository
import org.hxl.model.Character
import org.hxl.model.StarShip
import javax.inject.Inject

class StarWarsRepositoryImpl @Inject constructor(
    private val remote: StarWarsRemote,
    private val local: StarWarsLocal? = null
): StarWarsRepository {
    override suspend fun getCharacters(page: Int): List<Character> {
        return remote.getCharacters(page)
    }

    override suspend fun getCharacterById(id: Int): Character {
        return remote.getCharacterById(id)
    }

    override suspend fun searchCharacters(query: String, page: Int): List<Character> {
        return remote.searchCharacters(query, page)
    }

    override suspend fun favoriteCharacter(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun unFavoriteCharacter(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getFavoriteCharacters(offset: Int): List<Character> {
        TODO("Not yet implemented")
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

    override suspend fun favoriteStarShip(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun unFavoriteStarShip(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getFavoriteStarShips(offset: Int): List<StarShip> {
        TODO("Not yet implemented")
    }
}