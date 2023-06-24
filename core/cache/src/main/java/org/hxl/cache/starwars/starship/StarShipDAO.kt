package org.hxl.cache.starwars.starship

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StarShipDAO {
    @Query("SELECT * FROM star_ship ORDER BY id ASC LIMIT 10 OFFSET :offset")
    suspend fun getStarShips(offset: Int): List<StarShipEntity>

    @Query("SELECT * FROM star_ship WHERE id = :id")
    suspend fun getStarShipById(id: Int): StarShipEntity

    @Query("SELECT * FROM star_ship where isFavorite = 1 ORDER BY id ASC")
    fun getFavoriteStarShips(): Flow<List<StarShipEntity>>

    @Query("UPDATE star_ship SET isFavorite = 1 WHERE id = :id")
    suspend fun favoriteStarShip(id: Int): Int

    @Query("UPDATE star_ship SET isFavorite = 0 WHERE id = :id")
    suspend fun unFavoriteStarShip(id: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStarShip(vararg starShipEntity: StarShipEntity)
}