package com.gafful.mamo.keyboard.di

import android.content.Context
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt [Module] for providing Datastore preferences.
 */
@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    /**
     * Provides Preference DataStore dependency.
     */
    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context) = PreferenceDataStoreFactory.create {
        context.preferencesDataStoreFile("keyboard_prefs")
    }

}