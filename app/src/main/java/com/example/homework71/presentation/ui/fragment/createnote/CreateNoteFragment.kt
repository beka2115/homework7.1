package com.example.homework71.presentation.ui.fragment.createnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.homework71.databinding.FragmentCreateNoteBinding
import com.example.homework71.presentation.ui.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateNoteFragment : Fragment() {

    private lateinit var binding: FragmentCreateNoteBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        with(binding) {
            btnSave.setOnClickListener {
                setUpRequests()
            }
        }
    }

    private fun setUpRequests() {
        with(binding) {
            if (editDescription.text.isNotEmpty() && editTitle.text.isNotEmpty()) {
                viewModel.createNote(editTitle.text.toString(), editDescription.text.toString())
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Fill the blanks", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
