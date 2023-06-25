package org.hxl.cache

import org.hxl.cache.starwars.character.CharacterEntity
import org.hxl.cache.starwars.film.FilmEntity
import org.hxl.cache.starwars.starship.StarShipEntity
import org.hxl.common_test.TestConstants
import java.util.UUID
import kotlin.random.Random

object FakeCacheFactory {
    fun <T> createList(generation: () -> T): List<T> {
        return List(TestConstants.LIST_SIZE) { generation() }
    }

    fun createCharacterEntity(): CharacterEntity {
        return createCharacterEntity(Random.nextInt())
    }
    fun createCharacterEntity(id: Int): CharacterEntity {
        return CharacterEntity(
            id = id,
            name = UUID.randomUUID().toString(),
            gender = listOf("Male", "Female", "Other").random(),
            starships = Random.nextInt(0, 10),
            isFavorite = listOf(true, false).random(),
            films = ("1,2,3,4")
        )
    }

    fun createFilmEntity(): FilmEntity {
        return createFilmEntity(Random.nextInt())
    }
    fun createFilmEntity(id: Int): FilmEntity {
        return FilmEntity(
            id = id,
            title = UUID.randomUUID().toString(),
            director = UUID.randomUUID().toString(),
            producer = UUID.randomUUID().toString()
        )
    }

    fun createStarShipEntity(): StarShipEntity {
        return createStarShipEntity(Random.nextInt())
    }
    fun createStarShipEntity(id: Int): StarShipEntity {
        return StarShipEntity(
            id = id,
            name = UUID.randomUUID().toString(),
            model = UUID.randomUUID().toString(),
            manufacturer = UUID.randomUUID().toString(),
            passengers = Random.nextDouble().toString(),
            isFavorite = listOf(true, false).random(),
            films = ("1,2,3,4")
        )
    }
}