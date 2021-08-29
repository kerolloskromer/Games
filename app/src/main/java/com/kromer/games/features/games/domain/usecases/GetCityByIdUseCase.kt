package com.kromer.games.features.games.domain.usecases

import com.kromer.games.core.usecases.UseCase
import com.kromer.games.features.games.domain.entities.Game
import com.kromer.games.features.games.domain.repositories.GamesRepository

class GetCityByIdUseCase(private val gamesRepository: GamesRepository) :
    UseCase<Game?, Long> {
    override suspend fun call(params: Long): Game? =
        gamesRepository.getById(params)
}