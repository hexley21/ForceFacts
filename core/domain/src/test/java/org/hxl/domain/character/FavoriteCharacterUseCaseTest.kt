package org.hxl.domain.character

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.hxl.common_test.TestConstants.ID
import org.hxl.model.Character
import org.hxl.domain.repository.StarWarsRepository
import org.hxl.domain.usecase.character.FavoriteCharacterUseCase
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteCharacterUseCaseTest {
    @Mock
    private lateinit var repository: StarWarsRepository

    @InjectMocks
    private lateinit var useCase: FavoriteCharacterUseCase

    @Test
    fun favoriteCharacter_invokeRepositoryFavorite() = runTest {
        // Act
        useCase.favorite(ID)
        // Assert
        verify(repository).favoriteCharacter(ID)
    }

    @Test
    fun unFavoriteCharacter_invokeRepositoryUnFavorite() = runTest {
        // Act
        useCase.unFavorite(ID)
        // Assert
        verify(repository).unFavoriteCharacter(ID)
    }

    @Test
    fun getFavoriteCharacters_invokeRepositoryGetFavoriteCharacters() = runTest{
        // Arrange
        val characters = listOf(
            Character(1, "Luke Skywalker", "Male", 1, true),
            Character(2, "Leia Organa", "Female", 1, true)
        )
        val flowCharacters = flowOf(characters)
        `when`(repository.getFavoriteCharacters()).thenReturn(flowCharacters)
        // Act
        val result = useCase.getFavorites().first()
        // Assert
        assertEquals(characters, result)
        verify(repository).getFavoriteCharacters()
    }
}
