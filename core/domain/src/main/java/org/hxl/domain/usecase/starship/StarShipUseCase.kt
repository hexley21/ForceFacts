package org.hxl.domain.usecase.starship

import org.hxl.domain.repository.StarWarsRepository
import org.hxl.model.StarShip
import javax.inject.Inject

class StarShipUseCase @Inject constructor(private val repository: StarWarsRepository) {
    suspend fun getStarShips(page: Int): List<StarShip> {
        return repository.getStarShips(page)
    }
    suspend fun getStarShipById(id: Int): StarShip {
        return repository.getStarShipById(id)
    }
    suspend fun searchStarShips(query: String, page: Int): List<StarShip> {
        return repository.searchStarShips(query, page)
    }
}