package org.hxl.domain.usecase.character

import org.hxl.domain.repository.StarWarsRepository
import org.hxl.domain.usecase.ModelUseCase
import org.hxl.model.Character
import javax.inject.Inject

class CharacterUseCase @Inject constructor(private val repository: StarWarsRepository): ModelUseCase<Character> {

    override suspend fun search(query: String, page: Int): List<Character> {
        return repository.searchCharacters(query, page)

    }
}