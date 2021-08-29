package com.kromer.games.features.games.data.sources.local

import androidx.lifecycle.LiveData
import com.kromer.games.features.games.domain.entities.Game

interface GamesLocalDataSource {
    fun getAll(): LiveData<List<Game>>
    suspend fun getById(id: Long): Game?
    suspend fun insert(game: Game)
    suspend fun delete(game: Game)
}