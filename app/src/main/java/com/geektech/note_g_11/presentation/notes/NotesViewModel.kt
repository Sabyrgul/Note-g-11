package com.geektech.note_g_11.presentation.notes

import com.geektech.note_g_11.domain.models.Note
import com.geektech.note_g_11.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

//@Inject сгенерировать
@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: com.geektech.note_g_11.domain.usecase.GetAllNotesUseCase,
    private val deleteNoteUseCase: com.geektech.note_g_11.domain.usecase.DeleteNoteUseCase
) : BaseViewModel() {

    private val _notesState = MutableStateFlow<com.geektech.note_g_11.domain.UIState<List<Note>>>(
        com.geektech.note_g_11.domain.UIState.Loading())
    val noteState: StateFlow<com.geektech.note_g_11.domain.UIState<List<Note>>> = _notesState.asStateFlow()

    private val _deleteState = MutableStateFlow<com.geektech.note_g_11.domain.UIState<Unit>>(com.geektech.note_g_11.domain.UIState.Loading())
    val deleteState: StateFlow<com.geektech.note_g_11.domain.UIState<Unit>> = _deleteState.asStateFlow()

    init {
        getAllNotes()
    }

    fun getAllNotes() {
        getAllNotesUseCase().collectFlow(_notesState)
    }

    fun delete(note: Note){
        deleteNoteUseCase(note).collectFlow(_deleteState)
    }
}