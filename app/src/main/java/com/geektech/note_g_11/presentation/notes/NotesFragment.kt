package com.geektech.note_g_11.presentation.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.geektech.note_g_11.R
import com.geektech.note_g_11.databinding.FragmentNotesBinding
import com.geektech.note_g_11.domain.utils.UIState
import com.geektech.note_g_11.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotesFragment() :
    BaseFragment<NotesViewModel,FragmentNotesBinding>(FragmentNotesBinding::inflate) {

    override val viewModel: NotesViewModel by viewModels()
    private val adapter=NoteAdapter()

    override fun initViews() {
        binding?.rvNotes?.adapter=adapter
    }

    override fun initListeners() {
        binding?.btnFab?.setOnClickListener {
            findNavController().navigate(R.id.addNoteFragment)
        }

    }

    override fun initObservers() {
        viewModel.noteState.collectStateFlow(
            loading = {},
            error = {},
            success = {
            }
        )

        viewModel.deleteState.collectStateFlow(
            loading = {},
            error= {},
            success = {

            }
        )
    }
}