package com.geektech.note_g_11.domain.usecase

import com.geektech.note_g_11.domain.models.Note
import com.geektech.note_g_11.domain.repository.NoteRepository

class UpdateNoteUseCase(private val repository: NoteRepository) {

    fun updateNote(note:Note)=repository.updateNote(note)
}