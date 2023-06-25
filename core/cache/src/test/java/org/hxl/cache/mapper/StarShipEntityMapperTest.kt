package org.hxl.cache.mapper

import junit.framework.TestCase.assertEquals
import org.hxl.cache.starwars.starship.StarShipEntity
import org.hxl.cache.starwars.starship.mapToEntity
import org.hxl.cache.starwars.starship.mapToModel
import org.hxl.common_test.TestConstants.ID
import org.hxl.model.FilmInfo
import org.hxl.model.StarShip
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class StarShipEntityMapperTest {

    private val entity = StarShipEntity(
        ID,
        "Millennium Falcon",
        "YT-1300 light freighter",
        "Corellian Engineering Corporation",
        "6",
        false,
        "1,2,3"
    )

    private val starship = StarShip(
        ID,
        "Millennium Falcon",
        "YT-1300 light freighter",
        "Corellian Engineering Corporation",
        "6",
        false,
        FilmInfo(listOf(1, 2, 3))
    )

    @Test
    fun `mapToModel returns valid StarShip object`() {
        // Act
        val result = entity.mapToModel()
        // Assert
        assertEquals(result.id, starship.id)
        assertEquals(result.name, starship.name)
        assertEquals(result.model, starship.model)
        assertEquals(result.manufacturer, starship.manufacturer)
        assertEquals(result.passengers, starship.passengers)
        assertEquals(result.isFavorite, starship.isFavorite)
        assertEquals(result.filmInfo, starship.filmInfo)
    }

    @Test
    fun `mapToEntity returns valid StarShipEntity object`() {
        // Arrange
        val films = listOf(1, 2, 3)
        // Act
        val result = starship.mapToEntity(films)
        // Assert
        assertEquals(result.id, entity.id)
        assertEquals(result.name, entity.name)
        assertEquals(result.model, entity.model)
        assertEquals(result.manufacturer, entity.manufacturer)
        assertEquals(result.passengers, entity.passengers)
        assertEquals(result.isFavorite, entity.isFavorite)
        assertEquals(result.films, entity.films)
    }
}
