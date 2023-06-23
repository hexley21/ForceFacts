package org.hxl.network.mapper

import junit.framework.TestCase.assertEquals
import org.hxl.model.Film
import org.hxl.network.model.FilmDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FilmDTOMapperTest {

    private val fakeDTO = FilmDTO(
        title = "A New Hope",
        episodeId = 4,
        openingCrawl = "It is a period of civil war...",
        director = "George Lucas",
        producer = "Gary Kurtz, Rick McCallum",
        releaseDate = "1977-05-25",
        characters = listOf("Luke Skywalker", "Princess Leia", "Han Solo"),
        planets = listOf("Tatooine", "Alderaan"),
        starships = listOf("X-wing", "Millennium Falcon"),
        vehicles = listOf("Sand Crawler", "TIE/LN starfighter"),
        species = listOf("Human", "Droid"),
        created = "2014-12-10T14:23:31.880000Z",
        edited = "2014-12-20T19:49:45.256000Z",
        url = "https://swapi.dev/api/films/1/"
    )

    private val fakeModel = Film(
        title = "A New Hope",
        episodeId = 4,
        director = "George Lucas",
        producer = "Gary Kurtz, Rick McCallum"
    )

    @Test
    fun `mapToModel converts to valid object`() {
        // Act
        val converted = fakeDTO.mapToModel()
        // Assert
        assertEquals(fakeModel.title, converted.title)
        assertEquals(fakeModel.episodeId, converted.episodeId)
        assertEquals(fakeModel.director, converted.director)
        assertEquals(fakeModel.producer, converted.producer)
    }
}