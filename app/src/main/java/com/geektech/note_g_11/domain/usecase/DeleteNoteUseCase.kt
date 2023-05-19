package com.geektech.note_g_11.domain.usecase

import com.geektech.note_g_11.domain.models.Note
import com.geektech.note_g_11.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(private val repository: NoteRepository) {

    operator fun invoke(note: Note)=repository.deleteNote(note)
}