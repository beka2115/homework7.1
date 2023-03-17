package com.example.homework71.datamain.mappers

import com.example.homework71.datamain.model.NoteEntity
import com.example.homework71.domain.model.Note

fun NoteEntity.toNote() = Note(
    id,
    title,
    description
)

fun Note.toNoteEntity() = NoteEntity(
    id,
    title,
    description
)
