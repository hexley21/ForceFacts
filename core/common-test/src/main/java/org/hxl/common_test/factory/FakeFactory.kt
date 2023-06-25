package org.hxl.common_test.factory

import org.hxl.common_test.TestConstants.LIST_SIZE
import org.hxl.model.Film
import org.hxl.model.FilmInfo
import org.hxl.model.StarShip
import org.hxl.model.Character
import java.util.UUID
import kotlin.random.Random

object FakeFactory {
    inline fun <reified T> createList(generation: () -> T): List<T> {
        return List(LIST_SIZE) { generation() }
    }

    inline fun <reified T> createArray(generation: () -> T): Array<T> where T: Any{
        return Array(LIST_SIZE) { generation() }
    }

    fun createCharacter(): Character {
        return createCharacter(Random.nextInt())
    }
    fun createCharacter(id: Int): Character {
        return Character(
            id = id,
            name = UUID.randomUUID().toString(),
            gender = listOf("Male", "Female", "Other").random(),
            starships = Random.nextInt(0, 10),
            isFavorite = listOf(true, false).random(),
            filmInfo = createFilmInfo()
        )
    }

    fun createStarShip(): StarShip {
        return createStarShip(Random.nextInt())
    }

    fun createStarShip(id: Int): StarShip {
        return StarShip(
            id = id,
            name = UUID.randomUUID().toString(),
            model = UUID.randomUUID().toString(),
            manufacturer = UUID.randomUUID().toString(),
            passengers = Random.nextDouble().toString(),
            isFavorite = listOf(true, false).random(),
            filmInfo = createFilmInfo()
        )
    }

    private fun createFilmInfo(): FilmInfo {
        return FilmInfo(
            ids = List(LIST_SIZE) { Random.nextInt() },
            films = UUID.randomUUID().toString(),
            directors = UUID.randomUUID().toString(),
            producers = UUID.randomUUID().toString()
        )
    }
    fun createFilm(): Film {
        return createFilm(Random.nextInt())
    }
    fun createFilm(id: Int): Film {
        return Film(
            id = id,
            title = UUID.randomUUID().toString(),
            director = UUID.randomUUID().toString(),
            producer = UUID.randomUUID().toString()
        )
    }

}