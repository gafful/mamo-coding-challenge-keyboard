package com.gafful.mamo.keyboard.commons

import android.graphics.Color
import java.text.NumberFormat
import java.util.*

/**
 * Utility class for the view layer.
 */
object UiUtils {
    object Colours {
        val GRAY = Color.parseColor("#FFAAAAAA")
        val BLACK = Color.parseColor("#FF000000")
    }

    fun CharSequence.formatDigits(): String =
        NumberFormat.getNumberInstance(Locale.US).format(this.toString().toLong())
}