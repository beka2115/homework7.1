package com.example.homework71.di

import android.content.Context
import androidx.room.Room

import com.example.homework71.datamain.local.NoteDao
import com.example.homework71.datamain.local.NoteDatabase
import com.example.homework71.datamain.repository.NoteRepositoryImpl
import com.example.homework71.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {


    @Singleton
    @Provides
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ): com.example.homework71.datamain.local.NoteDatabase = Room.databaseBuilder(
        context,
        com.example.homework71.datamain.local.NoteDatabase::class.java,
        "note_db"
        ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideNoteDao(noteDatabase: com.example.homework71.datamain.local.NoteDatabase) = noteDatabase.noteDao()


    @Singleton
    @Provides
    fun provideNoteRepository(
        noteDao: com.example.homework71.datamain.local.NoteDao
    ): NoteRepository = com.example.homework71.datamain.repository.NoteRepositoryImpl(noteDao)

}