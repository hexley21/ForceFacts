package org.hxl.domain.starship

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.hxl.domain.repository.StarWarsRepository
import org.hxl.domain.usecase.starship.StarShipUseCase
import org.hxl.model.StarShip
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class StarShipUseCaseTest {
    @Mock
    private lateinit var repository: StarWarsRepository

    @InjectMocks
    private lateinit var useCase: StarShipUseCase

    @Test
    fun `searchStarShips invokes repository's search`() = runTest {
        // Arrange
        val query = "Millennium Falcon"
        val page = 1
        val starShips = listOf(
            StarShip(1, "Millennium Falcon", "YT-1300", "Corellian Engineering Corporation", "6", true),
            StarShip(2, "Starship 2", "Model 2", "Manufacturer 2", "4", true)
        )
        `when`(repository.searchStarShips(query, page)).thenReturn(starShips)
        // Act
        val result = useCase.search(query, page)
        // Assert
        assertEquals(starShips, result)
        verify(repository).searchStarShips(query, page)
    }
}
