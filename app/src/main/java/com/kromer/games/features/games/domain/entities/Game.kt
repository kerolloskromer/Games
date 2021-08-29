package com.kromer.games.features.games.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class Game(
    @PrimaryKey
    val id: Long,
    val name: String,
)
