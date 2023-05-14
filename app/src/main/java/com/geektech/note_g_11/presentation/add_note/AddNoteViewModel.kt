package com.geektech.note_g_11.presentation.add_note

import androidx.lifecycle.ViewModel
import com.geektech.note_g_11.domain.models.Note
import com.geektech.note_g_11.domain.usecase.CreateNoteUseCase
import com.geektech.note_g_11.domain.usecase.UpdateNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
) : ViewModel() {

    fun createNote(note: Note) {
        createNoteUseCase.createNote(note)
    }

}