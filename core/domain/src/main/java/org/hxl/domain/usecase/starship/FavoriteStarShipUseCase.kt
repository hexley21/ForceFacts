package org.hxl.domain.usecase.starship

import org.hxl.domain.repository.StarWarsRepository
import org.hxl.model.StarShip
import javax.inject.Inject

class FavoriteStarShipUseCase @Inject constructor(private val repository: StarWarsRepository) {
    suspend fun favoriteStarShip(id: String) {
        return repository.favoriteStarShip(id)
    }
    suspend fun unFavoriteStarShip(id: String) {
        return repository.unFavoriteStarShip(id)
    }
    suspend fun getFavoriteStarShips(): List<StarShip> {
        return repository.getFavoriteStarShips()
    }
}