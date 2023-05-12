package com.geektech.note_g_11.data.repository

import com.geektech.note_g_11.data.local.NoteDao
import com.geektech.note_g_11.data.local.mappers.toNote
import com.geektech.note_g_11.data.local.mappers.toNoteEntity
import com.geektech.note_g_11.domain.models.Note
import com.geektech.note_g_11.domain.repository.NoteRepository
import com.geektech.note_g_11.domain.utils.ResultStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) : NoteRepository {

    override fun getAllNotes() = flow {
        emit(ResultStatus.Loading())
        try {
            val data = noteDao.getAllNotes().map {
                it.toNote()
            }
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.localizedMessage ?: "Unknown error"))

        }

    }.flowOn(Dispatchers.IO)

    override fun deleteNote(note: Note) = flow {
        emit(ResultStatus.Loading())
        try {
            val data = noteDao.delete(note.toNoteEntity())
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.localizedMessage))
        }

    }

    override fun createNote(note: Note) = flow {
        emit(ResultStatus.Loading())
        try {
            val data = noteDao.create(note.toNoteEntity())
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.localizedMessage))
        }
    }

    override fun updateNote(note: Note) = flow {
        emit(ResultStatus.Loading())
        try {
            val data = noteDao.update(note.toNoteEntity())
            emit(ResultStatus.Success(data))
        } catch (e: IOException) {
            emit(ResultStatus.Error(e.localizedMessage))
        }
    }
}