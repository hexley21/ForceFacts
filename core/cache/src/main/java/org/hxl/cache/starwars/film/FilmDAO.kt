package org.hxl.cache.starwars.film

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FilmDAO {
    @Query("SELECT * FROM film WHERE id = :id")
    suspend fun getFilmById(id: Int): FilmEntity

    @Query("SELECT EXISTS(SELECT 1 FROM film where id == :id)")
    fun isCached(id: Int): Boolean
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilm(vararg filmEntity: FilmEntity)
}