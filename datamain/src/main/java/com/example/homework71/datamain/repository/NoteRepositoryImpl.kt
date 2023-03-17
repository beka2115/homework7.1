package com.example.homework71.datamain.repository

import com.example.homework71.datamain.base.BaseRepository
import com.example.homework71.datamain.local.NoteDao
import com.example.homework71.datamain.mappers.toNote
import com.example.homework71.datamain.mappers.toNoteEntity
import com.example.homework71.domain.model.Note
import com.example.homework71.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
    ) : NoteRepository, BaseRepository() {
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