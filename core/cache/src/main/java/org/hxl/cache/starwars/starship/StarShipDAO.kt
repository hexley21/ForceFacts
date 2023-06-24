package org.hxl.cache.starwars.starship

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface StarShipDAO {
    @Query("SELECT * FROM star_ship ORDER BY id ASC LIMIT 10 OFFSET :offset")
    suspend fun getStarShips(offset: Int): Flow<List<StarShipEntity>>

    @Query("SELECT * FROM star_ship WHERE id = :id")
    suspend fun getStarShipById(id: Int): Flow<StarShipEntity>


    @Query("UPDATE star_ship SET isFavorite = 1 WHERE id = :id")
    suspend fun favoriteStarShip(id: Long): Int

    @Query("UPDATE star_ship SET isFavorite = 0 WHERE id = :id")
    suspend fun unFavoriteStarShip(id: Long): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStarShip(vararg starShipEntity: StarShipEntity)
}