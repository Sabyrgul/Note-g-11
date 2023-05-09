package com.geektech.note_g_11.domain.utils

sealed class ResultStatus<T>{
    class Loading<T>:ResultStatus<T>()
    class Success<T>(data:T?):ResultStatus<T>()
    class Error<T>(msg:String?):ResultStatus<T>()
}
