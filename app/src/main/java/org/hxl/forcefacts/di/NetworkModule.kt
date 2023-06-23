package org.hxl.forcefacts.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.hxl.forcefacts.BuildConfig
import org.hxl.network.api.ServiceFactory
import org.hxl.network.api.StarWarsService

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    fun provideStarWarsService(): StarWarsService {
        return ServiceFactory.createCinema(BuildConfig.DEBUG, "https://swapi.dev/api/")
    }
}