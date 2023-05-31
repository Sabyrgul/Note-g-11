package com.geektech.note_g_11.domain

sealed class ResultStatus<T>{
    class Loading<T>: ResultStatus<T>()
    class Success<T>(val data:T?=null): ResultStatus<T>()
    class Error<T>(val msg:String?): ResultStatus<T>()
}
