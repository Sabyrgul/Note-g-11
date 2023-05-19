package com.geektech.note_g_11.domain.usecase

import com.geektech.note_g_11.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(private val repository: NoteRepository) {

   operator fun invoke()=repository.getAllNotes()
}