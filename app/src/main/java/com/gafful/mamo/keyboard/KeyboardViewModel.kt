package com.gafful.mamo.keyboard

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gafful.mamo.keyboard.commons.UiUtils.formatDigits
import com.gafful.mamo.keyboard.data.models.DisplayModel
import dagger.Module

/**
 * Business layer for the Keyboard activity implemented using the MVVM pattern.
 */
class KeyboardViewModel : ViewModel() {
    private var fractionalList = mutableListOf<Int>()

    /**
     * Handle input events for all numeric buttons.
     * It formats whole numbers in thousands, and accepts up to only 2 decimal places after it receives
     * a decimal input.
     */
    fun processInput(
        context: Context,
        value: CharSequence,
        displayModel: DisplayModel,
        blackColour: Int,
    ): DisplayModel {
        // No digit keyed
        if (displayModel.wholeValue.isNullOrEmpty()) {

            displayModel.currencyColour = blackColour
            displayModel.wholeValue = value.formatDigits()
            displayModel.wholeValueColour = blackColour
            return displayModel
        } else {
            // Decimal point keyed in
            if (displayModel.decimalValue.contentEquals(context.getString(R.string._decimal))) {
                // No fractional value keyed in
                if (fractionalList.isNullOrEmpty()) {

                    // Update fractional portion with last value grayed out
                    fractionalList.add("$value".toInt())
                    displayModel.fractionalValue1 = value
                    displayModel.fractionalValue1Colour = blackColour

                } else if (fractionalList.size == 1) {// Fractional value has a single digit
                    // Update fractional value
                    fractionalList.add("$value".toInt())
                    displayModel.fractionalValue2 = value
                    displayModel.fractionalValue2Colour = blackColour
                }
                return displayModel
            } else {
                // Decimal point not keyed in
                val updatedValue = "${displayModel.wholeValue}" + value

                if (displayModel.wholeValue!!.length == 19)
                    return displayModel

                // Update whole number display
                displayModel.wholeValue = updatedValue.replace(",", "").formatDigits()
                displayModel.wholeValueColour = blackColour
                return displayModel
            }
        }
    }

    /**
     * Handle input events for the delete button.
     * It clears the values from the rightmost part.
     * When the last digit is cleared, the currency is grayed out, resetting the display.
     */
    fun processDeleteInput(
        context: Context,
        displayModel: DisplayModel,
        grayColour: Int
    ): DisplayModel {
        // Display has fractional values
        if (!fractionalList.isNullOrEmpty()) {
            fractionalList.removeLast()
            return if (fractionalList.size == 1) {

                // Update fractional value with last value grayed out
                displayModel.fractionalValue2 = ""
                displayModel.fractionalValue2Colour = grayColour
                displayModel
            } else {
                displayModel.fractionalValue1 = ""
                displayModel.fractionalValue1Colour = grayColour
                displayModel
            }
        } else if (displayModel.decimalValue.contentEquals(context.getString(R.string._decimal))) { // If display has decimal point
            displayModel.decimalValue = ""
            displayModel.decimalValueColour = grayColour
            return displayModel
        } else if (!displayModel.wholeValue.isNullOrEmpty()) { // If display has whole values
            var updatedWholeValue =
                displayModel.wholeValue!!.removeSuffix(displayModel.wholeValue!!.last().toString())

            // Format whole value
            if (updatedWholeValue.length > 3)
                updatedWholeValue =
                    updatedWholeValue.toString().replace(",", "").formatDigits()
            displayModel.wholeValue = updatedWholeValue

            // Clear display
            if (updatedWholeValue.isBlank())
                displayModel.currency = ""
        } else {
            displayModel.currency = ""
        }
        return displayModel
    }

    /**
     * Handle input events for the decimal buttons.
     * When this event is received first, it appends a zero automatically so that subsequent
     * numeric inputs are recorded as decimals.
     */
    fun processDecimalInput(
        value: CharSequence,
        displayModel: DisplayModel,
        blackColour: Int
    ): DisplayModel {
        displayModel.decimalValue = value
        displayModel.decimalValueColour = blackColour

        if (displayModel.wholeValue.isNullOrEmpty()) {
            displayModel.wholeValue = "0"
            displayModel.wholeValueColour = blackColour

            displayModel.currency = displayModel.currency
            displayModel.currencyColour = blackColour
        }

        return displayModel
    }

    /**
     * A factory for providing [KeyboardViewModel] instances.
     */
    class KeyboardViewModelFactory : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(KeyboardViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return KeyboardViewModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}