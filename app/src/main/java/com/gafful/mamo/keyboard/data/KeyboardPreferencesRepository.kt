package com.gafful.mamo.keyboard.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

/**
 * A repository for storing and retrieving the keyboard's currency.
 * Jetpack's [DataStore] is used for the persistence.
 */
class KeyboardPreferencesRepository(private val dataStore: DataStore<Preferences>) :
    KeyboardRepository {

    override suspend fun saveCurrency(currency: String) {
        dataStore.edit { preferences ->
            preferences[CURRENCY] = currency
        }
    }

    override suspend fun getCurrency(defaultCurrency: String): Flow<String> {
        return dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }.map { preferences ->
                preferences[CURRENCY] ?: defaultCurrency
            }
    }

    companion object {
        val CURRENCY = stringPreferencesKey("currency")
    }
}