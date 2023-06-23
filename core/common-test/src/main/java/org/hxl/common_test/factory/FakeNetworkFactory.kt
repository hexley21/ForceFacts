package org.hxl.common_test.factory

import org.hxl.common_test.TestConstants.LIST_SIZE
import org.hxl.network.model.CharacterDTO
import org.hxl.network.model.FilmDTO
import org.hxl.network.model.ListResponse
import org.hxl.network.model.StarShipDTO
import java.util.UUID
import kotlin.random.Random

object FakeNetworkFactory {
    fun <T> createList(generation: () -> T): ListResponse<T> {
        val dtoList: List<T> = List(LIST_SIZE) { generation() }
        return ListResponse(
            count = LIST_SIZE,
            next = null,
            previous = null,
            results = dtoList
        )
    }

    fun createStarShipDTO(): StarShipDTO {
        return StarShipDTO(
            name = UUID.randomUUID().toString(),
            model = UUID.randomUUID().toString(),
            manufacturer = UUID.randomUUID().toString(),
            costInCredits = UUID.randomUUID().toString(),
            length = UUID.randomUUID().toString(),
            maxAtmospheringSpeed = UUID.randomUUID().toString(),
            crew = UUID.randomUUID().toString(),
            passengers = Random.nextDouble().toString(),
            cargoCapacity = UUID.randomUUID().toString(),
            consumables = UUID.randomUUID().toString(),
            hyperdriveRating = UUID.randomUUID().toString(),
            mGLT = UUID.randomUUID().toString(),
            starshipClass = UUID.randomUUID().toString(),
            pilots = emptyList(),
            films = emptyList(),
            created = "2023-06-23T00:00:00.000Z",
            edited = "2023-06-23T00:00:00.000Z",
            url = "https://swapi.dev/api/starships/${Random.nextInt(1, 10)}/"
        )
    }

    fun createCharacterDTO(): CharacterDTO {
        return CharacterDTO(
            name = UUID.randomUUID().toString(),
            height = UUID.randomUUID().toString(),
            mass = UUID.randomUUID().toString(),
            hairColor = UUID.randomUUID().toString(),
            skinColor = UUID.randomUUID().toString(),
            eyeColor = UUID.randomUUID().toString(),
            birthYear = UUID.randomUUID().toString(),
            gender = UUID.randomUUID().toString(),
            homeworld = UUID.randomUUID().toString(),
            films = emptyList(),
            species = emptyList(),
            vehicles = emptyList(),
            starships = emptyList(),
            created = "2023-06-23T00:00:00.000Z",
            edited = "2023-06-23T00:00:00.000Z",
            url = "https://swapi.dev/api/people/1/"
        )
    }

    fun createFilmDTO(): FilmDTO {
        return FilmDTO(
            title = UUID.randomUUID().toString(),
            episodeId = (1..10).random(),
            openingCrawl = UUID.randomUUID().toString(),
            director = UUID.randomUUID().toString(),
            producer = UUID.randomUUID().toString(),
            releaseDate = UUID.randomUUID().toString(),
            characters = emptyList(),
            planets = emptyList(),
            starships = emptyList(),
            vehicles = emptyList(),
            species = emptyList(),
            created = "2023-06-23T00:00:00.000Z",
            edited = "2023-06-23T00:00:00.000Z",
            url = "https://swapi.dev/api/films/1/"
        )
    }

}