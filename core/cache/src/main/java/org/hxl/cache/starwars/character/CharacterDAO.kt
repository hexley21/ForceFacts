package org.hxl.cache.starwars.character

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDAO {
    @Query("SELECT * FROM character ORDER BY id ASC LIMIT 10 OFFSET :offset")
    fun getCharacters(offset: Int) : Flow<List<CharacterEntity>>

    @Query("SELECT * FROM character WHERE id = :id")
    fun getCharacterById(id: Int) : Flow<CharacterEntity>

    @Query("SELECT * FROM character WHERE is_favorite = 1 ORDER BY id ASC LIMIT 10 OFFSET :offset")
    fun getFavoriteCharacters(offset: Int) : Flow<List<CharacterEntity>>

    @Query("UPDATE character SET is_favorite = 1 WHERE id = :id")
    fun favoriteCharacter(id: Int): Int

    @Query("UPDATE character SET is_favorite = 0 WHERE id = :id")
    fun unFavoriteCharacter(id: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(vararg characterEntity: CharacterEntity)
}