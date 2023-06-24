package org.hxl.cache.starwars.film

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FilmDAO {
    @Query("SELECT * FROM film ORDER BY id ASC")
    suspend fun getFilms(): List<FilmEntity>

    @Query("SELECT * FROM film WHERE id = :id")
    suspend fun getFilmById(id: Int): FilmEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(vararg filmEntity: FilmEntity)
}