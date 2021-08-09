package com.gafful.mamo.keyboard.data

import kotlinx.coroutines.flow.Flow

/**
 * Interface for storing and retrieving the keyboard's currency.
 */
interface KeyboardRepository {
    /**
     * Save the currency.
     */
    suspend fun saveCurrency(currency: String)

    /**
     * Retrieve the currency.
     */
    suspend fun getCurrency(defaultCurrency: String): Flow<String>
}