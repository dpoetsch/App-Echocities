package com.example.echocities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button: androidx.appcompat.widget.AppCompatButton = findViewById(R.id.button7)
        button.setOnClickListener {
            openNextActivity()
        }

    }

    private fun openNextActivity(){
        val intent = Intent(this, MainActivityAPI::class.java)
        startActivity(intent)
    }

}