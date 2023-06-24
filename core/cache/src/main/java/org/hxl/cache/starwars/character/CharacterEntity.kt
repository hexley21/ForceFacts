package org.hxl.cache.starwars.character

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.hxl.cache.room.ForceFactsDB

@Entity(tableName = ForceFactsDB.CHARACTER_TABLE)
data class CharacterEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "starships")
    val starships: Int,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean,
    @ColumnInfo(name = "films")
    val films: String
)