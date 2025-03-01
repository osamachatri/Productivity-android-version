package com.oussama_chatri.productivity.core.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_settings")

class SettingsManager(private val context: Context) {

    // Get dark mode preference
    val darkModeFlow: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[UserPreferences.DARK_MODE_KEY] ?: false
    }

    // Get font size preference
    val fontSizeFlow: Flow<Int> = context.dataStore.data.map { preferences ->
        preferences[UserPreferences.FONT_SIZE_KEY] ?: 14
    }

    // Save dark mode preference
    suspend fun setDarkMode(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[UserPreferences.DARK_MODE_KEY] = enabled
        }
    }

    // Save font size preference
    suspend fun setFontSize(size: Int) {
        context.dataStore.edit { preferences ->
            preferences[UserPreferences.FONT_SIZE_KEY] = size
        }
    }
}