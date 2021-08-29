package com.kromer.games.core.usecases

interface UseCase<T, Params> {
    suspend fun call(params: Params): T
}