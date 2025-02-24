package com.oussama_chatri.productivity.auth.data

import com.oussama_chatri.productivity.core.utils.EncryptionHelper

class AuthTokenProvider(private val encryptionHelper: EncryptionHelper) {

    suspend fun saveToken(token: String) {
        encryptionHelper.saveToken(token)
    }

    suspend fun getToken(): String? {
        return encryptionHelper.getToken()
    }

    suspend fun clearToken() {
        encryptionHelper.clearToken()
    }
}
