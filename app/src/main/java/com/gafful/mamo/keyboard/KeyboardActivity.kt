package com.gafful.mamo.keyboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.text.color
import androidx.core.text.isDigitsOnly
import com.gafful.mamo.keyboard.databinding.ActivityKeyboardBinding

class KeyboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKeyboardBinding
    private var fractionalList = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityKeyboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViews()
    }

    /**
     * Initialize views
     */
    private fun initViews() {
        binding.button1.setOnClickListener {
            updateValueDisplay((it as Button).text)
        }
        binding.button2.setOnClickListener {
            updateValueDisplay((it as Button).text)
        }
        binding.button3.setOnClickListener {
            updateValueDisplay((it as Button).text)
        }
        binding.button4.setOnClickListener {
            updateValueDisplay((it as Button).text)
        }
        binding.button5.setOnClickListener {
            updateValueDisplay((it as Button).text)
        }
        binding.button6.setOnClickListener {
            updateValueDisplay((it as Button).text)
        }
        binding.button7.setOnClickListener {
            updateValueDisplay((it as Button).text)
        }
        binding.button8.setOnClickListener {
            updateValueDisplay((it as Button).text)
        }
        binding.button9.setOnClickListener {
            updateValueDisplay((it as Button).text)
        }
        binding.button0.setOnClickListener {
            updateValueDisplay((it as Button).text)
        }
        binding.buttonDecimal.setOnClickListener {
            binding.displayDecimalValue.text = (it as Button).text
            binding.displayDecimalValue.setTextColor(UiUtils.Colours.BLACK)
        }
        binding.buttonDelete.setOnClickListener {
            deleteValue()
        }
    }

    /**
     * Update both whole number and fractional displays
     */
    private fun updateValueDisplay(value: CharSequence) {
        val currentWholeValue = binding.displayWholeValue.text

        // Whole number display is empty
        if (currentWholeValue.isNullOrEmpty()) {
            // Populate currency display
            binding.displayCurrency.text = getString(R.string.aed)
            binding.displayCurrency.setTextColor(UiUtils.Colours.BLACK)

            // Populate whole number display
            binding.displayWholeValue.text = value
            binding.displayWholeValue.setTextColor(UiUtils.Colours.BLACK)
        } else {
            // Decimal point entered
            if (binding.displayDecimalValue.text.contentEquals(getString(R.string._decimal))) {

                // Fractional value is empty
                if (fractionalList.isNullOrEmpty()) {
                    val text = SpannableStringBuilder()
                        .color(UiUtils.Colours.BLACK) { append(value) }
                        .color(UiUtils.Colours.GRAY) { append(getString(R.string._0)) }

                    // Populate decimal with last value grayed out
                    binding.displayFractionalValue.text = text
                    fractionalList.add("$value".toInt())
                } else if (fractionalList.size == 1) {// Fractional value has a single digit
                    // Populate decimal display
                    val updated = "${fractionalList.first()}" + value
                    binding.displayFractionalValue.text = updated
                    binding.displayFractionalValue.setTextColor(UiUtils.Colours.BLACK)
                    fractionalList.add("$value".toInt())
                }
            } else {
                // Decimal point not entered
                val updatedValue = "$currentWholeValue" + value

                // Populate whole number display
                binding.displayWholeValue.text = updatedValue
                binding.displayWholeValue.setTextColor(UiUtils.Colours.BLACK)
            }
        }
    }

    /**
     * Clear display
     */
    private fun deleteValue() {
        // If display has fractional values
        if (!fractionalList.isNullOrEmpty()) {
            fractionalList.removeLast()
            if (fractionalList.size == 1) {
                val text = SpannableStringBuilder()
                    .append(fractionalList.first().toString())
                    .color(UiUtils.Colours.GRAY) { append(getString(R.string._0)) }

                // Populate fractional value with last value grayed out
                binding.displayFractionalValue.text = text
            } else {
                binding.displayFractionalValue.text = ""
            }
        } else if (binding.displayDecimalValue.text.contentEquals(getString(R.string._decimal))) { // If display has decimal point
            binding.displayDecimalValue.text = ""
            binding.displayDecimalValue.hint = getString(R.string._decimal)
        } else if (!binding.displayWholeValue.text.isNullOrEmpty()) { // If display has whole values
            val wholeValue = binding.displayWholeValue.text
            val updatedWholeValue = wholeValue.removeSuffix(wholeValue.last().toString())
            binding.displayWholeValue.text = updatedWholeValue

            if (updatedWholeValue.isBlank())
                binding.displayCurrency.text = ""
        }
    }
}