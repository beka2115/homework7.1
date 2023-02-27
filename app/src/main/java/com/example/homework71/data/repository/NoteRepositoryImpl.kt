package com.example.homework71.data.repository

import com.example.homework71.data.local.NoteDao
import com.example.homework71.data.toNote
import com.example.homework71.data.toNoteEntity
import com.example.homework71.domain.model.Note
import com.example.homework71.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {
    override fun createNote(note: Note) {
        noteDao.createNote(note.toNoteEntity())
    }

    override fun editNote(note: Note) {
        noteDao.editNote(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) {
        noteDao.deleteNote(note.toNoteEntity())
    }

    override fun getNotes(): List<Note> {
      return  noteDao.getNotes().map { it.toNote() }
    }
}