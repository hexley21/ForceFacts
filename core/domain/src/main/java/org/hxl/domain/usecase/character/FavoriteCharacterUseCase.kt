package org.hxl.domain.usecase.character

import org.hxl.domain.repository.StarWarsRepository
import org.hxl.model.Character
import javax.inject.Inject

class FavoriteCharacterUseCase @Inject constructor(private val repository: StarWarsRepository) {
    suspend fun favoriteCharacter(id: String) {
        return repository.favoriteCharacter(id)
    }
    suspend fun unFavoriteCharacter(id: String) {
        return repository.unFavoriteCharacter(id)
    }
    suspend fun getFavoriteCharacters(): List<Character> {
        return repository.getFavoriteCharacters()
    }
}