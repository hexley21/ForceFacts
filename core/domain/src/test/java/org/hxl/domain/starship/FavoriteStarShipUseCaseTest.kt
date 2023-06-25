package org.hxl.domain.starship

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.hxl.common_test.TestConstants.ID
import org.hxl.domain.repository.StarWarsRepository
import org.hxl.domain.usecase.starship.FavoriteStarShipUseCase
import org.hxl.model.StarShip
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteStarShipUseCaseTest {
    @Mock
    private lateinit var repository: StarWarsRepository

    @InjectMocks
    private lateinit var useCase: FavoriteStarShipUseCase

    @Test
    fun favoriteStarShip_invokeRepositoryFavorite() = runTest {
        // Act
        useCase.favorite(ID)
        // Assert
        verify(repository).favoriteStarShip(ID)
    }

    @Test
    fun unFavoriteStarShip_invokeRepositoryUnFavorite() = runTest {
        // Act
        useCase.unFavorite(ID)
        // Assert
        verify(repository).unFavoriteStarShip(ID)
    }

    @Test
    fun getFavoriteStarShips_invokeRepositoryGetFavoriteStarShips() = runTest {
        // Arrange
        val starShips = listOf(
            StarShip(1, "Starship 1", "Model 1", "Manufacturer 1", "100", true),
            StarShip(2, "Starship 2", "Model 2", "Manufacturer 2", "200", true)
        )
        val flowStarShips = flowOf(starShips)
        `when`(repository.getFavoriteStarShips()).thenReturn(flowStarShips)
        // Act
        val result = useCase.getFavorites().first()
        // Assert
        assertEquals(starShips, result)
        verify(repository).getFavoriteStarShips()
    }
}
