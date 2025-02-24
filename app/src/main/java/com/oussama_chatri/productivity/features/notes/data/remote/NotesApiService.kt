package com.oussama_chatri.productivity.features.notes.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface NoteApiService {
    @POST("/notes")
    suspend fun createNote(
        @Header("Authorization") token: String,
        @Body request: NoteRequest
    ): Response<String>

    @GET("/notes")
    suspend fun getNotes(
        @Header("Authorization") token: String
    ): Response<List<NoteResponse>>

    @PUT("/notes/{id}")
    suspend fun updateNote(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body request: UpdatedNoteRequest
    ): Response<String>

    @DELETE("/notes/{id}")
    suspend fun deleteNote(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): Response<String>
}

