package com.oussama_chatri.productivity.features.notes.data

import com.oussama_chatri.productivity.auth.data.AuthTokenProvider
import com.oussama_chatri.productivity.features.notes.data.local.NoteDao
import com.oussama_chatri.productivity.features.notes.data.remote.NoteApiService
import com.oussama_chatri.productivity.features.notes.domain.Note
import com.oussama_chatri.productivity.features.notes.domain.NoteRepository

class NoteRepositoryImpl(
    private val noteDao: NoteDao,
    private val noteApiService: NoteApiService,
    private val authTokenProvider: AuthTokenProvider
) : NoteRepository {

    override suspend fun createNote(note: Note, saveLocally: Boolean) {
        if (saveLocally) {
            // Save locally (Offline Mode)
            noteDao.upsert(note.toNoteEntity())
        } else {
            try {
                val noteRequest = note.toNoteRequest()
                val response = noteApiService.createNote(authTokenProvider.getToken() ?: "", noteRequest)
                if (response.isSuccessful) {
                    noteDao.upsert(note.toNoteEntity()) // Sync local DB
                } else {
                    throw Exception("Failed to create note on server")
                }
            } catch (e: Exception) {
                throw Exception("Network error: Unable to create note remotely")
            }
        }
    }

    override suspend fun getNotes(fetchFromRemote: Boolean): List<Note> {
        return if (fetchFromRemote) {
            try {
                val response = noteApiService.getNotes(authTokenProvider.getToken())
                if (response.isSuccessful) {
                    val notes = response.body()?.map { it.toDomain() } ?: emptyList()
                    noteDao.clearAllNotes()
                    noteDao.insertNotes(notes.map { it.toNoteEntity() }) // Sync local DB
                    notes
                } else {
                    throw Exception("Failed to fetch notes from server")
                }
            } catch (e: Exception) {
                noteDao.getNotes().map { it.toDomain() }
            }
        } else {
            noteDao.getNotes().map { it.toDomain() }
        }
    }

    override suspend fun updateNote(note: Note, saveLocally: Boolean) {
        if (saveLocally) {
            noteDao.upsert(note.toNoteEntity())
        } else {
            try {
                val request = note.toUpdatedNoteRequest()
                val response = noteApiService.updateNote(authTokenProvider.getToken(), note.id, request)
                if (response.isSuccessful) {
                    noteDao.upsert(note.toNoteEntity()) // Sync local DB
                } else {
                    throw Exception("Failed to update note on server")
                }
            } catch (e: Exception) {
                throw Exception("Network error: Unable to update note remotely")
            }
        }
    }

    override suspend fun deleteNote(noteId: Int, deleteLocally: Boolean) {
        if (deleteLocally) {
            noteDao.deleteNoteById(noteId)
        } else {
            try {
                val response = noteApiService.deleteNote(authTokenProvider.getToken(), noteId)
                if (response.isSuccessful) {
                    noteDao.deleteNoteById(noteId) // Sync local DB
                } else {
                    throw Exception("Failed to delete note on server")
                }
            } catch (e: Exception) {
                throw Exception("Network error: Unable to delete note remotely")
            }
        }
    }
}
