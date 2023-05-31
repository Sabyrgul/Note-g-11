package com.geektech.note_g_11.presentation.notes

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geektech.note_g_11.R
import com.geektech.note_g_11.databinding.FragmentNotesBinding
import com.geektech.note_g_11.domain.models.Note
import com.geektech.note_g_11.extension.showToast
import com.geektech.note_g_11.extension.visibility
import com.geektech.note_g_11.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment :
    BaseFragment<NotesViewModel, FragmentNotesBinding>(FragmentNotesBinding::inflate) {

    override val viewModel: NotesViewModel by viewModels()
    private val adapter by lazy { NoteAdapter(this::onItemClick, this::onLongItemClick) }


    override fun initViews() {
        binding.rvNotes.adapter = adapter
    }

    override fun initListeners() {
        binding.btnFab.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_addNoteFragment)
        }

    }

    override fun initObservers() {
        viewModel.noteState.collectStateFlow(
            loading = {
                binding.progressNotes.visibility(true)
            },
            error = {
                binding.progressNotes.visibility(false)
                showToast(it)
            },
            success = {
                binding.progressNotes.visibility(false)
                if (it != null)
                    adapter.update(it)
                else showToast(R.string.list_is_empty)
            }
        )

        viewModel.deleteState.collectStateFlow(
            loading = {
                binding.progressNotes.visibility(true)
            },
            error = {
                binding.progressNotes.visibility(false)
                showToast(it)
            },
            success = {
                binding.progressNotes.visibility(false)
                showToast(R.string.successfully_deleted)
                adapter.delete()
            }
        )
    }

    private fun onItemClick(note: Note) {
        val bundle = bundleOf().apply {
            putSerializable(ARG_NOTE_TO_ADD, note)
        }
        findNavController().navigate(R.id.action_notesFragment_to_addNoteFragment, bundle)
    }

    private fun onLongItemClick(note: Note) {
        viewModel.delete(note)

    }

    companion object {
        const val ARG_NOTE_TO_ADD = "edit_note"
    }

}


