package com.geektech.note_g_11.domain.utils

sealed class UIState<T>{
    class Loading<T>:UIState<T>()
    class Success<T>(val data:T):UIState<T>()
    class Error<T>(val msg:String?):UIState<T>()
    class Empty<T>:UIState<T>()

}
