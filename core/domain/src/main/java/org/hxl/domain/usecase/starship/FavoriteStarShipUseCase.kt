package org.hxl.domain.usecase.starship

import kotlinx.coroutines.flow.Flow
import org.hxl.domain.repository.StarWarsRepository
import org.hxl.model.StarShip
import javax.inject.Inject

class FavoriteStarShipUseCase @Inject constructor(private val repository: StarWarsRepository) {
    suspend fun favoriteStarShip(id: Int) {
        return repository.favoriteStarShip(id)
    }
    suspend fun unFavoriteStarShip(id: Int) {
        return repository.unFavoriteStarShip(id)
    }
    fun getFavoriteStarShips(): Flow<List<StarShip>> {
        return repository.getFavoriteStarShips()
    }
}