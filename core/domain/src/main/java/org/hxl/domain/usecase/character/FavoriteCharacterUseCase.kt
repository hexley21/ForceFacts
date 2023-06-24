package org.hxl.domain.usecase.character

import kotlinx.coroutines.flow.Flow
import org.hxl.domain.repository.StarWarsRepository
import org.hxl.domain.usecase.FavoriteUseCase
import org.hxl.model.Character
import javax.inject.Inject

class FavoriteCharacterUseCase @Inject constructor(private val repository: StarWarsRepository): FavoriteUseCase<Character> {
    override suspend fun favorite(id: Int) {
        return repository.favoriteCharacter(id)

    }

    override suspend fun unFavorite(id: Int) {
        return repository.unFavoriteCharacter(id)

    }

    override fun getFavorites(): Flow<List<Character>> {
        return repository.getFavoriteCharacters()

    }
}