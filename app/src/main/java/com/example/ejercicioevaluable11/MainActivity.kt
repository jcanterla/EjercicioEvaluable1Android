package com.example.ejercicioevaluable11

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        val editText = findViewById<EditText>(R.id.editText)
        val boton = findViewById<Button>(R.id.button)

        boton.setOnClickListener {
            val url = editText.text.toString()
            if (url.isEmpty()){
                Toast.makeText(this, "Introduce una URL", Toast.LENGTH_SHORT).show()
            } else if (!url.startsWith("http://") && !url.startsWith("https://")){
                Toast.makeText(this, "La URL debe empezar por http:// o https://", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url) )
                startActivity(intent)
            }
        }
    }
}