package com.geektech.note_g_11.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.geektech.note_g_11.domain.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>
    (private val bindingInflater: (layoutInflater: LayoutInflater) -> VB) : Fragment() {

    abstract val viewModel: VM
    private var _binding: VB? = null

    protected val binding:VB get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= bindingInflater.invoke(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        initObservers()
    }

    protected open fun initObservers() {}
    protected open fun initListeners() {}
    protected open fun initViews() {}

    protected fun <T> StateFlow<UIState<T>>.collectStateFlow(
        loading: () -> Unit, error: (String) -> Unit, success: (T?) -> Unit
    ) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectStateFlow.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(requireContext(), it.msg, Toast.LENGTH_LONG).show()
                            error(it.msg)
                        }
                        is UIState.Loading -> {
                            loading()
                        }
                        is UIState.Success -> {
                            success(it.data)
                        }
                    }
                }
            }
        }
    }
}