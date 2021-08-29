package com.kromer.games.features.games.domain.usecases

import com.kromer.games.core.usecases.UseCase
import com.kromer.games.features.games.domain.entities.Game
import com.kromer.games.features.games.domain.repositories.GamesRepository

class AddGameUseCase(private val gamesRepository: GamesRepository) :
    UseCase<Unit, Game> {
    override suspend fun call(params: Game): Unit =
        gamesRepository.add(params)
}