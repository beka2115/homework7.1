package com.example.homework71.presentation.ui.fragment.createnote

import android.annotation.SuppressLint
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.homework71.R
import com.example.homework71.databinding.FragmentCreateNoteBinding
import com.example.homework71.domain.model.Note
import com.example.homework71.presentation.base.BaseFragment
import com.example.homework71.presentation.ui.MainViewModel
import com.example.homework71.presentation.ui.fragment.notes.MainFragment
import com.example.homework71.presentation.utils.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateNoteFragment : BaseFragment(R.layout.fragment_create_note) {

    private val binding by viewBinding(FragmentCreateNoteBinding::bind)
    private val viewModel: MainViewModel by viewModels()
    private var note: Note? = null


    override fun initialize() {
        super.initialize()
        getUpdateNote()
    }
    override fun initClickListeners() {
        with(binding) {
            btnSave.setOnClickListener {
                if (editTitle.text.toString().isNotEmpty()) {
                    if (note != null) {
                        updateTask()
                    } else {
                        createNote()
                    }
                } else {
                    binding.editTitle.error = getString(R.string.error)
                }
            }

        }
    }

    override fun setupSubscribers() {
        super.setupSubscribers()
        viewModel.createNoteState.collectUIState(
            state = { state ->
                binding.progress.isVisible = state is UIState.Loading
            },
            onSuccess = {
                findNavController().navigateUp()
            }
        )
        viewModel.updateNoteState.collectUIState(
            state = { state ->
                binding.progress.isVisible = state is UIState.Loading

            },
            onSuccess = {
                findNavController().navigateUp()
            }
        )
    }
    @SuppressLint("SetTextI18n")
    fun getUpdateNote() {
        arguments?.let { noteData ->
            val value = noteData.getSerializable(MainFragment.KEY_FOR_UPDATE_NOTE)
            if (value != null) {
                note = value as Note
                binding.editDescription.setText(note?.description.toString())
                binding.editTitle.setText(note?.title.toString())
                if (note != null) {
                    binding.btnSave.text = "Update"
                } else {
                    binding.btnSave.text = "Save"
                }
            }
        }
    }

    private fun createNote() {
        with(binding) {
            viewModel.createNote(editTitle.text.toString(), editDescription.text.toString())
        }
    }

    private fun updateTask() {
        note?.title = binding.editTitle.text.toString()
        note?.description = binding.editDescription.text.toString()
        note?.let { viewModel.editNote(it) }
    }


}
