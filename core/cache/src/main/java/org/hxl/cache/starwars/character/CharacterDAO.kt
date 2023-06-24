package org.hxl.cache.starwars.character

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDAO {

    @Query("SELECT * FROM character WHERE is_favorite = 1 ORDER BY id")
    fun getFavoriteCharacters() : Flow<List<CharacterEntity>>

    @Query("UPDATE character SET is_favorite = 1 WHERE id = :id")
    fun favoriteCharacter(id: Int): Int

    @Query("UPDATE character SET is_favorite = 0 WHERE id = :id")
    fun unFavoriteCharacter(id: Int): Int

    @Query("SELECT EXISTS(SELECT 1 FROM character where id == :id AND is_favorite == 1)")
    fun isFavorite(id: Int): Boolean

    @Query("SELECT EXISTS(SELECT 1 FROM character where id == :id)")
    fun isCached(id: Int): Boolean
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(vararg characterEntity: CharacterEntity)
}