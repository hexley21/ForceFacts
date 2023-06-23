package org.hxl.network.mapper

import junit.framework.TestCase.assertEquals
import org.hxl.model.StarShip
import org.hxl.network.model.StarShipDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class StarShipDTOMapperTest {

    private val fakeDTO = StarShipDTO(
        name = "Millennium Falcon",
        model = "YT-1300 light freighter",
        manufacturer = "Corellian Engineering Corporation",
        costInCredits = "100000",
        length = "34.37",
        maxAtmospheringSpeed = "1050",
        crew = "4",
        passengers = "6",
        cargoCapacity = "100000",
        consumables = "2 months",
        hyperdriveRating = "0.5",
        mGLT = "75",
        starshipClass = "Light freighter",
        pilots = listOf(),
        films = listOf("A New Hope", "The Empire Strikes Back", "Return of the Jedi"),
        created = "2014-12-10T16:59:45.094000Z",
        edited = "2014-12-22T17:35:44.464156Z",
        url = "https://swapi.dev/api/starships/10/"
    )

    private val fakeModel = StarShip(
        name = "Millennium Falcon",
        model = "YT-1300 light freighter",
        manufacturer = "Corellian Engineering Corporation",
        passengers = 6.0,
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.name, converted.name)
        assertEquals(fakeModel.model, converted.model)
        assertEquals(fakeModel.manufacturer, converted.manufacturer)
        assertEquals(fakeModel.passengers, converted.passengers, 0.0)
        assertEquals(fakeModel.films.size, converted.films.size)
    }

    // Additional tests can be added here
}