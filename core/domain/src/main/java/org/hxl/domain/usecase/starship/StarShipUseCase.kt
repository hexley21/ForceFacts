package org.hxl.domain.usecase.starship

import org.hxl.domain.repository.StarWarsRepository
import org.hxl.domain.usecase.ModelUseCase
import org.hxl.model.StarShip
import javax.inject.Inject

class StarShipUseCase @Inject constructor(private val repository: StarWarsRepository): ModelUseCase<StarShip> {
    override suspend fun search(query: String, page: Int): List<StarShip> {
        return repository.searchStarShips(query, page)

    }
}