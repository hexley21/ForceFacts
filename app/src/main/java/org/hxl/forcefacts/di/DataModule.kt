package org.hxl.forcefacts.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.hxl.cache.StarWarsLocalImpl
import org.hxl.cache.starwars.character.CharacterDAO
import org.hxl.cache.starwars.film.FilmDAO
import org.hxl.cache.starwars.starship.StarShipDAO
import org.hxl.data.StarWarsRepositoryImpl
import org.hxl.data.repository.StarWarsLocal
import org.hxl.data.repository.StarWarsRemote
import org.hxl.domain.repository.StarWarsRepository
import org.hxl.network.StarWarsRemoteImpl
import org.hxl.network.api.StarWarsService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideStarWarsRemote(service: StarWarsService): StarWarsRemote {
        return StarWarsRemoteImpl(service)
    }

    @Provides
    @Singleton
    fun provideStarWarsLocal(characterDAO: CharacterDAO, starShipDAO: StarShipDAO, filmDAO: FilmDAO): StarWarsLocal {
        return StarWarsLocalImpl(characterDAO, starShipDAO, filmDAO)
    }

    @Provides
    @Singleton
    fun provideStarWarsRepository(remote: StarWarsRemote, local: StarWarsLocal): StarWarsRepository {
        return StarWarsRepositoryImpl(remote, local)
    }
}