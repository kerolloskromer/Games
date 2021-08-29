package com.kromer.games.features.games.data.sources.remote

import com.kromer.games.features.games.domain.entities.Game
import com.kromer.games.features.games.domain.entities.GamesRequest
import com.kromer.games.features.games.domain.entities.GamesResponse

class GamesRemoteDataSourceImpl(private val gamesApiInterface: GamesApiInterface) :
    GamesRemoteDataSource {
    override suspend fun getGames(request: GamesRequest): GamesResponse =
        gamesApiInterface.getGames(request.pageSize, request.page)

    override suspend fun getGame(id: String): Game = gamesApiInterface.getGame(id)
}