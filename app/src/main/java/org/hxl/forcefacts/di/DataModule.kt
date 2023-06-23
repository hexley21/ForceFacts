package org.hxl.forcefacts.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.hxl.data.StarWarsRepositoryImpl
import org.hxl.data.repository.StarWarsRemote
import org.hxl.domain.repository.StarWarsRepository
import org.hxl.network.StarWarsRemoteImpl
import org.hxl.network.api.StarWarsService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideStarWarsRemote(service: StarWarsService): StarWarsRemote {
        return StarWarsRemoteImpl(service)
    }

    @Provides
    @Singleton
    fun provideStarWarsRepository(remote: StarWarsRemote): StarWarsRepository {
        return StarWarsRepositoryImpl(remote)
    }
}