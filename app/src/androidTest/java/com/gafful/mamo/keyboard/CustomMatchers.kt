package com.gafful.mamo.keyboard

import android.view.View
import androidx.core.content.ContextCompat

import android.widget.TextView

import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Matcher
import org.junit.runner.Description


object CustomMatchers {
    fun withTextColor(expectedId: Int): Matcher<View?> {
        return object : BoundedMatcher<View?, TextView>(TextView::class.java) {
            override fun describeTo(description: org.hamcrest.Description?) {
                description?.appendText("with text color: ")
                description?.appendValue(expectedId)
            }

            override fun matchesSafely(item: TextView): Boolean {
                val colorId = ContextCompat.getColor(item.context!!, expectedId)
                return item.currentTextColor == colorId
            }
        }
    }
}