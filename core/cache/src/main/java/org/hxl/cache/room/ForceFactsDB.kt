package org.hxl.cache.room

import androidx.room.Database
import androidx.room.RoomDatabase
import org.hxl.cache.starwars.character.CharacterDAO
import org.hxl.cache.starwars.character.CharacterEntity
import org.hxl.cache.starwars.film.FilmDAO
import org.hxl.cache.starwars.film.FilmEntity
import org.hxl.cache.starwars.starship.StarShipDAO
import org.hxl.cache.starwars.starship.StarShipEntity

@Database(
    entities = [CharacterEntity::class, StarShipEntity::class, FilmEntity::class],
    version = 1,
    exportSchema = false
)
abstract class  ForceFactsDB: RoomDatabase() {
    companion object {
        const val DB_NAME = "force_facts.db"
        const val CHARACTER_TABLE = "character"
        const val STARSHIP_TABLE = "star_ship"
        const val FILM_TABLE = "film"
    }

    abstract fun characterDAO(): CharacterDAO
    abstract fun starShipDAO(): StarShipDAO
    abstract fun filmDAO(): FilmDAO
}