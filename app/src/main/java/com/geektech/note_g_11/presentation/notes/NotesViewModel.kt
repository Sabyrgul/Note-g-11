package com.geektech.note_g_11.presentation.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.note_g_11.domain.models.Note
import com.geektech.note_g_11.domain.usecase.DeleteNoteUseCase
import com.geektech.note_g_11.domain.usecase.GetAllNotesUseCase
import com.geektech.note_g_11.domain.utils.ResultStatus
import com.geektech.note_g_11.domain.utils.UIState
import com.geektech.note_g_11.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//@Inject сгенерировать
@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : BaseViewModel() {

    private val _notesState = MutableStateFlow<UIState<List<Note>>>(UIState.Loading())
    val noteState: StateFlow<UIState<List<Note>>> = _notesState.asStateFlow()

    private val _deleteState = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val deleteState: StateFlow<UIState<Unit>> = _deleteState.asStateFlow()

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