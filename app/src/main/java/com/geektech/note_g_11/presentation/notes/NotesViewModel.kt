package com.geektech.note_g_11.presentation.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.note_g_11.domain.models.Note
import com.geektech.note_g_11.domain.usecase.DeleteNoteUseCase
import com.geektech.note_g_11.domain.usecase.GetAllNotesUseCase
import com.geektech.note_g_11.domain.utils.ResultStatus
import com.geektech.note_g_11.domain.utils.UIState
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
) : ViewModel() {

    private val _notesState = MutableStateFlow<UIState<List<Note>>>(UIState.Loading())
    val noteState: StateFlow<UIState<List<Note>>> = _notesState.asStateFlow()

    init {
        getAllNotes()
    }

    fun getAllNotes() {
        viewModelScope.launch {
            getAllNotesUseCase.getAllNotes().collect {
                when (it) {
                    is ResultStatus.Error -> {
                        _notesState.value = UIState.Error(it.msg!!)

                    }
                    is ResultStatus.Loading -> {
                        _notesState.value = UIState.Loading()

                    }
                    is ResultStatus.Success -> {
                        if (it.data != null)
                            _notesState.value = UIState.Success(it.data)
                        else _notesState.value =
                            UIState.Error("List is empty! Please add some notes!")
                    }
                }
            }
        }
    }
}