package com.kromer.games.features.games.data.sources.remote

import com.kromer.games.features.games.domain.entities.Game
import com.kromer.games.features.games.domain.entities.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GamesApiInterface {
    @GET("games")
    suspend fun getGames(
        @Query("page_size") pageSize: Int,
        @Query("page") page: Int,
    ): GamesResponse

    @GET("games/{id}")
    suspend fun getGame(
        @Path("id") id: String
    ): Game
}