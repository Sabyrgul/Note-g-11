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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : Fragment() {

    private var binding: FragmentAddNoteBinding? = null
    private val viewModel:AddNoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(LayoutInflater.from(context), container, false)
        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding?.btnSave?.setOnClickListener {
            val note=Note(
                title = binding?.etTitle?.text.toString(),
                description = binding?.etDescription?.text.toString(),
                id = 0,
                createdAt = 0
            )
            viewModel.createNote(note)
            findNavController().navigateUp()
        }
    }

}