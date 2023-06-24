package org.hxl.domain.usecase.starship

import kotlinx.coroutines.flow.Flow
import org.hxl.domain.repository.StarWarsRepository
import org.hxl.domain.usecase.FavoriteUseCase
import org.hxl.model.StarShip
import javax.inject.Inject

class FavoriteStarShipUseCase @Inject constructor(private val repository: StarWarsRepository): FavoriteUseCase<StarShip> {
    override suspend fun favorite(id: Int) {
        return repository.favoriteStarShip(id)
    }

    override suspend fun unFavorite(id: Int) {
        return repository.unFavoriteStarShip(id)

    }

    override fun getFavorites(): Flow<List<StarShip>> {
        return repository.getFavoriteStarShips()

    }
}