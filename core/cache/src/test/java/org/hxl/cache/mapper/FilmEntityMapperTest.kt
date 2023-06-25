package org.hxl.cache.mapper

import junit.framework.TestCase.assertEquals
import org.hxl.cache.starwars.film.FilmEntity
import org.hxl.cache.starwars.film.mapToEntity
import org.hxl.cache.starwars.film.mapToModel
import org.hxl.common_test.TestConstants.ID
import org.hxl.model.Film
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class FilmEntityMapperTest {

    private val entity = FilmEntity(
        ID,
        "Star Wars",
        "George Lucas",
        "Gary Kurtz, Rick McCallum"
    )

    private val film = Film(
        ID,
        "Star Wars",
        "George Lucas",
        "Gary Kurtz, Rick McCallum"
    )

    @Test
    fun `mapToModel returns valid Film object`() {
        // Act
        val result = entity.mapToModel()
        // Assert
        assertEquals(result.id, film.id)
        assertEquals(result.title, film.title)
        assertEquals(result.director, film.director)
        assertEquals(result.producer, film.producer)
    }

    @Test
    fun `mapToEntity returns valid FilmEntity object`() {
        // Act
        val result = film.mapToEntity()
        // Assert
        assertEquals(result.id, entity.id)
        assertEquals(result.title, entity.title)
        assertEquals(result.director, entity.director)
        assertEquals(result.producer, entity.producer)
    }
}
