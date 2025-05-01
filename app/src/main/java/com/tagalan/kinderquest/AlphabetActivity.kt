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
import androidx.activity.enableEdgeToEdge
import androidx.activity.enableEdgeToEdge

import androidx.activity.enableEdgeToEdge
import androidx.activity.enableEdgeToEdge
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

        // Setup all letter buttons
        setupLetterButton(R.id.btnLetterA, R.raw.a_sound, "A is for Apple")
        setupLetterButton(R.id.btnLetterB, R.raw.b_sound, "B is for Ball")
        setupLetterButton(R.id.btnLetterC, R.raw.c_sound, "C is for Cat")
        setupLetterButton(R.id.btnLetterD, R.raw.d_sound, "D is for Dog")
        setupLetterButton(R.id.btnLetterE, R.raw.e_sound, "E is for Egg")
        setupLetterButton(R.id.btnLetterF, R.raw.f_sound, "F is for Fish")
        setupLetterButton(R.id.btnLetterG, R.raw.g_sound, "G is for Goat")
        setupLetterButton(R.id.btnLetterH, R.raw.h_sound, "H is for Hat")
        setupLetterButton(R.id.btnLetterI, R.raw.i_sound, "I is for Igloo")
        setupLetterButton(R.id.btnLetterJ, R.raw.j_sound, "J is for Jam")
        setupLetterButton(R.id.btnLetterK, R.raw.k_sound, "K is for King")
        setupLetterButton(R.id.btnLetterL, R.raw.l_sound, "L is for Lion")
        setupLetterButton(R.id.btnLetterM, R.raw.m_sound, "M is for Moon")
        setupLetterButton(R.id.btnLetterN, R.raw.n_sound, "N is for Nut")
        setupLetterButton(R.id.btnLetterO, R.raw.o_sound, "O is for Orange")
        setupLetterButton(R.id.btnLetterP, R.raw.p_sound, "P is for Pig")
        setupLetterButton(R.id.btnLetterQ, R.raw.q_sound, "Q is for Queen")
        setupLetterButton(R.id.btnLetterR, R.raw.r_sound, "R is for Rocket")
        setupLetterButton(R.id.btnLetterS, R.raw.s_sound, "S is for Sun")
        setupLetterButton(R.id.btnLetterT, R.raw.t_sound, "T is for Tree")
        setupLetterButton(R.id.btnLetterU, R.raw.u_sound, "U is for Umbrella")
        setupLetterButton(R.id.btnLetterV, R.raw.v_sound, "V is for Van")
        setupLetterButton(R.id.btnLetterW, R.raw.w_sound, "W is for Watch")
        setupLetterButton(R.id.btnLetterX, R.raw.x_sound, "X is for fox")
        setupLetterButton(R.id.btnLetterY, R.raw.y_sound, "Y is for Yoyo")
        setupLetterButton(R.id.btnLetterZ, R.raw.z_sound, "Z is for Zip")
    }

    private fun setupLetterButton(buttonId: Int, soundResId: Int, message: String) {
        val button = findViewById<ImageButton>(buttonId)

        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.animate()
                        .scaleX(0.95f)
                        .scaleY(0.95f)
                        .translationZ(12f * resources.displayMetrics.density)
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