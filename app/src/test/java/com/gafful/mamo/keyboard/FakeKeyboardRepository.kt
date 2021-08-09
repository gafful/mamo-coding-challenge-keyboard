package com.gafful.mamo.keyboard

import com.gafful.mamo.keyboard.data.KeyboardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeKeyboardRepository : KeyboardRepository {
    var store: String? = null
    override suspend fun saveCurrency(currency: String) {
        store = currency
    }

    override suspend fun getCurrency(defaultCurrency: String): Flow<String> {
        if (store.isNullOrBlank())
            return flow {
                this.emit(defaultCurrency)
            }
        return flow { store }
    }
}