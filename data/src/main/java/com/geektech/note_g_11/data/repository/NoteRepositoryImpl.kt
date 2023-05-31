package com.geektech.note_g_11.data.repository

import com.geektech.note_g_11.domain.models.Note
import com.geektech.note_g_11.domain.repository.NoteRepository
import com.geektech.note_g_11.data.base.BaseRepository
import com.geektech.note_g_11.data.local.NoteDao
import com.geektech.note_g_11.data.local.mappers.toNote
import com.geektech.note_g_11.data.local.mappers.toNoteEntity
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(private val noteDao: NoteDao) : NoteRepository,
    BaseRepository() {

    override fun getAllNotes() = doRequest {
        noteDao.getAllNotes().map {
            it.toNote()
        }
    }

    override fun deleteNote(note: Note) = doRequest {
        noteDao.delete(note.toNoteEntity())
    }

    override fun createNote(note: Note) = doRequest {
        noteDao.create(note.toNoteEntity())
    }

    override fun updateNote(note: Note) = doRequest {
        noteDao.update(note.toNoteEntity())
    }
}