package com.tagalan.kinderquest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.media.MediaPlayer
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge

import android.widget.Toast
import androidx.activity.enableEdgeToEdge

import android.view.View
import androidx.activity.enableEdgeToEdge

import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge

class AlphabetActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_alphabet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupLetterButton(R.id.btnLetterA, R.raw.a_sound, "A is for Apple")
        setupLetterButton(R.id.btnLetterB, R.raw.b_sound, "B is for Ball")
        setupLetterButton(R.id.btnLetterC, R.raw.c_sound, "C is for Cat")
        setupLetterButton(R.id.btnLetterD, R.raw.d_sound, "D is for Dog")
    }

    private fun setupLetterButton(buttonId: Int, soundResId: Int, message: String) {
        val button = findViewById<ImageButton>(buttonId)

        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.animate()
                        .scaleX(0.95f)
                        .scaleY(0.95f)
                        .translationZ(12f * resources.displayMetrics.density) // Fixed here
                        .setDuration(100)
                        .start()
                }
                MotionEvent.ACTION_UP -> {
                    v.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .translationZ(0f)
                        .setDuration(100)
                        .start()
                    playSound(soundResId, message)
                }
                MotionEvent.ACTION_CANCEL -> {
                    v.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .translationZ(0f)
                        .setDuration(100)
                        .start()
                }
            }
            true
        }
    }

    private fun playSound(soundResId: Int, message: String) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(this, soundResId).apply {
            start()
            Toast.makeText(this@AlphabetActivity, message, Toast.LENGTH_SHORT).show()
            setOnCompletionListener {
                release()
                mediaPlayer = null
            }
        }
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}