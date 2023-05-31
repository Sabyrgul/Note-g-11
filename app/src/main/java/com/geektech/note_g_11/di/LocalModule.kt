package com.geektech.note_g_11.di

import android.content.Context
import androidx.room.Room
import com.geektech.note_g_11.data.local.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun database(@ApplicationContext context: Context): AppDataBase = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        "Note-DB"
    )
        .build()

    @Provides
    fun noteDao(appDataBase: AppDataBase) = appDataBase.noteDao()
}