package com.gafful.mamo.keyboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.text.color
import com.gafful.mamo.keyboard.databinding.ActivityKeyboardBinding

class KeyboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKeyboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityKeyboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViews()
    }

    private fun initViews() {
        binding.button1.setOnClickListener {
            updateValueDisplay((it as Button).text)
        }
        binding.button2.setOnClickListener {
            updateValueDisplay((it as Button).text)
        }
        binding.buttonDecimal.setOnClickListener {
            binding.displayDecimalValue.text = (it as Button).text
            binding.displayDecimalValue.setTextColor(UiUtils.Colours.BLACK)
        }

    }

    /*
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
                val fractionalValue = binding.displayFractionalValue.text

                // Fractional value is empty
                if (fractionalValue.isNullOrEmpty()) {
                    val phoneCodeColor = ContextCompat.getColor(this, android.R.color.darker_gray)
                    val text = SpannableStringBuilder()
                        .append(value)
                        .color(phoneCodeColor) { append(getString(R.string._0)) }

                    // Populate decimal with last value grayed out
                    binding.displayFractionalValue.text = text
                    binding.displayFractionalValue.setTextColor(UiUtils.Colours.BLACK)
                } else if (fractionalValue.substring(1)
                        .contentEquals(getString(R.string._0))
                ) {// Fractional value has a single digit
                    // Populate decimal display
                    val updated = "${fractionalValue.first()}" + value
                    binding.displayFractionalValue.text = updated
                    binding.displayFractionalValue.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.black
                        )
                    )
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

}