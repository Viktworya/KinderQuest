package com.tagalan.kinderquest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


import android.content.Intent
import androidx.activity.enableEdgeToEdge
import android.widget.Button

class OpeningPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_opening_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get the button reference
        val btnDashboard = findViewById<Button>(R.id.btnDashboard)

        // Set click listener
        btnDashboard.setOnClickListener {
            // Create an intent to start MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Optional: Add animation or finish current activity
            // finish()
        }
    }
}