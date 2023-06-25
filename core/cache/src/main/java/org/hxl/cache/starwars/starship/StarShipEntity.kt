package org.hxl.cache.starwars.starship

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.hxl.cache.room.ForceFactsDB

@Entity(tableName = ForceFactsDB.STARSHIP_TABLE)
class StarShipEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "model")
    val model: String,
    @ColumnInfo(name = "manufacturer")
    val manufacturer: String,
    @ColumnInfo(name = "passengers")
    val passengers: String,
    @ColumnInfo(name = "is_favorite")
    var isFavorite: Boolean,
    @ColumnInfo(name = "films")
    val films: String
)