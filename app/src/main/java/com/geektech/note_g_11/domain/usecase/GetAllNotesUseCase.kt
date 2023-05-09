package com.geektech.note_g_11.domain.usecase

import com.geektech.note_g_11.domain.repository.NoteRepository

class GetAllNotesUseCase(private val repository: NoteRepository) {

    fun getAllNotes()=repository.getAllNotes()
}