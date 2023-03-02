package com.example.homework71.domain.repository


import com.example.homework71.domain.model.Note
import com.example.homework71.domain.utils.Resource
import kotlinx.coroutines.flow.Flow


interface NoteRepository {

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun editNote(note: Note):Flow<Resource<Unit>>

    fun deleteNote(note: Note):Flow<Resource<Unit>>

    fun getNotes():Flow<Resource<List<Note>>>

}