package com.example.webbrowermorning

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val openWebButton = findViewById<Button>(R.id.button_open_web)
        openWebButton.setOnClickListener {
            openWebPage()
        }
    }
    private fun openWebPage() {
      val webpage = Uri.parse("https://www.google.com")
        val webIntent = Intent(Intent.ACTION_VIEW, webpage)
        if(webIntent.resolveActivity(packageManager) != null) {
            startActivity(webIntent)
            } else {
                Toast.makeText(this, "No web page found", Toast.LENGTH_LONG).show()
        }

    }
}