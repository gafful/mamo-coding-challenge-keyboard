package com.gafful.mamo.keyboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class KeyboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_keyboard)
    }
}