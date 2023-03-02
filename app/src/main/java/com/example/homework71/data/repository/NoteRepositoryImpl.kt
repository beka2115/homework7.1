package com.example.homework71.data.repository

import com.example.homework71.data.local.NoteDao
import com.example.homework71.data.toNote
import com.example.homework71.data.toNoteEntity
import com.example.homework71.domain.model.Note
import com.example.homework71.domain.repository.NoteRepository
import com.example.homework71.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao
    ) : NoteRepository {
    override fun createNote(note: Note):Flow<Resource<Unit>> = flow {
       emit(Resource.Loading())
        try {
            val data = noteDao.createNote(note.toNoteEntity())
            emit(Resource.Success(data))
        }catch (ioException: IOException){
            emit(Resource.Error(ioException.localizedMessage ?: "Unknewn error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun editNote(note: Note):Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.editNote(note.toNoteEntity())
            emit(Resource.Success(data))
        }catch (ioException: IOException){
            emit(Resource.Error(ioException.localizedMessage ?: "Unknewn error"))
        }

    }.flowOn(Dispatchers.IO)

    override fun deleteNote(note: Note):Flow<Resource<Unit>> = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.deleteNote(note.toNoteEntity())
            emit(Resource.Success(data))
        }catch (ioException: IOException){
            emit(Resource.Error(ioException.localizedMessage ?: "Unknewn error"))
        }
    }.flowOn(Dispatchers.IO)

    override fun getNotes(): Flow<Resource<List<Note>>> = flow {
        emit(Resource.Loading())
        try {
            val data = noteDao.getNotes().map { it.toNote() }
            emit(Resource.Success(data))
        }catch (ioException: IOException){
            emit(Resource.Error(ioException.localizedMessage ?: "Unknewn error"))
        }
    }.flowOn(Dispatchers.IO)
}