package com.oussama_chatri.productivity.features.notes.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NoteApiClient {
    private const val BASE_URL = "https://your-api-url.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: NoteApiService = retrofit.create(NoteApiService::class.java)
}