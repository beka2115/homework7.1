package com.example.homework71.datamain.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework71.datamain.model.NoteEntity


@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase:RoomDatabase() {

    abstract fun noteDao(): NoteDao

}
