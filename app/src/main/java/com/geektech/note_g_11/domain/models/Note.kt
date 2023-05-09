package com.geektech.note_g_11.domain.models

data class Note(
    val id: Int,
    val title: String,
    val description: String,
    val createdAt: Long
)