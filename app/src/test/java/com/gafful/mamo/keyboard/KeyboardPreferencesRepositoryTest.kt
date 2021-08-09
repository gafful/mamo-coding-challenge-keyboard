package com.gafful.mamo.keyboard

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class KeyboardPreferencesRepositoryTest {
    private lateinit var fakeKeyboardRepository: FakeKeyboardRepository

    @Before
    fun setUp() {
        fakeKeyboardRepository = FakeKeyboardRepository()
    }

    @Test
    fun saveCurrency_storesTheGivenCurrency(): Unit = runBlocking {
        fakeKeyboardRepository.saveCurrency("aed")
        val currency = fakeKeyboardRepository.store
        Assert.assertEquals(currency, "aed")
    }

    @Test
    fun getCurrency_returnsTheSavedCurrency(): Unit = runBlocking {
        fakeKeyboardRepository.saveCurrency("usd")
        fakeKeyboardRepository.getCurrency("usd").collect {
            Assert.assertEquals(it, "usd")
        }
    }

    @Test
    fun getCurrency_returnsTheDefaultCurrency_whenACurrencyHasNotBeenSavedPreviously(): Unit =
        runBlocking {
            fakeKeyboardRepository.getCurrency("aed").collect {
                Assert.assertEquals(it, "aed")
            }
        }
}