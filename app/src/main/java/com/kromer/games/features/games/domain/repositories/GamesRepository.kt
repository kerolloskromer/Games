package com.kromer.games.features.games.domain.repositories

import com.kromer.games.features.games.domain.entities.Game
import com.kromer.games.features.games.domain.entities.GamesRequest

interface GamesRepository {
    suspend fun getAll(request: GamesRequest): List<Game>
    suspend fun getById(id: Long): Game?
    suspend fun add(game: Game)
    suspend fun delete(game: Game)
}