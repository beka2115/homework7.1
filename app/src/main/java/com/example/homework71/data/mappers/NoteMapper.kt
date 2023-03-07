package com.example.homework71.data.mappers

import com.example.homework71.data.model.NoteEntity
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
