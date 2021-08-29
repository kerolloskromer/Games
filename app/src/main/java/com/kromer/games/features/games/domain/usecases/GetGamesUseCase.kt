package com.kromer.games.features.games.domain.usecases

import com.kromer.games.core.usecases.UseCase
import com.kromer.games.features.games.domain.entities.Game
import com.kromer.games.features.games.domain.entities.GamesRequest
import com.kromer.games.features.games.domain.repositories.GamesRepository

class GetGamesUseCase(private val gamesRepository: GamesRepository) :
    UseCase<List<Game>, GamesRequest> {
    override suspend fun call(params: GamesRequest): List<Game> = gamesRepository.getAll(params)
}