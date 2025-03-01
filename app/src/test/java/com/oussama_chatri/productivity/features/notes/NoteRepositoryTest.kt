package com.oussama_chatri.productivity.features.notes

import com.oussama_chatri.productivity.auth.data.AuthTokenProvider
import com.oussama_chatri.productivity.features.notes.data.NoteRepositoryImpl
import com.oussama_chatri.productivity.features.notes.data.local.NoteDao
import com.oussama_chatri.productivity.features.notes.data.local.NoteEntity
import com.oussama_chatri.productivity.features.notes.data.remote.NoteApiService
import com.oussama_chatri.productivity.features.notes.data.remote.NoteRequest
import com.oussama_chatri.productivity.features.notes.data.toNote
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import io.mockk.slot
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class NoteRepositoryImplTest {

    private lateinit var repository: NoteRepositoryImpl
    private val localDataSource = mockk<NoteDao>()
    private val remoteDataSource = mockk<NoteApiService>()
    private val authTokenProvider = mockk<AuthTokenProvider>()

    @Before
    fun setUp() {
        repository = NoteRepositoryImpl(localDataSource, remoteDataSource, authTokenProvider)
    }

    @Test
    fun `createNote should save locally when saveLocally is true`() = runTest {
        val note = NoteEntity(
            id = 1,
            title = "Local Note",
            content = "Content",
            type = "String",
            creationTime = 171651646,
            editedTime = 178551415,
            isPinned = true
        )

        // Allow any NoteEntity
        coEvery { localDataSource.upsert(any()) } just Runs

        repository.createNote(note.toNote(), saveLocally = true)

        // Capture the actual NoteEntity that was passed to upsert
        val noteSlot = slot<NoteEntity>()
        coVerify { localDataSource.upsert(capture(noteSlot)) }

        // Check if the captured note matches what you expected
        assertEquals(note.title, noteSlot.captured.title)
        assertEquals(note.content, noteSlot.captured.content)
    }


    @Test
    fun `createNote should save remotely when saveLocally is false`() = runTest {
        val token = "Bearer mock_token"  // Mocked token
        val note = NoteRequest(
            title = "Local Note",
            content = "Content",
            type = "String",
            creationTime = 171651646,
            isPinned = true
        )

        val mockResponse = Response.success("Note Created Successfully")

        coEvery { remoteDataSource.createNote(token, note) } returns mockResponse

        repository.createNote(note.toNote(), saveLocally = false)

        coVerify { remoteDataSource.createNote(token, note) }
    }

//
//    @Test
//    fun `getNotes should fetch from local when fetchFromRemote is false`() = runTest {
//        val localNotes = listOf(Note(1, "Local Note", "Content"))
//
//        coEvery { localDataSource.getAllNotes() } returns localNotes
//
//        val result = repository.getNotes(fetchFromRemote = false)
//
//        assertThat(result).isEqualTo(localNotes)
//    }
//
//    @Test
//    fun `getNotes should fetch from remote when fetchFromRemote is true`() = runTest {
//        val remoteNotes = listOf(Note(2, "Remote Note", "Content"))
//
//        coEvery { remoteDataSource.getNotes() } returns remoteNotes
//        coEvery { localDataSource.insertNotes(remoteNotes) } just Runs
//
//        val result = repository.getNotes(fetchFromRemote = true)
//
//        assertThat(result).isEqualTo(remoteNotes)
//        coVerify { localDataSource.insertNotes(remoteNotes) }
//    }
//
//    @Test
//    fun `deleteNote should delete locally when deleteLocally is true`() = runTest {
//        coEvery { localDataSource.deleteNote(1) } just Runs
//
//        repository.deleteNote(1, deleteLocally = true)
//
//        coVerify { localDataSource.deleteNote(1) }
//    }
//
//    @Test
//    fun `deleteNote should delete remotely when deleteLocally is false`() = runTest {
//        coEvery { remoteDataSource.deleteNote(1) } just Runs
//
//        repository.deleteNote(1, deleteLocally = false)
//
//        coVerify { remoteDataSource.deleteNote(1) }
//    }
}
