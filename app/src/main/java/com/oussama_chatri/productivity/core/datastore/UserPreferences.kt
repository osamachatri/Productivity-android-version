package com.oussama_chatri.productivity.core.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey

object UserPreferences {
    val DARK_MODE_KEY = booleanPreferencesKey("dark_mode")
    val FONT_SIZE_KEY = intPreferencesKey("font_size")
    val IS_LOGGED_IN_KEY = booleanPreferencesKey("is_logged_in")
}