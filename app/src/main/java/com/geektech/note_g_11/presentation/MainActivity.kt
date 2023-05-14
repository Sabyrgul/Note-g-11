package com.geektech.note_g_11.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.geektech.note_g_11.R
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.ui.setupActionBarWithNavController

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.navigation)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.notesFragment, R.id.addNoteFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

}