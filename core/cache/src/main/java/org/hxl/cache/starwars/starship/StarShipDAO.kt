package org.hxl.cache.starwars.starship

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StarShipDAO {

    @Query("SELECT * FROM star_ship ORDER BY id ASC LIMIT 10 OFFSET :offset")
    fun getStarShips(offset: Int): List<StarShipEntity>

    @Query("SELECT * FROM star_ship where is_favorite = 1 ORDER BY id ASC")
    fun getFavoriteStarShips(): Flow<List<StarShipEntity>>

    @Query("UPDATE star_ship SET is_favorite = 1 WHERE id = :id")
    fun favoriteStarShip(id: Int): Int

    @Query("UPDATE star_ship SET is_favorite = 0 WHERE id = :id")
    fun unFavoriteStarShip(id: Int): Int

    @Query("SELECT EXISTS(SELECT 1 FROM star_ship where id == :id AND is_favorite == 1)")
    fun isFavorite(id: Int): Boolean

    @Query("SELECT EXISTS(SELECT 1 FROM star_ship where id == :id)")
    fun isCached(id: Int): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStarShip(vararg starShipEntity: StarShipEntity)
}