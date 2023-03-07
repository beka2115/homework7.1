package com.example.homework71.presentation.ui.fragment.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework71.R
import com.example.homework71.databinding.FragmentMainBinding
import com.example.homework71.presentation.ui.MainViewModel
import com.example.homework71.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        setUpRequests()
        setUpSubscribers()
        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnEdit.setOnClickListener {
                findNavController().navigate(R.id.createNoteFragment)
            }
        }
    }

    private fun initView() {
        with(binding) {
            recyclerNotes.layoutManager = LinearLayoutManager(context)
            recyclerNotes.adapter = adapter
        }
    }

    private fun setUpSubscribers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getNotesState.collect { state ->
                    when (state) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                        is UIState.Loading -> {
                            // TODO show progress bar
                        }
                        is UIState.Success -> {
                            adapter.addAllNotes(state.data)
                        }
                    }

                }
            }
        }
    }

    private fun setUpRequests() {
        viewModel.getNotes()
    }

}