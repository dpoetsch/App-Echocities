package com.example.echocities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_main)

        val button: androidx.appcompat.widget.AppCompatButton = findViewById(R.id.button)
        button.setOnClickListener {
            openNextActivity()
        }
    }

    private fun openNextActivity(){
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

}