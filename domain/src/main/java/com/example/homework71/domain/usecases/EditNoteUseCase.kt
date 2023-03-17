package com.example.homework71.domain.usecases

import com.example.homework71.domain.model.Note
import com.example.homework71.domain.repository.NoteRepository
import javax.inject.Inject

class EditNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {
   operator fun invoke(note: Note) = noteRepository.editNote(note)
}