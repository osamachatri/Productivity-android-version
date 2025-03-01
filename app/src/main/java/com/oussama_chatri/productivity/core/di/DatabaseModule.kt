package com.oussama_chatri.productivity.core.di

import android.content.Context
import com.oussama_chatri.productivity.core.database.LocalDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): LocalDataBase {
        return LocalDataBase.getInstance(context)
    }
}
