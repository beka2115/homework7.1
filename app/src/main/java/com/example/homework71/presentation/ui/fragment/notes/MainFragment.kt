package com.example.homework71.presentation.ui.fragment.notes

import android.app.AlertDialog
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework71.R
import com.example.homework71.databinding.FragmentMainBinding
import com.example.homework71.domain.model.Note
import com.example.homework71.presentation.base.BaseFragment
import com.example.homework71.presentation.ui.MainViewModel
import com.example.homework71.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainViewModel by viewModels()
    private lateinit var builder: AlertDialog.Builder
    private lateinit var adapter: NoteListAdapter
    private var listAdapter= NoteListAdapter(this::onLongNoteClick,this::onNoteClick)
    private var notePosition: Int? = null

    companion object {
        const val KEY_FOR_UPDATE_NOTE = "keyUpdate"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        builder = AlertDialog.Builder(requireContext())
    }

    override fun initClickListeners() {
        with(binding) {
            btnEdit.setOnClickListener {
                findNavController().navigate(R.id.createNoteFragment)
            }
        }
    }

    override fun initialize() {
        builder = AlertDialog.Builder(requireContext())
        with(binding) {
            recyclerNotes.layoutManager = LinearLayoutManager(context)
            recyclerNotes.adapter = adapter
        }
    }

    override fun setupSubscribers() {
        viewModel.deleteNoteState.collectUIState(
            state = { state ->
                binding.progress.isVisible = state is UIState.Loading
            },
            onSuccess = {
                viewModel.getNotes()
            }
        )
        viewModel.getNotesState.collectUIState(
            state = { state ->
                binding.progress.isVisible = state is UIState.Loading
            },
            onSuccess = { data ->
                adapter.submitList(data)
            }
        )
    }

    private fun onLongNoteClick(note:Note) {
        builder.setTitle("Delete").setMessage("Do you want to delete?")
            .setCancelable(true)
            .setPositiveButton("Yes") { dialogInterface, _ ->
                viewModel.deleteNote(note)
                dialogInterface.dismiss()
            }
            .setNegativeButton("Cancel") { dialogInterface, _ ->
                dialogInterface.cancel()
                notePosition = null
            }
            .show()
    }

    private fun onNoteClick(note: Note) {
        findNavController().navigate(R.id.createNoteFragment, bundleOf(KEY_FOR_UPDATE_NOTE to note))
    }

    override fun setupRequests() {
        viewModel.getNotes()
    }
}