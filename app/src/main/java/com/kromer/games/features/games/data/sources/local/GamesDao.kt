package com.kromer.games.features.games.data.sources.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kromer.games.features.games.domain.entities.Game

/**
 * Data Access Object for the games table.
 */
@Dao
interface GamesDao {
    /**
     * Select all games from the games table.
     *
     * @return all games.
     */
    @Query("SELECT * FROM games")
    fun getAll(): LiveData<List<Game>>

    /**
     * Select all games from the games table that matches this date.
     *
     * @return all games.
     */
    @Query("SELECT * FROM games WHERE name = :name")
    suspend fun getByName(name: String): Game?

    /**
     * Select a game by id.
     *
     * @param id the game id.
     * @return the game with id.
     */
    @Query("SELECT * FROM games WHERE id = :id")
    suspend fun getById(id: Long): Game?

    /**
     * Insert games in the database. If the game already exists, replace it.
     *
     * @param games the games to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(games: List<Game>)

    /**
     * Insert game in the database. If the game already exists, replace it.
     *
     * @param game the game to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(game: Game)

    @Delete
    fun delete(game: Game)
}