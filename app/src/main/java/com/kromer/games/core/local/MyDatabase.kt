package com.kromer.games.core.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kromer.games.features.games.domain.entities.Game

@Database(entities = [Game::class], version = MyDatabase.DATABASE_VERSION)
abstract class MyDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "GamesDatabase"
    }
}