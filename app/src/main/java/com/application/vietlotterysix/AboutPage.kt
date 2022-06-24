package com.application.vietlotterysix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutPage : AppCompatActivity() {

    private var btnAb : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_page)

        btnAb = findViewById(R.id.btnAb)
        btnAb?.setOnClickListener{
            onBackPressed()
        }
    }
}