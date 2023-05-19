package com.geektech.note_g_11.presentation.add_note

import androidx.lifecycle.ViewModel
import com.geektech.note_g_11.domain.models.Note
import com.geektech.note_g_11.domain.usecase.CreateNoteUseCase
import com.geektech.note_g_11.domain.usecase.UpdateNoteUseCase
import com.geektech.note_g_11.domain.utils.UIState
import com.geektech.note_g_11.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase
) : BaseViewModel() {

    private val _createState = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val createState: StateFlow<UIState<Unit>> = _createState.asStateFlow()

    private val _updateState = MutableStateFlow<UIState<Unit>>(UIState.Loading())
    val updateState: StateFlow<UIState<Unit>> = _updateState.asStateFlow()

    fun create(note: Note) {
        createNoteUseCase(note).collectFlow(_createState)
    }

    fun update(note: Note){
        updateNoteUseCase(note).collectFlow(_updateState)
    }

}