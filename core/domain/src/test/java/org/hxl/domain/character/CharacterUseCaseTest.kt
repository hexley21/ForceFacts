package org.hxl.domain.character

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.hxl.domain.repository.StarWarsRepository
import org.hxl.domain.usecase.character.CharacterUseCase
import org.hxl.model.Character
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharacterUseCaseTest {
    @Mock
    private lateinit var repository: StarWarsRepository

    @InjectMocks
    private lateinit var useCase: CharacterUseCase

    @Test
    fun `searchCharacters invokes repository's search`() = runTest {
        // Arrange
        val query = "Luke"
        val page = 1
        val characters = listOf(
            Character(1, "Luke Skywalker", "Male", 1),
            Character(2, "Luke Cage", "Male", 1)
        )
        `when`(repository.searchCharacters(query, page)).thenReturn(characters)
        // Act
        val result = useCase.search(query, page)
        // Assert
        assertEquals(characters, result)
        verify(repository).searchCharacters(query, page)
    }
}