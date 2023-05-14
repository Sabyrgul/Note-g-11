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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotesFragment : Fragment() {

    private var binding: FragmentNotesBinding? = null
    private val viewModel: NotesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentNotesBinding.inflate(LayoutInflater.from(context), container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        setupObservers()
    }

    private fun initListener() {
        binding?.btnFab?.setOnClickListener {
            findNavController().navigate(R.id.addNoteFragment)
        }
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.noteState.collect {
                    when (it) {
                        is UIState.Empty -> TODO()
                        is UIState.Error -> TODO()
                        is UIState.Loading -> TODO()
                        is UIState.Success -> TODO()
                    }
                }
            }
        }

    }
}