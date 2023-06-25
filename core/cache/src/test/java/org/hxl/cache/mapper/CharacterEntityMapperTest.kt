package org.hxl.cache.mapper

import junit.framework.TestCase.assertEquals
import org.hxl.cache.starwars.character.CharacterEntity
import org.hxl.cache.starwars.character.mapToEntity
import org.hxl.cache.starwars.character.mapToModel
import org.hxl.model.Character
import org.hxl.common_test.TestConstants.ID
import org.hxl.model.FilmInfo
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CharacterEntityMapperTest {

    private val entity = CharacterEntity(
        ID,
        "Luke Skywalker",
        "Male",
        2,
        false,
        "1,2,3"
    )

    private val character = Character(
        ID,
        "Luke Skywalker",
        "Male",
        2,
        false,
        FilmInfo(listOf(1, 2, 3))
    )

    @Test
    fun `mapToModel returns valid Character object`() {
        // Act
        val result = entity.mapToModel()
        // Assert
        assertEquals(result.id, character.id)
        assertEquals(result.name, character.name)
        assertEquals(result.gender, character.gender)
        assertEquals(result.starships, character.starships)
        assertEquals(result.isFavorite, character.isFavorite)
        assertEquals(result.filmInfo, character.filmInfo)
    }

    @Test
    fun `mapToEntity returns valid CharacterEntity object`() {
        // Act
        val result = character.mapToEntity(listOf(1, 2, 3))
        // Assert
        assertEquals(result.id, entity.id)
        assertEquals(result.name, entity.name)
        assertEquals(result.gender, entity.gender)
        assertEquals(result.starships, entity.starships)
        assertEquals(result.isFavorite, entity.isFavorite)
        assertEquals(result.films, entity.films)
    }
}
