package com.geektech.note_g_11.di

import com.geektech.note_g_11.data.repository.NoteRepositoryImpl
import com.geektech.note_g_11.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun NoteRepository(noteRepositoryImpl: NoteRepositoryImpl):NoteRepository
}