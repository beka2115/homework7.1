package com.example.homework71.data

import com.example.homework71.data.model.NoteEntity
import com.example.homework71.domain.model.Note

fun NoteEntity.toNote() = Note(
    id,
    title,
    description,
    createdAt
)

fun Note.toNoteEntity() = NoteEntity(
    id,
    title,
    description,
    createdAt
)
