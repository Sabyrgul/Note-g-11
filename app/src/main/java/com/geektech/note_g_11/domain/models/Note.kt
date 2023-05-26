package com.geektech.note_g_11.domain.models

import java.io.Serializable

data class Note(
    val id: Int= DEFAULT_ID, val title: String, val description: String, val createdAt: Long
): Serializable{
    companion object{
        const val DEFAULT_ID=0
    }
}