package org.hxl.cache.starwars.character

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDAO {
    @Query("SELECT * FROM character ORDER BY id ASC LIMIT 10 OFFSET :offset")
    suspend fun getCharacters(offset: Int) : List<CharacterEntity>

    @Query("SELECT * FROM character WHERE id = :id")
    suspend fun getCharacterById(id: Int) : CharacterEntity

    @Transaction
    @Query("SELECT * FROM character WHERE is_favorite = 1 ORDER BY id")
    fun getFavoriteCharacters() : Flow<List<CharacterEntity>>

    @Query("UPDATE character SET is_favorite = 1 WHERE id = :id")
    fun favoriteCharacter(id: Int): Int

    @Query("UPDATE character SET is_favorite = 0 WHERE id = :id")
    fun unFavoriteCharacter(id: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(vararg characterEntity: CharacterEntity)
}