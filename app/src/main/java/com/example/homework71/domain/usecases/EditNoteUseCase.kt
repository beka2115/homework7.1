package com.example.homework71.domain.usecases

import com.example.homework71.domain.model.Note
import com.example.homework71.domain.repository.NoteRepository

class EditNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun editNote(note: Note) = noteRepository.editNote(note)
}