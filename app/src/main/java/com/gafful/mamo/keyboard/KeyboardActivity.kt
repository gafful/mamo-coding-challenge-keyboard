package com.gafful.mamo.keyboard

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.gafful.mamo.keyboard.commons.UiUtils
import com.gafful.mamo.keyboard.data.KeyboardPreferencesRepository
import com.gafful.mamo.keyboard.data.models.DisplayModel
import com.gafful.mamo.keyboard.databinding.ActivityKeyboardBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class KeyboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKeyboardBinding
    private lateinit var viewModel: KeyboardViewModel
    private lateinit var currency: String
    @Inject
    lateinit var dataStore: DataStore<Preferences>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityKeyboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViewModel()
        initViews()
    }

    /**
     * Initialize view model
     */
    private fun initViewModel() {
        viewModel = ViewModelProvider(
            this,
            KeyboardViewModel.KeyboardViewModelFactory()
        ).get(KeyboardViewModel::class.java)

        val keyboardPreferencesRepository = KeyboardPreferencesRepository(dataStore)
        lifecycleScope.launch {
            keyboardPreferencesRepository.getCurrency("AED").collect {
                currency = it
            }
        }
    }

    /**
     * Initialize views
     */
    private fun initViews() {
        binding.button1.setOnClickListener {
            processInput((it as Button).text)
        }
        binding.button2.setOnClickListener {
            processInput((it as Button).text)
        }
        binding.button3.setOnClickListener {
            processInput((it as Button).text)
        }
        binding.button4.setOnClickListener {
            processInput((it as Button).text)
        }
        binding.button5.setOnClickListener {
            processInput((it as Button).text)
        }
        binding.button6.setOnClickListener {
            processInput((it as Button).text)
        }
        binding.button7.setOnClickListener {
            processInput((it as Button).text)
        }
        binding.button8.setOnClickListener {
            processInput((it as Button).text)
        }
        binding.button9.setOnClickListener {
            processInput((it as Button).text)
        }
        binding.button0.setOnClickListener {
            processInput((it as Button).text)
        }
        binding.buttonDecimal.setOnClickListener {
            val displayModel = viewModel.processDecimalInput(
                (it as Button).text,
                currentDisplay(),
                UiUtils.Colours.BLACK
            )
            processInput(displayModel)
        }
        binding.buttonDelete.setOnClickListener {
            val displayModel =
                viewModel.processDeleteInput(this, currentDisplay(), UiUtils.Colours.GRAY)
            processInput(displayModel)
        }
    }

    /**
     * Update both whole number and fractional displays
     */
    private fun processInput(value: CharSequence) {
        val displayModel = viewModel.processInput(
            this,
            value,
            currentDisplay(),
            UiUtils.Colours.BLACK
        )
        processInput(displayModel)
    }

    /**
     * Get the current state of the display
     */
    private fun currentDisplay() =
        DisplayModel(
            currency = currency,
            currencyColour = binding.displayCurrency.currentTextColor,
            wholeValue = binding.displayWholeValue.text,
            wholeValueColour = binding.displayWholeValue.currentTextColor,
            decimalValue = binding.displayDecimalValue.text,
            decimalValueColour = binding.displayDecimalValue.currentTextColor,
            fractionalValue1 = binding.displayFractionalValue1.text,
            fractionalValue1Colour = binding.displayFractionalValue1.currentTextColor,
            fractionalValue2 = binding.displayFractionalValue2.text,
            fractionalValue2Colour = binding.displayFractionalValue2.currentTextColor,
        )

    /**
     * Update all parts of the display
     */
    private fun processInput(displayModel: DisplayModel) {
        // Update currency
        binding.displayCurrency.text = displayModel.currency
        binding.displayCurrency.setTextColor(displayModel.currencyColour)

        // Update whole number
        binding.displayWholeValue.text = displayModel.wholeValue
        binding.displayWholeValue.setTextColor(displayModel.wholeValueColour)

        // Update decimal point
        binding.displayDecimalValue.text = displayModel.decimalValue
        binding.displayDecimalValue.setTextColor(displayModel.decimalValueColour)

        // Update fractional values
        binding.displayFractionalValue1.text = displayModel.fractionalValue1
        binding.displayFractionalValue1.setTextColor(displayModel.fractionalValue1Colour)

        binding.displayFractionalValue2.text = displayModel.fractionalValue2
        binding.displayFractionalValue2.setTextColor(displayModel.fractionalValue2Colour)
    }
}