package com.gafful.mamo.keyboard

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class KeyboardActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(KeyboardActivity::class.java)

    @Test
    fun appLaunchesKeyboardActivitySuccessfully() {
        ActivityScenario.launch(KeyboardActivity::class.java)
    }

    @Test
    fun keyboardActivityHasDisplayViewWithDefaultTextAndTextColour() {
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withHint(R.string.aed)))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withHint(R.string._0)))
        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(withHint(R.string._00)))
    }

    @Test
    fun keyboardActivityHasAllExpectedButtonsWithLabels() {
        Espresso.onView(withId(R.id.button_1))
            .check(ViewAssertions.matches(withText(R.string._1)))
        Espresso.onView(withId(R.id.button_2))
            .check(ViewAssertions.matches(withText(R.string._2)))
        Espresso.onView(withId(R.id.button_3))
            .check(ViewAssertions.matches(withText(R.string._3)))
        Espresso.onView(withId(R.id.button_4))
            .check(ViewAssertions.matches(withText(R.string._4)))
        Espresso.onView(withId(R.id.button_5))
            .check(ViewAssertions.matches(withText(R.string._5)))
        Espresso.onView(withId(R.id.button_6))
            .check(ViewAssertions.matches(withText(R.string._6)))
        Espresso.onView(withId(R.id.button_7))
            .check(ViewAssertions.matches(withText(R.string._7)))
        Espresso.onView(withId(R.id.button_8))
            .check(ViewAssertions.matches(withText(R.string._8)))
        Espresso.onView(withId(R.id.button_9))
            .check(ViewAssertions.matches(withText(R.string._9)))
        Espresso.onView(withId(R.id.button_0))
            .check(ViewAssertions.matches(withText(R.string._0)))
        Espresso.onView(withId(R.id.button_decimal))
            .check(ViewAssertions.matches(withText(R.string._decimal)))
        Espresso.onView(withId(R.id.button_delete))
            .check(ViewAssertions.matches(hasContentDescription()))
    }

    @Test
    fun keyboardButtonOneDisplaysExpectedValues() {
        Espresso.onView(withId(R.id.button_1)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withText("AED")))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("1")))
    }

    @Test
    fun keyboardButtonTwoDisplaysExpectedValues() {
        Espresso.onView(withId(R.id.button_2)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withText("AED")))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("2")))
    }

    @Test
    fun keyboardButtonThreeDisplaysExpectedValues() {
        Espresso.onView(withId(R.id.button_3)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withText("AED")))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("3")))
    }

    @Test
    fun keyboardButtonFourDisplaysExpectedValues() {
        Espresso.onView(withId(R.id.button_4)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withText("AED")))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("4")))
    }

    @Test
    fun keyboardButtonFiveDisplaysExpectedValues() {
        Espresso.onView(withId(R.id.button_5)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withText("AED")))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("5")))
    }

    @Test
    fun keyboardButtonSixDisplaysExpectedValues() {
        Espresso.onView(withId(R.id.button_6)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withText("AED")))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("6")))
    }

    @Test
    fun keyboardButtonSevenDisplaysExpectedValues() {
        Espresso.onView(withId(R.id.button_7)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withText("AED")))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("7")))
    }

    @Test
    fun keyboardButtonEightDisplaysExpectedValues() {
        Espresso.onView(withId(R.id.button_8)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withText("AED")))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("8")))
    }

    @Test
    fun keyboardButtonNineDisplaysExpectedValues() {
        Espresso.onView(withId(R.id.button_9)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withText("AED")))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("9")))
    }

    @Test
    fun keyboardButtonZeroDisplaysExpectedValues() {
        Espresso.onView(withId(R.id.button_0)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withText("AED")))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("0")))
    }

    @Test
    fun decimalButtonDisplaysExpectedValues() {
        Espresso.onView(withId(R.id.button_decimal)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.display_decimal_value))
            .check(ViewAssertions.matches(withText(".")))
        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(withHint("00")))
        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(withText("")))
    }

    @Test
    fun deleteButtonHasNoEffectIfNoValueEntered() {
        Espresso.onView(withId(R.id.button_delete)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withHint(R.string.aed)))
        Espresso.onView(withId(R.id.display_currency))

            .check(ViewAssertions.matches(withText("")))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withHint(R.string._0)))
        Espresso.onView(withId(R.id.display_whole_value))

            .check(ViewAssertions.matches(withText("")))
        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(withHint(R.string._00)))
        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(withText("")))
    }

    @Test
    fun enteringMoreThanTwoDecimalPlacesDoesNotUpdateFractionalValue() {
        Espresso.onView(withId(R.id.button_1)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_decimal)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_2)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_3)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_4)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_5)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("1")))

        Espresso.onView(withId(R.id.display_decimal_value))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_decimal_value))
            .check(ViewAssertions.matches(withText(".")))

        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(withText("23")))
    }

    @Test
    fun deletingFractionalValuesClearsDisplayWithDefaultZeros() {
        Espresso.onView(withId(R.id.button_1)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_decimal)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_2)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_3)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_delete)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withHint(R.string.aed)))
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withText(R.string.aed)))

        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("1")))

        Espresso.onView(withId(R.id.display_decimal_value))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_decimal_value))
            .check(ViewAssertions.matches(withText(".")))

        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(withText("20")))
    }

    @Test
    fun deletingWholeValuesClearsDisplayFromTheRight() {
        Espresso.onView(withId(R.id.button_1)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_2)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_delete)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withHint(R.string.aed)))
        Espresso.onView(withId(R.id.display_currency))
            .check(ViewAssertions.matches(withText(R.string.aed)))

        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("1")))

        Espresso.onView(withId(R.id.display_decimal_value))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_decimal_value))
            .check(ViewAssertions.matches(withHint(".")))
        Espresso.onView(withId(R.id.display_decimal_value))
            .check(ViewAssertions.matches(withText("")))

        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(isDisplayed()))
        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(withHint("00")))
        Espresso.onView(withId(R.id.display_fractional_value))
            .check(ViewAssertions.matches(withText("")))
    }

    @Test
    fun digitsAreSeparatedByCommaInThousands() {
        Espresso.onView(withId(R.id.button_1)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_2)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_3)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_4)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_5)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_6)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.button_7)).perform(ViewActions.click())

        Espresso.onView(withId(R.id.display_whole_value))
            .check(ViewAssertions.matches(withText("1,234,567")))
    }
}