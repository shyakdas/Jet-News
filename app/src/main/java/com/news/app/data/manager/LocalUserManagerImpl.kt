package com.news.app.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.news.app.domain.manager.LocalUserManager
import com.news.app.util.Constants
import com.news.app.util.Constants.USER_SETTINGS
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest

class LocalUserManagerImpl(private val context: Context) : LocalUserManager {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { setting ->
            setting[PreferenceKeys.APP_ENTRY] = true
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.mapLatest { preferences ->
            preferences[PreferenceKeys.APP_ENTRY] ?: false
        }
    }
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

private object PreferenceKeys {

    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)

}