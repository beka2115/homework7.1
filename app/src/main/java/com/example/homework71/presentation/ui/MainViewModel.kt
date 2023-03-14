package com.example.homework71.presentation.ui

import com.example.homework71.domain.model.Note
import com.example.homework71.domain.usecases.CreateNoteUseCase
import com.example.homework71.domain.usecases.DeleteNoteUseCase
import com.example.homework71.domain.usecases.EditNoteUseCase
import com.example.homework71.domain.usecases.GetNotesUseCase
import com.example.homework71.presentation.base.BaseViewModel
import com.example.homework71.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNotesUseCase: GetNotesUseCase,
    private val createNoteUseCase: CreateNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase,
    private val updateNoteUseCase: EditNoteUseCase
) : BaseViewModel() {

    private val _getNotesState = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
    val getNotesState = _getNotesState.asStateFlow()

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _deleteNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteNoteState = _deleteNoteState.asStateFlow()

    private val _updateNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val updateNoteState = _updateNoteState.asStateFlow()

    fun editNote(note:Note){
        updateNoteUseCase(note).collectFlow(_updateNoteState)
    }

    fun getNotes() {
    getNotesUseCase().collectFlow(_getNotesState)
    }

    fun createNote(title: String, description: String) {
        createNoteUseCase(Note(title = title, description = description)).collectFlow(_createNoteState)
    }

    fun deleteNote(note: Note) {
        deleteNoteUseCase(note).collectFlow(_deleteNoteState)
    }
}

