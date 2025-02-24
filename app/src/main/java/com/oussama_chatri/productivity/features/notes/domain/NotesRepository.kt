package com.oussama_chatri.productivity.features.notes.domain

interface NoteRepository {
    suspend fun createNote(note: Note, saveLocally: Boolean)
    suspend fun getNotes(fetchFromRemote: Boolean): List<Note>
    suspend fun updateNote(noteId: Int,note: Note, saveLocally: Boolean)
    suspend fun deleteNote(noteId: Int, deleteLocally: Boolean)
}
