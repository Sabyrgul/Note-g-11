package com.geektech.note_g_11.data.local.mappers

import com.geektech.note_g_11.data.models.NoteEntity
import com.geektech.note_g_11.domain.models.Note

fun Note.toNoteEntity(): NoteEntity {
    return NoteEntity(
        id, title, description, createdAt
    )
}

fun NoteEntity.toNote(): Note {
    return Note(
        id, title, description, createdAt
    )
}