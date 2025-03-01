package com.oussama_chatri.productivity.core.di

import android.content.Context
import com.oussama_chatri.productivity.auth.data.AuthTokenProvider
import com.oussama_chatri.productivity.core.utils.EncryptionHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideEncryptionHelper(@ApplicationContext context: Context): EncryptionHelper {
        return EncryptionHelper(context)
    }

    @Provides
    @Singleton
    fun provideAuthTokenProvider(encryptionHelper: EncryptionHelper): AuthTokenProvider {
        return AuthTokenProvider(encryptionHelper)
    }
}
