package com.kromer.games.features.games.data.sources.local

import androidx.lifecycle.LiveData
import com.kromer.games.features.games.domain.entities.Game

class GamesLocalDataSourceImpl(private val gamesDao: GamesDao) :
    GamesLocalDataSource {
    override fun getAll(): LiveData<List<Game>> = gamesDao.getAll()
    override suspend fun getById(id: Long): Game? = gamesDao.getById(id)
    override suspend fun insert(game: Game) = gamesDao.insert(game)
    override suspend fun delete(game: Game) = gamesDao.delete(game)
}