package com.kromer.games.features.games.data.sources.remote

import com.kromer.games.features.games.domain.entities.GamesRequest
import com.kromer.games.features.games.domain.entities.GamesResponse

interface GamesRemoteDataSource {
    suspend fun getGames(request: GamesRequest): GamesResponse
}