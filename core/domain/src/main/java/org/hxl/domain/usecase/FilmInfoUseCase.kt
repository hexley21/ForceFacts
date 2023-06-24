package org.hxl.domain.usecase

import org.hxl.domain.repository.StarWarsRepository
import org.hxl.model.FilmInfo
import javax.inject.Inject

class FilmInfoUseCase @Inject constructor(
    private val starWarsRepository: StarWarsRepository
) {
    suspend fun getFilmInfo(id: List<Int>): FilmInfo {
        return starWarsRepository.getFilmInfo(id)
    }
}