package com.geektech.note_g_11.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.note_g_11.data.models.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
}