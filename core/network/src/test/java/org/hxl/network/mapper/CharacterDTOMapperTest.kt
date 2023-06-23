package org.hxl.network.mapper

import junit.framework.TestCase
import org.hxl.model.Character
import org.hxl.network.model.CharacterDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CharacterDTOMapperTest {

    private val fakeDTO = CharacterDTO(
        name = "Luke Skywalker",
        height = "172",
        mass = "77",
        hairColor = "Blond",
        skinColor = "Fair",
        eyeColor = "Blue",
        birthYear = "19BBY",
        gender = "Male",
        homeworld = "Tatooine",
        films = listOf("A New Hope", "The Empire Strikes Back", "Return of the Jedi"),
        species = listOf("Human"),
        vehicles = listOf("Snowspeeder", "Imperial Speeder Bike"),
        starships = listOf("X-wing", "Millennium Falcon"),
        created = "2014-12-09T13:50:51.644000Z",
        edited = "2014-12-10T13:52:43.172000Z",
        url = "https://swapi.dev/api/people/1/"
    )

    private val fakeModel = Character(
        name = "Luke Skywalker",
        gender = "Male",
        starships = 2
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        TestCase.assertEquals(fakeModel.name, converted.name)
        TestCase.assertEquals(fakeModel.gender, converted.gender)
        TestCase.assertEquals(fakeModel.starships, converted.starships)
        TestCase.assertEquals(fakeModel.films.size, converted.films.size)
    }

}
