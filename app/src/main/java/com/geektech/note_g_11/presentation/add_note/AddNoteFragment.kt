package com.geektech.note_g_11.presentation.add_note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geektech.note_g_11.R
import com.geektech.note_g_11.databinding.FragmentAddNoteBinding
import com.geektech.note_g_11.domain.models.Note
import com.geektech.note_g_11.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : BaseFragment<AddNoteViewModel,FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate) {

    override val viewModel:AddNoteViewModel by viewModels()

    override fun initListeners() {
        binding?.btnSave?.setOnClickListener {
            val note=Note(
                title = binding?.etTitle?.text.toString(),
                description = binding?.etDescription?.text.toString(),
                id = 0,
                createdAt = 0
            )
            viewModel.createState.collectStateFlow(
                loading = {},
                error = {},
                success = {
                    viewModel.create(note)
                }
            )

            viewModel.updateState.collectStateFlow(
                loading = {},
                error = {},
                success = {
                    viewModel.update(note)
                }
            )

            findNavController().navigateUp()
        }
    }

}