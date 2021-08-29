package com.kromer.games.core.usecases

interface NoParamUseCase<T> {
    fun call(): T
}