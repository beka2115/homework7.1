package com.example.homework71.domain.usecases

import com.example.homework71.domain.repository.NoteRepository

class GetNotesUseCase(
    private val noteRepository: NoteRepository
) {

    fun getNotes() = noteRepository.getNotes()

}