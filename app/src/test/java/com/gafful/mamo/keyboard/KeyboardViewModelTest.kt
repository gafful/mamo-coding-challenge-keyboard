package com.gafful.mamo.keyboard

import android.content.Context
import com.gafful.mamo.keyboard.data.models.DisplayModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class KeyboardViewModelTest {

    private lateinit var viewModel: KeyboardViewModel

    @Mock
    private lateinit var mockContext: Context

    private val grayColour = 1111
    private val blackColour = 2222

    private val displayModel =
        DisplayModel(
            currency = "AED",
            currencyColour = grayColour,
            wholeValue = "",
            wholeValueColour = grayColour,
            decimalValue = "",
            decimalValueColour = grayColour,
            fractionalValue1 = "",
            fractionalValue1Colour = grayColour,
            fractionalValue2 = "",
            fractionalValue2Colour = grayColour,
        )

    @Before
    fun setup() {
        viewModel = KeyboardViewModel()
        `when`(mockContext.getString(R.string._decimal))
            .thenReturn(".")
    }

    @Test
    fun processInput_returnsCurrencyAsBlack_updatedWholeValueAsBlack_whenADigitIsIsKeyedIn() {
        val updatedDisplayModel =
            viewModel.processInput(mockContext, "1", displayModel, blackColour)

        assertEquals("AED", updatedDisplayModel.currency)
        assertEquals(blackColour, updatedDisplayModel.currencyColour)
        assertEquals("1", updatedDisplayModel.wholeValue)
        assertEquals(blackColour, updatedDisplayModel.wholeValueColour)
        assertEquals("", updatedDisplayModel.decimalValue)
        assertEquals(grayColour, updatedDisplayModel.decimalValueColour)
        assertEquals("", updatedDisplayModel.fractionalValue1)
        assertEquals(grayColour, updatedDisplayModel.fractionalValue1Colour)
        assertEquals("", updatedDisplayModel.fractionalValue2)
        assertEquals(grayColour, updatedDisplayModel.fractionalValue2Colour)
    }

    @Test
    fun processInput_returnsWholeNumbersFormattedWithCommas_whenADigitsAreMoreThanThree() {
        viewModel.processInput(mockContext, "1", displayModel, blackColour)
        viewModel.processInput(mockContext, "2", displayModel, blackColour)
        viewModel.processInput(mockContext, "3", displayModel, blackColour)
        viewModel.processInput(mockContext, "4", displayModel, blackColour)
        viewModel.processInput(mockContext, "5", displayModel, blackColour)
        viewModel.processInput(mockContext, "6", displayModel, blackColour)

        val updatedDisplayModel =
            viewModel.processInput(mockContext, "7", displayModel, blackColour)

        assertEquals("AED", updatedDisplayModel.currency)
        assertEquals(blackColour, updatedDisplayModel.currencyColour)
        assertEquals("1,234,567", updatedDisplayModel.wholeValue)
        assertEquals(blackColour, updatedDisplayModel.wholeValueColour)
        assertEquals("", updatedDisplayModel.decimalValue)
        assertEquals(grayColour, updatedDisplayModel.decimalValueColour)
        assertEquals("", updatedDisplayModel.fractionalValue1)
        assertEquals(grayColour, updatedDisplayModel.fractionalValue1Colour)
        assertEquals("", updatedDisplayModel.fractionalValue2)
        assertEquals(grayColour, updatedDisplayModel.fractionalValue2Colour)
    }

    @Test
    fun processDecimalInput_returnsDecimalPointWithBlackColour_whenCalled() {
        viewModel.processInput(mockContext, "1", displayModel, blackColour)

        val updatedDisplayModel =
            viewModel.processDecimalInput(".", displayModel, blackColour)

        assertEquals("AED", updatedDisplayModel.currency)
        assertEquals(blackColour, updatedDisplayModel.currencyColour)
        assertEquals("1", updatedDisplayModel.wholeValue)
        assertEquals(blackColour, updatedDisplayModel.wholeValueColour)
        assertEquals(".", updatedDisplayModel.decimalValue)
        assertEquals(blackColour, updatedDisplayModel.decimalValueColour)
        assertEquals("", updatedDisplayModel.fractionalValue1)
        assertEquals(grayColour, updatedDisplayModel.fractionalValue1Colour)
        assertEquals("", updatedDisplayModel.fractionalValue2)
        assertEquals(grayColour, updatedDisplayModel.fractionalValue2Colour)
    }

    @Test
    fun processDecimalInput_automaticallyAppendsZero_whenTheFirstEntryIsTheDecimalPoint() {
        val updatedDisplayModel =
            viewModel.processDecimalInput(".", displayModel, blackColour)

        assertEquals("AED", updatedDisplayModel.currency)
        assertEquals(blackColour, updatedDisplayModel.currencyColour)
        assertEquals("0", updatedDisplayModel.wholeValue)
        assertEquals(blackColour, updatedDisplayModel.wholeValueColour)
        assertEquals(".", updatedDisplayModel.decimalValue)
        assertEquals(blackColour, updatedDisplayModel.decimalValueColour)
        assertEquals("", updatedDisplayModel.fractionalValue1)
        assertEquals(grayColour, updatedDisplayModel.fractionalValue1Colour)
        assertEquals("", updatedDisplayModel.fractionalValue2)
        assertEquals(grayColour, updatedDisplayModel.fractionalValue2Colour)
    }

    @Test
    fun processInput_returnsFirstFractionalValueWithBlackColour_whenADigitIsEnteredAfterEnteringTheDecimalPoint() {
        viewModel.processInput(mockContext, "1", displayModel, blackColour)
        viewModel.processDecimalInput(".", displayModel, blackColour)

        val updatedDisplayModel =
            viewModel.processInput(mockContext, "2", displayModel, blackColour)

        assertEquals("AED", updatedDisplayModel.currency)
        assertEquals(blackColour, updatedDisplayModel.currencyColour)
        assertEquals("1", updatedDisplayModel.wholeValue)
        assertEquals(blackColour, updatedDisplayModel.wholeValueColour)
        assertEquals(".", updatedDisplayModel.decimalValue)
        assertEquals(blackColour, updatedDisplayModel.decimalValueColour)
        assertEquals("2", updatedDisplayModel.fractionalValue1)
        assertEquals(blackColour, updatedDisplayModel.fractionalValue1Colour)
        assertEquals("", updatedDisplayModel.fractionalValue2)
        assertEquals(grayColour, updatedDisplayModel.fractionalValue2Colour)
    }

    @Test
    fun processInput_returnsSecondFractionalValueWithBlackColour_whenADigitIsEnteredAfterAFirstFractionalValue() {
        viewModel.processInput(mockContext, "1", displayModel, blackColour)
        viewModel.processDecimalInput(".", displayModel, blackColour)
        viewModel.processInput(mockContext, "2", displayModel, blackColour)
        val updatedDisplayModel =
            viewModel.processInput(mockContext, "3", displayModel, blackColour)

        assertEquals("AED", updatedDisplayModel.currency)
        assertEquals(blackColour, updatedDisplayModel.currencyColour)
        assertEquals("1", updatedDisplayModel.wholeValue)
        assertEquals(blackColour, updatedDisplayModel.wholeValueColour)
        assertEquals(".", updatedDisplayModel.decimalValue)
        assertEquals(blackColour, updatedDisplayModel.decimalValueColour)
        assertEquals("2", updatedDisplayModel.fractionalValue1)
        assertEquals(blackColour, updatedDisplayModel.fractionalValue1Colour)
        assertEquals("3", updatedDisplayModel.fractionalValue2)
        assertEquals(blackColour, updatedDisplayModel.fractionalValue2Colour)
    }

    @Test
    fun processInput_returnsTheSameFractionalValue_afterReachingTwoDecimalPlaces() {
        viewModel.processInput(mockContext, "1", displayModel, blackColour)
        viewModel.processDecimalInput(".", displayModel, blackColour)
        viewModel.processInput(mockContext, "2", displayModel, blackColour)
        viewModel.processInput(mockContext, "3", displayModel, blackColour)
        val updatedDisplayModel =
            viewModel.processInput(mockContext, "4", displayModel, blackColour)

        assertEquals("AED", updatedDisplayModel.currency)
        assertEquals(blackColour, updatedDisplayModel.currencyColour)
        assertEquals("1", updatedDisplayModel.wholeValue)
        assertEquals(blackColour, updatedDisplayModel.wholeValueColour)
        assertEquals(".", updatedDisplayModel.decimalValue)
        assertEquals(blackColour, updatedDisplayModel.decimalValueColour)
        assertEquals("2", updatedDisplayModel.fractionalValue1)
        assertEquals(blackColour, updatedDisplayModel.fractionalValue1Colour)
        assertEquals("3", updatedDisplayModel.fractionalValue2)
        assertEquals(blackColour, updatedDisplayModel.fractionalValue2Colour)
    }

    @Test
    fun processDeleteInput_returnsCurrentValue_withRightMostValueRemoved() {
        viewModel.processInput(mockContext, "1", displayModel, blackColour)
        viewModel.processInput(mockContext, "2", displayModel, blackColour)
        val updatedDisplayModel =
            viewModel.processDeleteInput(mockContext, displayModel, grayColour)

        assertEquals("AED", updatedDisplayModel.currency)
        assertEquals(blackColour, updatedDisplayModel.currencyColour)
        assertEquals("1", updatedDisplayModel.wholeValue)
        assertEquals(blackColour, updatedDisplayModel.wholeValueColour)
        assertEquals("", updatedDisplayModel.decimalValue)
        assertEquals(grayColour, updatedDisplayModel.decimalValueColour)
        assertEquals("", updatedDisplayModel.fractionalValue1)
        assertEquals(grayColour, updatedDisplayModel.fractionalValue1Colour)
        assertEquals("", updatedDisplayModel.fractionalValue2)
        assertEquals(grayColour, updatedDisplayModel.fractionalValue2Colour)
    }

    @Test
    fun processDeleteInput_returnsDefaultDisplayValues_whenLastDigitIsDeleted() {
        viewModel.processInput(mockContext, "1", displayModel, blackColour)
        val updatedDisplayModel =
            viewModel.processDeleteInput(mockContext, displayModel, grayColour)

        assertEquals("", updatedDisplayModel.currency)
        assertEquals("", updatedDisplayModel.wholeValue)
        assertEquals("", updatedDisplayModel.decimalValue)
        assertEquals("", updatedDisplayModel.fractionalValue1)
        assertEquals("", updatedDisplayModel.fractionalValue2)
    }
}