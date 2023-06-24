package org.hxl.forcefacts.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.hxl.cache.room.ForceFactsDB
import org.hxl.cache.starwars.character.CharacterDAO
import org.hxl.cache.starwars.film.FilmDAO
import org.hxl.cache.starwars.starship.StarShipDAO
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class CacheModule {

    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context: Context): ForceFactsDB {
        return Room.databaseBuilder(
            context,
            ForceFactsDB::class.java,
            ForceFactsDB.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharacterDAO(db: ForceFactsDB): CharacterDAO {
        return db.characterDAO()
    }

    @Provides
    @Singleton
    fun provideStarShipDAO(db: ForceFactsDB): StarShipDAO {
        return db.starShipDAO()
    }

    @Provides
    @Singleton
    fun provideFilmDAO(db: ForceFactsDB): FilmDAO {
        return db.filmDAO()
    }
}