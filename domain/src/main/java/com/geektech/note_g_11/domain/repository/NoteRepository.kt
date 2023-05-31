package com.geektech.note_g_11.domain.repository

import com.geektech.note_g_11.domain.ResultStatus
import com.geektech.note_g_11.domain.models.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getAllNotes(): Flow<ResultStatus<List<Note>>>
    fun deleteNote(note: Note):Flow<ResultStatus<Unit>>
    fun createNote(note: Note):Flow<ResultStatus<Unit>>
    fun updateNote(note: Note):Flow<ResultStatus<Unit>>
}