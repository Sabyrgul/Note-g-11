package com.geektech.note_g_11.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.note_g_11.domain.ResultStatus
import com.geektech.note_g_11.domain.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> Flow<ResultStatus<T>>.collectFlow(
        state: MutableStateFlow<UIState<T>>
    ) {
        viewModelScope.launch {
            this@collectFlow.collect {
                when (it) {
                    is ResultStatus.Error -> {
                        state.value = it.msg?.let { it1 -> UIState.Error(it1) }!!
                    }
                    is ResultStatus.Loading -> {
                        state.value = UIState.Loading()
                    }
                    is ResultStatus.Success -> {
                        state.value = UIState.Success(it.data)
                    }
                }
            }
        }

    }

}