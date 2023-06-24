package org.hxl.cache.starwars.film

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmDAO {
    @Query("SELECT * FROM film ORDER BY id ASC LIMIT 10 OFFSET :offset")
    fun getFilms(offset: Int): Flow<List<FilmEntity>>

    @Query("SELECT * FROM film WHERE id = :id")
    fun getFilmById(id: Int): Flow<FilmEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(vararg filmEntity: FilmEntity)
}