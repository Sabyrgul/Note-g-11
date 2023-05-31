package com.geektech.note_g_11.presentation.add_note

import com.geektech.note_g_11.domain.models.Note
import com.geektech.note_g_11.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val createNoteUseCase: com.geektech.note_g_11.domain.usecase.CreateNoteUseCase,
    private val updateNoteUseCase: com.geektech.note_g_11.domain.usecase.UpdateNoteUseCase
) : BaseViewModel() {

    private val _createState = MutableStateFlow<com.geektech.note_g_11.domain.UIState<Unit>>(com.geektech.note_g_11.domain.UIState.Loading())
    val createState: StateFlow<com.geektech.note_g_11.domain.UIState<Unit>> = _createState.asStateFlow()

    private val _updateState = MutableStateFlow<com.geektech.note_g_11.domain.UIState<Unit>>(com.geektech.note_g_11.domain.UIState.Loading())
    val updateState: StateFlow<com.geektech.note_g_11.domain.UIState<Unit>> = _updateState.asStateFlow()

    fun create(note: Note) {
        if (note.title.isNotEmpty()&&note.title.isNotBlank()){
            createNoteUseCase(note).collectFlow(_createState)
        }
        else {
            _createState.value= com.geektech.note_g_11.domain.UIState.Error("Title is empty")
        }
    }

    fun editNote(note: Note){
        if (note.title.isNotEmpty()&&note.title.isNotBlank()){
            updateNoteUseCase(note).collectFlow(_updateState)
        }
        else {
            _updateState.value= com.geektech.note_g_11.domain.UIState.Error("Title is empty")
        }
    }

}