package org.hxl.cache

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.hxl.cache.FakeCacheFactory.createCharacterEntity
import org.hxl.cache.FakeCacheFactory.createFilmEntity
import org.hxl.cache.FakeCacheFactory.createList
import org.hxl.cache.FakeCacheFactory.createStarShipEntity
import org.hxl.cache.room.ForceFactsDB
import org.hxl.cache.starwars.character.CharacterDAO
import org.hxl.cache.starwars.character.CharacterEntity
import org.hxl.cache.starwars.film.FilmDAO
import org.hxl.cache.starwars.film.FilmEntity
import org.hxl.cache.starwars.starship.StarShipDAO
import org.hxl.cache.starwars.starship.StarShipEntity
import org.hxl.common_test.TestConstants.ID
import org.hxl.common_test.TestConstants.OFFSET
import org.hxl.common_test.TestConstants.OFFSETTED_SIZE
import org.hxl.common_test.factory.FakeFactory.createArray
import org.hxl.common_test.factory.FakeFactory.createCharacter
import org.hxl.common_test.factory.FakeFactory.createFilm
import org.hxl.common_test.factory.FakeFactory.createStarShip
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config


@Config(manifest = Config.NONE)
@RunWith(AndroidJUnit4::class)
class StarWarsLocalTest {
    private lateinit var db: ForceFactsDB

    private lateinit var characterDao: CharacterDAO
    private lateinit var starShipDAO: StarShipDAO
    private lateinit var filmDAO: FilmDAO

    private lateinit var repository: StarWarsLocalImpl

    @Before
    fun setUp() {
        val context: Context = ApplicationProvider.getApplicationContext()
        db = Room.inMemoryDatabaseBuilder(
            context, ForceFactsDB::class.java)
                .allowMainThreadQueries()
                .build()
        characterDao = db.characterDAO()
        starShipDAO = db.starShipDAO()
        filmDAO = db.filmDAO()
        repository = StarWarsLocalImpl(characterDao, starShipDAO, filmDAO)
    }

    @After
    fun tearDown() {
        db.clearAllTables()
        db.close()
    }

    private fun insertCharacter(vararg characterEntity: CharacterEntity) {
        characterDao.insertCharacter(*characterEntity)
    }
    private fun insertStarShip(vararg starShip: StarShipEntity) {
        starShipDAO.insertStarShip(*starShip)
    }
    private fun insertFilm(vararg film: FilmEntity) {
        filmDAO.insertFilm(*film)
    }
    @Test
    fun `test getCharacters`() = runTest {
        // Arrange
        val entities = createArray(::createCharacterEntity)
        insertCharacter(*entities)
        // Act
        val characters = repository.getCharacters(OFFSET)
        // Assert
        assertEquals(OFFSETTED_SIZE, characters.size)
        characters.forEach {
            assertNotNull(it)
        }
    }

    @Test
    fun `test favoriteCharacter`() = runTest {
        // Arrange
        val entity = createCharacterEntity(ID)
        insertCharacter(entity)
        // Act
        repository.favoriteCharacter(ID)
        val favorite = characterDao.isFavorite(ID)
        // Assert
        assertTrue(favorite)
    }
    @Test
    fun `test unFavoriteCharacter`() = runTest {
        // Arrange
        val entity = createCharacterEntity(ID)
        insertCharacter(entity)
        repository.favoriteCharacter(ID)
        // Act
        repository.unFavoriteCharacter(ID)
        val favorite = characterDao.isFavorite(ID)
        // Assert
        assertFalse(favorite)
    }

    @Test
    fun `test getFavoriteCharacters`() = runTest {
        // Arrange
        val entity = createCharacterEntity(ID)
        insertCharacter(entity)
        characterDao.favoriteCharacter(ID)
        // Act
        val favorites = repository.getFavoriteCharacters()
        // Assert
        assertEquals(ID, favorites.first().first().id)
    }
    @Test
    fun `test insertCharacters`() = runTest {
        // Arrange
        val characters = createList { createCharacter() }
        // Act
        repository.insertCharacter(characters)
        val entities = characterDao.getCharacters(OFFSET)
        // Assert
        assertEquals(OFFSETTED_SIZE, entities.size)
    }

    @Test
    fun `test insertCharacter`() = runTest {
        // Arrange
        val characters = createCharacter(ID)
        // Act
        repository.insertCharacter(characters)
        val entity = characterDao.getCharacters(0)
        // Assert
        assertEquals(ID, entity.first().id)
    }
    @Test
    fun `test isCharacterFavorite`() = runTest {
        // Arrange
        val entity = createCharacterEntity(ID)
        insertCharacter(entity)
        characterDao.favoriteCharacter(ID)
        // Act
        val isFavorite = repository.isCharacterFavorite(ID)
        // Assert
        assertTrue(isFavorite)
    }

    @Test
    fun `test isCharacterCached`() = runTest {
        // Arrange
        val entity = createCharacterEntity(ID)
        insertCharacter(entity)
        // Act
        val isCached = repository.isCharacterCached(ID)
        val notCached = repository.isCharacterCached(ID+1)
        // Assert
        assertTrue(isCached)
        assertFalse(notCached)
    }

    @Test
    fun `test getStarShips`() = runTest {
        // Arrange
        val entities = createArray(::createStarShipEntity)
        insertStarShip(*entities)
        // Act
        val starShips = repository.getStarShips(OFFSET)
        // Assert
        assertEquals(OFFSETTED_SIZE, starShips.size)
        starShips.forEach {
            assertNotNull(it)
        }
    }

    @Test
    fun `test favoriteStarShip`() = runTest {
        // Arrange
        val entity = createStarShipEntity(ID)
        insertStarShip(entity)
        // Act
        repository.favoriteStarShip(ID)
        val favorite = starShipDAO.isFavorite(ID)
        // Assert
        assertTrue(favorite)
    }

    @Test
    fun `test unFavoriteStarShip`() = runTest {
        // Arrange
        val entity = createStarShipEntity(ID)
        insertStarShip(entity)
        repository.favoriteStarShip(ID)
        // Act
        repository.unFavoriteStarShip(ID)
        val favorite = starShipDAO.isFavorite(ID)
        // Assert
        assertFalse(favorite)
    }

    @Test
    fun `test getFavoriteStarShips`() = runTest {
        // Arrange
        val entity = createStarShipEntity(ID)
        insertStarShip(entity)
        starShipDAO.favoriteStarShip(ID)
        // Act
        val favorites = repository.getFavoriteStarShips()
        // Assert
        assertEquals(ID, favorites.first().first().id)
    }

    @Test
    fun `test insertStarShips`() = runTest {
        // Arrange
        val starShips = createList(::createStarShip)
        // Act
        repository.insertStarShip(starShips)
        val entities = starShipDAO.getStarShips(OFFSET)
        // Assert
        assertEquals(OFFSETTED_SIZE, entities.size)
    }

    @Test
    fun `test insertStarShip`() = runTest {
        // Arrange
        val starShip = createStarShip(ID)
        // Act
        repository.insertStarShip(starShip)
        val entities = starShipDAO.getStarShips(0)
        // Assert
        assertEquals(1, entities.size)
        assertEquals(ID, entities.first().id)
    }

    @Test
    fun `test isStarShipFavorite`() = runTest {
        // Arrange
        val entity = createStarShipEntity(ID)
        insertStarShip(entity)
        starShipDAO.favoriteStarShip(ID)
        // Act
        val isFavorite = repository.isStarShipFavorite(ID)
        // Assert
        assertTrue(isFavorite)
    }

    @Test
    fun `test isStarShipCached`() = runTest {
        // Arrange
        val entity = createStarShipEntity(ID)
        insertStarShip(entity)
        // Act
        val isCached = repository.isStarShipCached(ID)
        val notCached = repository.isStarShipCached(ID+1)
        // Assert
        assertTrue(isCached)
        assertFalse(notCached)

    }
    @Test
    fun getFilmById() = runTest {
        // Arrange
        val entity = createFilmEntity(ID)
        insertFilm(entity)
        // Act
        val film = repository.getFilmById(ID)
        // Assert
        assertEquals(ID, film.id)
    }

    @Test
    fun insertFilm() = runTest {
        // Arrange
        val film = createFilm(ID)
        // Act
        repository.insertFilm(film)

        val entity = filmDAO.getFilmById(ID)
        // Assert
        assertEquals(film.id, entity.id)
    }
}