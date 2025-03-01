package com.oussama_chatri.productivity.features.notes.di

import com.oussama_chatri.productivity.auth.data.AuthTokenProvider
import com.oussama_chatri.productivity.features.notes.data.NoteRepositoryImpl
import com.oussama_chatri.productivity.features.notes.data.local.NoteDao
import com.oussama_chatri.productivity.features.notes.data.remote.NoteApiService
import com.oussama_chatri.productivity.features.notes.domain.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object NotesModule {

    @Provides
    fun provideNotesApiService(retrofit: Retrofit): NoteApiService {
        return retrofit.create(NoteApiService::class.java)
    }

    @Provides
    fun provideNotesRepository(
        noteApiService: NoteApiService,
        noteDao: NoteDao,
        authTokenProvider: AuthTokenProvider
    ): NoteRepository {
        return NoteRepositoryImpl(noteDao, noteApiService, authTokenProvider)
    }
}
