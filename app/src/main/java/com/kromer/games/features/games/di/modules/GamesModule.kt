package com.kromer.games.features.games.di.modules

import com.kromer.games.core.local.MyDatabase
import com.kromer.games.features.games.data.repositories.GamesRepositoryImpl
import com.kromer.games.features.games.data.sources.local.GamesDao
import com.kromer.games.features.games.data.sources.local.GamesLocalDataSource
import com.kromer.games.features.games.data.sources.local.GamesLocalDataSourceImpl
import com.kromer.games.features.games.data.sources.remote.GamesApiInterface
import com.kromer.games.features.games.data.sources.remote.GamesRemoteDataSource
import com.kromer.games.features.games.data.sources.remote.GamesRemoteDataSourceImpl
import com.kromer.games.features.games.domain.repositories.GamesRepository
import com.kromer.games.features.games.domain.usecases.AddGameUseCase
import com.kromer.games.features.games.domain.usecases.DeleteGameUseCase
import com.kromer.games.features.games.domain.usecases.GetCityByIdUseCase
import com.kromer.games.features.games.domain.usecases.GetGamesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GamesModule {

    @Provides
    @Singleton
    fun provideGamesApiInterface(retrofit: Retrofit): GamesApiInterface =
        retrofit.create(GamesApiInterface::class.java)

    @Provides
    @Singleton
    fun provideGamesDao(myDatabase: MyDatabase) = myDatabase.getGamesDao()

    @Provides
    @Singleton
    fun provideGamesRemoteDataSource(
        apiInterface: GamesApiInterface
    ): GamesRemoteDataSource {
        return GamesRemoteDataSourceImpl(
            apiInterface
        )
    }

    @Provides
    @Singleton
    fun provideGamesLocalDataSource(
        gamesDao: GamesDao
    ): GamesLocalDataSource {
        return GamesLocalDataSourceImpl(
            gamesDao
        )
    }

    @Provides
    @Singleton
    fun provideGamesRepository(
        gamesRemoteDataSource: GamesRemoteDataSource,
        gamesLocalDataSource: GamesLocalDataSource
    ): GamesRepository {
        return GamesRepositoryImpl(
            gamesRemoteDataSource,
            gamesLocalDataSource
        )
    }

    @Provides
    @Singleton
    fun provideGamesUseCase(
        repository: GamesRepository
    ): GetGamesUseCase {
        return GetGamesUseCase(
            repository
        )
    }

    @Provides
    @Singleton
    fun provideCityByIdUseCase(
        repository: GamesRepository
    ): GetCityByIdUseCase {
        return GetCityByIdUseCase(
            repository
        )
    }

    @Provides
    @Singleton
    fun provideAddCityUseCase(
        repository: GamesRepository
    ): AddGameUseCase {
        return AddGameUseCase(
            repository
        )
    }

    @Provides
    @Singleton
    fun provideDeleteCityUseCase(
        repository: GamesRepository
    ): DeleteGameUseCase {
        return DeleteGameUseCase(
            repository
        )
    }
}
