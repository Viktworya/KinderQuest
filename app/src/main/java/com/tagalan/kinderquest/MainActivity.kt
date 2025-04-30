package com.tagalan.kinderquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tagalan.kinderquest.ui.theme.KinderQuestTheme

import android.widget.Button
import android.content.Intent
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       //  TEST COMMIT LANG TO
        val btnAlphabet = findViewById<ImageButton>(R.id.btnAlphabet)
        val btnNumber = findViewById<ImageButton>(R.id.btnNumbers)
        val btnColorShape = findViewById<ImageButton>(R.id.btnColorsShapes)

        btnAlphabet.setOnClickListener {
            startActivity(Intent(this, AlphabetActivity::class.java))
        }

        btnNumber.setOnClickListener {
            startActivity(Intent(this, NumberActivity::class.java))
        }

        btnColorShape.setOnClickListener {
            startActivity(Intent(this, ColorShapeActivity::class.java))
        }
    }
}