package org.hxl.cache.starwars.film

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.hxl.cache.room.ForceFactsDB

@Entity(tableName = ForceFactsDB.FILM_TABLE)
class FilmEntity (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "director")
    val director: String,
    @ColumnInfo(name = "producer")
    val producer: String,
)