package com.example.homework71.datamain.local

import androidx.room.*
import com.example.homework71.datamain.model.NoteEntity

@Dao
interface NoteDao {

    @Insert
    suspend fun createNote(noteEntity: NoteEntity)

    @Update
    suspend fun editNote(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    suspend fun getNotes():List<NoteEntity>

}