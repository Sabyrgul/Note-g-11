package com.geektech.note_g_11.data.local

import androidx.room.*
import com.geektech.note_g_11.data.models.NoteEntity

@Dao
interface NoteDao {

    @Delete
    suspend fun delete(noteEntity: NoteEntity)

    @Insert
    suspend fun create(noteEntity: NoteEntity)

    @Update
    suspend fun update(noteEntity: NoteEntity)

    @Query("SELECT * FROM note_entity")
    suspend fun getAllNotes(): List<NoteEntity>

}