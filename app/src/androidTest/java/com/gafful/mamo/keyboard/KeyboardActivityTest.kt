package com.gafful.mamo.keyboard

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
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
        Espresso.onView(withId(R.id.display))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.display))
            .check(ViewAssertions.matches(withHint(R.string.aed_0_00)))
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
}