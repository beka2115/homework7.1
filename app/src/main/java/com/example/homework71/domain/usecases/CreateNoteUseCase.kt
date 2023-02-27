package com.example.homework71.domain.usecases

import com.example.homework71.domain.model.Note
import com.example.homework71.domain.repository.NoteRepository

class CreateNoteUseCase(
    private val noteRepository: NoteRepository
) {
    fun createNote(note: Note) = noteRepository.createNote(note)
}