package org.hxl.domain.usecase.character

import org.hxl.domain.repository.StarWarsRepository
import org.hxl.model.Character
import javax.inject.Inject

class CharacterUseCase @Inject constructor(private val repository: StarWarsRepository) {
    suspend fun searchCharacters(query: String, page: Int): List<Character> {
        return repository.searchCharacters(query, page)
    }
}