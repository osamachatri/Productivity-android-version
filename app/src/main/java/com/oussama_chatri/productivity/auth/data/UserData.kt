package com.oussama_chatri.productivity.auth.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.oussama_chatri.productivity.core.datastore.UserPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val Context.dataStore by preferencesDataStore(name = "auth_data")

class AuthData(private val context: Context) {

    private val USER_KEY = stringPreferencesKey("user_data")

    val json = Json { encodeDefaults = true }

    // Save Account as JSON string
    suspend fun saveUser(account: Account) {
        context.dataStore.edit { prefs ->
            prefs[USER_KEY] = json.encodeToString(account)
        }
    }

    // Get Account by decoding JSON string
    val getUserData: Flow<Account?> = context.dataStore.data.map { prefs ->
        prefs[USER_KEY]?.let { Json.decodeFromString<Account>(it) }
    }

    // Clear user data
    suspend fun clearUserData() {
        context.dataStore.edit { it.remove(USER_KEY) }
    }

    // Get the status of auth
    val isLoggedInFlow : Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[UserPreferences.IS_LOGGED_IN_KEY] ?: false
    }

    // Save the status of auth
    suspend fun setLoggedIn(isLoggedIn : Boolean){
        context.dataStore.edit { preferences ->
            preferences[UserPreferences.IS_LOGGED_IN_KEY] = isLoggedIn
        }
    }
}