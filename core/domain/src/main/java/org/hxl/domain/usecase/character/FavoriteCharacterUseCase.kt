package org.hxl.domain.usecase.character

import kotlinx.coroutines.flow.Flow
import org.hxl.domain.repository.StarWarsRepository
import org.hxl.model.Character
import javax.inject.Inject

class FavoriteCharacterUseCase @Inject constructor(private val repository: StarWarsRepository) {
    suspend fun favoriteCharacter(id: Int) {
        return repository.favoriteCharacter(id)
    }
    suspend fun unFavoriteCharacter(id: Int) {
        return repository.unFavoriteCharacter(id)
    }
    fun getFavoriteCharacters(): Flow<List<Character>> {
        return repository.getFavoriteCharacters()
    }
}