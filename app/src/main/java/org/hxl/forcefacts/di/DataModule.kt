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

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideStarWarsRemote(service: StarWarsService): StarWarsRemote {
        return StarWarsRemoteImpl(service)
    }

    @Provides
    fun provideStarWarsRepository(remote: StarWarsRemote): StarWarsRepository {
        return StarWarsRepositoryImpl(remote)
    }
}