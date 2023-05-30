package com.geektech.note_g_11.presentation.add_note

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geektech.note_g_11.R
import com.geektech.note_g_11.databinding.FragmentAddNoteBinding
import com.geektech.note_g_11.domain.models.Note
import com.geektech.note_g_11.domain.utils.extension.showToast
import com.geektech.note_g_11.domain.utils.extension.visibility
import com.geektech.note_g_11.presentation.base.BaseFragment
import com.geektech.note_g_11.presentation.notes.NotesFragment
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class AddNoteFragment :
    BaseFragment<AddNoteViewModel, FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate) {


    override val viewModel: AddNoteViewModel by viewModels()
    private val note by lazy{ requireArguments().getSerializable(NotesFragment.ARG_NOTE_TO_ADD) as Note? }

    override fun initViews() {
        if(arguments!=null){
            binding.etTitle.setText(note?.title)
            binding.etDescription.setText(note?.description)
        }
    }
    override fun initListeners() {
        binding.btnSave.setOnClickListener {
            val note = Note(
                title = binding.etTitle.text.toString(),
                description = binding.etDescription.text.toString(),
                createdAt = System.currentTimeMillis()
            )
            viewModel.create(note)
            findNavController().navigateUp()
            if(arguments!=null){
                viewModel.editNote(note.copy(
                    title = binding.etTitle.text.toString(),
                    description = binding.etDescription.text.toString()
                ))
            }
            else{
                if(note!=null){
                viewModel.create(note!!)
                findNavController().navigateUp()}
            }
            }

        }

    override fun initObservers() {
        with(binding){
        viewModel.createState.collectStateFlow(
            loading = {
                addProgress.visibility(true)
        },
            error = {
                addProgress.visibility(false)
                showToast(it)
            },
            success = {
                addProgress.visibility(false)
                showToast(R.string.successfully_created)
                findNavController().navigateUp()
        })
           viewModel.updateState.collectStateFlow(
                loading = {
                    addProgress.visibility(true)
                },
                error = {
                    addProgress.visibility(false)
                    showToast(it)
                },
                success = {
                    addProgress.visibility(false)
                    showToast(R.string.note_successfully_edited)
                    findNavController().navigateUp()
                })

    }}

}