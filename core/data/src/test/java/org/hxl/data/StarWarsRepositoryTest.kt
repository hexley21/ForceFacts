package org.hxl.data

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.hxl.common_test.TestConstants.ID
import org.hxl.common_test.TestConstants.PAGE
import org.hxl.common_test.TestConstants.QUERY
import org.hxl.common_test.factory.FakeFactory.createCharacter
import org.hxl.common_test.factory.FakeFactory.createFilm
import org.hxl.common_test.factory.FakeFactory.createList
import org.hxl.common_test.factory.FakeFactory.createStarShip
import org.hxl.data.repository.StarWarsLocal
import org.hxl.data.repository.StarWarsRemote
import org.mockito.Mockito.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.anyInt
import org.mockito.Mockito.never
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class StarWarsRepositoryTest {
    @Mock
    private lateinit var remote: StarWarsRemote
    @Mock
    private lateinit var local: StarWarsLocal
    private lateinit var repository: StarWarsRepositoryImpl

    @Before
    fun setUp() {
        repository = StarWarsRepositoryImpl(remote, local)
    }

    @Test
    fun `searchCharacters when cache is not available or query is not empty invokes remote repository`() = runTest {
        // Arrange
        val characters = createList{ createCharacter() }
        `when`(local.isCharacterFavorite(anyInt())).thenReturn(false)
        `when`(remote.searchCharacters(QUERY, PAGE)).thenReturn(characters)
        // Act
        val response = repository.searchCharacters(QUERY, PAGE)
        // Assert
        assertEquals(characters, response)
        verify(remote).searchCharacters(QUERY, PAGE)
    }

    @Test
    fun `favoriteCharacter invokes local repository`() = runTest {
        // Act
        repository.favoriteCharacter(ID)
        // Assert
        verify(local).favoriteCharacter(ID)
    }

    @Test
    fun `unFavoriteCharacter invokes local repository`() = runTest {
        // Act
        repository.unFavoriteCharacter(ID)
        // Assert
        verify(local).unFavoriteCharacter(ID)
    }

    @Test
    fun `getFavoriteCharacters invokes local repository and updates film info`() = runTest {
        // Arrange
        val characters = createList { createCharacter() }
        `when`(local.getFavoriteCharacters()).thenReturn(flowOf(characters))
        `when`(local.isFilmCached(anyInt())).thenReturn(true)
        `when`(local.getFilmById(anyInt())).thenReturn(createFilm())
        // Act
        val response = repository.getFavoriteCharacters().first()
        // Assert
        assertEquals(characters, response)
        verify(local).getFavoriteCharacters()
    }

    @Test
    fun `searchStarShip when cache is not available or query is not empty invokes remote repository`() = runTest {
        // Arrange
        val starShips = createList{ createStarShip() }
        `when`(local.isStarShipFavorite(anyInt())).thenReturn(false)
        `when`(remote.searchStarShips(QUERY, PAGE)).thenReturn(starShips)
        // Act
        val response = repository.searchStarShips(QUERY, PAGE)
        // Assert
        assertEquals(starShips, response)
        verify(remote).searchStarShips(QUERY, PAGE)
    }

    @Test
    fun `favoriteStarShip invokes local repository`() = runTest {
        // Act
        repository.favoriteCharacter(ID)
        // Assert
        verify(local).favoriteCharacter(ID)
    }

    @Test
    fun `unFavoriteStarShip invokes local repository`() = runTest {
        // Act
        repository.unFavoriteCharacter(ID)
        // Assert
        verify(local).unFavoriteCharacter(ID)
    }

    @Test
    fun `getFavoriteStarShips invokes local repository and updates film info`() = runTest {
        // Arrange
        val starShips = createList { createStarShip() }
        `when`(local.getFavoriteStarShips()).thenReturn(flowOf(starShips))
        `when`(local.isFilmCached(anyInt())).thenReturn(true)
        `when`(local.getFilmById(anyInt())).thenReturn(createFilm())
        // Act
        val response = repository.getFavoriteStarShips().first()
        // Assert
        assertEquals(starShips, response)
        verify(local).getFavoriteStarShips()
        verify(remote, never()).getFilmById(anyInt())
    }

}
