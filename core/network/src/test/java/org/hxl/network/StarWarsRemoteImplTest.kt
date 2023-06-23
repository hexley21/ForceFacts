package org.hxl.network

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.test.runTest
import org.hxl.common_test.TestConstants.ID
import org.hxl.common_test.TestConstants.LIST_SIZE
import org.hxl.common_test.TestConstants.PAGE
import org.hxl.common_test.TestConstants.QUERY
import org.hxl.common_test.factory.FakeNetworkFactory.createCharacterDTO
import org.hxl.common_test.factory.FakeNetworkFactory.createFilmDTO
import org.hxl.common_test.factory.FakeNetworkFactory.createList
import org.hxl.common_test.factory.FakeNetworkFactory.createStarShipDTO
import org.hxl.model.Character
import org.hxl.model.Film
import org.hxl.model.StarShip
import org.hxl.network.api.StarWarsService
import org.hxl.network.model.CharacterDTO
import org.hxl.network.model.FilmDTO
import org.hxl.network.model.ListResponse
import org.hxl.network.model.StarShipDTO
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.anyString
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class StarWarsRemoteImplTest {

    @Mock
    lateinit var service: StarWarsService

    @InjectMocks
    lateinit var remote: StarWarsRemoteImpl

    @Test
    fun getCharacters() = runTest {
        // Arrange
        val fakeCharacters: ListResponse<CharacterDTO> = createList { createCharacterDTO() }
        `when`(service.getCharacters(anyInt())).thenReturn(fakeCharacters)
        // Act
        val characters: List<Character> = remote.getCharacters(PAGE)
        // Assert
        assertEquals(LIST_SIZE, characters.size)
        verify(service).getCharacters(anyInt())
    }

    @Test
    fun getCharacterById() = runTest {
        // Arrange
        val fakeCharacter: CharacterDTO = createCharacterDTO()
        `when`(service.getCharacterById(anyInt())).thenReturn(fakeCharacter)
        // Act
        val character: Character = remote.getCharacterById(ID)
        // Assert
        assertNotNull(character)
        verify(service).getCharacterById(anyInt())
    }

    @Test
    fun searchCharacters() = runTest {
        // Arrange
        val fakeCharacters: ListResponse<CharacterDTO> = createList { createCharacterDTO() }
        `when`(service.searchCharacters(anyString(), anyInt())).thenReturn(fakeCharacters)
        // Act
        val characters: List<Character> = remote.searchCharacters(QUERY, PAGE)
        // Assert
        assertEquals(LIST_SIZE, characters.size)
        verify(service).searchCharacters(anyString(), anyInt())
    }

    @Test
    fun getStarShips() = runTest {
        // Arrange
        val fakeStarShips: ListResponse<StarShipDTO> = createList { createStarShipDTO() }
        `when`(service.getStarShips(anyInt())).thenReturn(fakeStarShips)
        // Act
        val starShips: List<StarShip> = remote.getStarShips(PAGE)
        // Assert
        assertEquals(LIST_SIZE, starShips.size)
        verify(service).getStarShips(anyInt())
    }

    @Test
    fun getStarShipById() = runTest {
        val fakeStarShips: StarShipDTO = createStarShipDTO()
        `when`(service.getStarShipById(anyInt())).thenReturn(fakeStarShips)
        // Act
        val starShips: StarShip = remote.getStarShipById(ID)
        // Assert
        assertNotNull(starShips)
        verify(service).getStarShipById(anyInt())
    }

    @Test
    fun searchStarShips() = runTest {
        // Arrange
        val fakeStarShips: ListResponse<StarShipDTO> = createList { createStarShipDTO() }
        `when`(service.searchStarShips(anyString(), anyInt())).thenReturn(fakeStarShips)
        // Act
        val starShips: List<StarShip> = remote.searchStarShips(QUERY, PAGE)
        // Assert
        assertEquals(LIST_SIZE, starShips.size)
        verify(service).searchStarShips(anyString(), anyInt())
    }

    @Test
    fun getFilms() = runTest {
        // Arrange
        val fakeFilms: ListResponse<FilmDTO> = createList { createFilmDTO() }
        `when`(service.getFilms(anyInt())).thenReturn(fakeFilms)
        // Act
        val films: List<Film> = remote.getFilms(PAGE)
        // Assert
        assertEquals(LIST_SIZE, films.size)
        verify(service).getFilms(anyInt())
    }

    @Test
    fun getFilmById() = runTest {
        // Arrange
        val fakeFilms: FilmDTO = createFilmDTO()
        `when`(service.getFilmById(anyInt())).thenReturn(fakeFilms)
        // Act
        val films: Film = remote.getFilmById(ID)
        // Assert
        assertNotNull(films)
        verify(service).getFilmById(anyInt())
    }
}