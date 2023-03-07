package com.example.homework71.data.repository

import com.example.homework71.data.base.BaseRepository
import com.example.homework71.data.local.NoteDao
import com.example.homework71.data.mappers.toNote
import com.example.homework71.data.mappers.toNoteEntity
import com.example.homework71.domain.model.Note
import com.example.homework71.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
    ) : NoteRepository,BaseRepository() {
    override fun createNote(note: Note)=doRequest {
        noteDao.createNote(note.toNoteEntity())
    }

    override fun editNote(note: Note)=doRequest {
        noteDao.editNote(note.toNoteEntity())
    }

    override fun deleteNote(note: Note) = doRequest{
       noteDao.deleteNote(note.toNoteEntity())
    }

    override fun getNotes()=doRequest {
     noteDao.getNotes().map { it.toNote() }
    }
}