package com.gafful.mamo.keyboard.data.models

/**
 * A model encapsulating the all the information on the keyboard's display.
 */
data class DisplayModel(
    var currency: CharSequence?,
    var currencyColour: Int,
    var wholeValue: CharSequence?,
    var wholeValueColour: Int,
    var decimalValue: CharSequence?,
    var decimalValueColour: Int,
    var fractionalValue1: CharSequence?,
    var fractionalValue1Colour: Int,
    var fractionalValue2: CharSequence?,
    var fractionalValue2Colour: Int,
)