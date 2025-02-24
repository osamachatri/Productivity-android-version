package com.oussama_chatri.productivity.features.notes.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface NoteDao {
    @Upsert
    suspend fun upsert(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM notes ORDER BY creationTime DESC")
    fun getNotes(): List<NoteEntity>

    @Query("SELECT * FROM notes WHERE id = :noteId LIMIT 1")
    suspend fun getNoteById(noteId: Int): NoteEntity?

    @Query("SELECT id FROM notes WHERE creationTime = :creationTime LIMIT 1")
    suspend fun getIdOfNoteByCreationTime(creationTime: Long): Int?

    @Query("DELETE FROM notes WHERE id = :noteId")
    suspend fun deleteNoteById(noteId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes: List<NoteEntity>)

    @Query("DELETE FROM notes")
    suspend fun clearAllNotes()
}