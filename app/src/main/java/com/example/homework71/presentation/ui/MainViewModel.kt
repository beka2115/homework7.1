package com.example.homework71.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework71.domain.model.Note
import com.example.homework71.domain.usecases.CreateNoteUseCase
import com.example.homework71.domain.usecases.GetNotesUseCase
import com.example.homework71.domain.utils.Resource
import com.example.homework71.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val createNoteUseCase: CreateNoteUseCase
) : ViewModel() {

    private val _getNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getNotesState = _getNotesState.asStateFlow()

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())

    fun getNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            getNotesUseCase.getNotes().collect { res ->
                when (res) {
                    is Resource.Error -> {
                        if (res.message != null) {
                            _getNotesState.value = UIState.Error(res.message)
                        }
                    }
                    is Resource.Loading -> {
                        _getNotesState.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (res.data != null) {
                            _getNotesState.value = UIState.Success(res.data)
                        }
                    }
                }
            }
        }
    }

    fun createNote(title: String, description: String) {

        viewModelScope.launch(Dispatchers.IO) {
            createNoteUseCase.createNote(Note(title = title, description = description))
                .collect { res ->
                    when (res) {
                        is Resource.Error -> {
                            if (res.message != null) {
                                _createNoteState.value = UIState.Error(res.message)
                            }
                        }
                        is Resource.Loading -> {
                            _createNoteState.value = UIState.Loading()
                        }
                        is Resource.Success -> {
                            if (res.data != null) {
                               _createNoteState.value =  UIState.Success(res.data)
                            }
                        }
                    }
                }
        }
    }
}

