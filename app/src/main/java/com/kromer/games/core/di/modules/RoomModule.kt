package com.kromer.games.core.di.modules

import android.content.Context
import androidx.room.Room
import com.kromer.games.core.local.MyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MyDatabase =
        Room.databaseBuilder(context, MyDatabase::class.java, MyDatabase.DATABASE_NAME).build()
}