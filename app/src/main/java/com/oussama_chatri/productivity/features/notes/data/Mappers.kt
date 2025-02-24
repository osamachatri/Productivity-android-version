package com.oussama_chatri.productivity.features.notes.data

import com.oussama_chatri.productivity.features.notes.data.local.NoteEntity
import com.oussama_chatri.productivity.features.notes.data.remote.NoteRequest
import com.oussama_chatri.productivity.features.notes.data.remote.NoteResponse
import com.oussama_chatri.productivity.features.notes.data.remote.UpdatedNoteRequest
import com.oussama_chatri.productivity.features.notes.domain.Note

fun Note.toNoteEntity(id: Int = 0): NoteEntity {
    return NoteEntity(
        id = id,
        title = title,
        content = content,
        type = type,
        creationTime = creationTime,
        editedTime = editedTime,
        isPinned = isPinned
    )
}

fun Note.toNoteResponse(): NoteResponse {
    return NoteResponse(
        title = title,
        content = content,
        type = type,
        creationTime = creationTime,
        editedTime = editedTime,
        isPinned = isPinned
    )
}

fun Note.toNoteRequest(): NoteRequest {
    return NoteRequest(
        title = title,
        content = content,
        type = type,
        creationTime = creationTime,
        isPinned = isPinned
    )
}

fun Note.toUpdatedNoteRequest(): UpdatedNoteRequest {
    return UpdatedNoteRequest(
        title = title,
        content = content,
        type = type,
        editedTime = editedTime,
        isPinned = isPinned
    )
}

fun NoteEntity.toNote(): Note {
    return Note(
        title = title,
        content = content,
        type = type,
        creationTime = creationTime,
        editedTime = editedTime,
        isPinned = isPinned
    )
}

fun NoteResponse.toNote() : Note{
    return Note(
        title = title,
        content = content,
        type = type,
        creationTime = creationTime,
        editedTime = editedTime,
        isPinned = isPinned
    )
}
