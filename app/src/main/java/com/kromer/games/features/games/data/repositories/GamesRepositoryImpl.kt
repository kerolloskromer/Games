package com.kromer.games.features.games.data.repositories

import com.kromer.games.features.games.data.sources.local.GamesLocalDataSource
import com.kromer.games.features.games.data.sources.remote.GamesRemoteDataSource
import com.kromer.games.features.games.domain.entities.Game
import com.kromer.games.features.games.domain.entities.GamesRequest
import com.kromer.games.features.games.domain.repositories.GamesRepository

class GamesRepositoryImpl(
    private val remoteDataSource: GamesRemoteDataSource,
    private val localDataSource: GamesLocalDataSource
) :
    GamesRepository {
    override suspend fun getAll(request: GamesRequest): List<Game> =
        remoteDataSource.getGames(request).list

    override suspend fun getById(id: Long): Game? = localDataSource.getById(id)

    override suspend fun add(game: Game) = localDataSource.insert(game)

    override suspend fun delete(game: Game) = localDataSource.delete(game)

}