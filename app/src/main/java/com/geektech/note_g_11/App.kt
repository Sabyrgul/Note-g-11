package com.geektech.note_g_11

import android.app.Application
import androidx.room.Room
import com.geektech.note_g_11.data.local.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application() {

    companion object{
        lateinit var db:AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        db= Room.databaseBuilder(
            applicationContext,
            AppDataBase::class.java,"app-database"
        ).allowMainThreadQueries().build()
    }
}