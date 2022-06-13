package com.android.exemple.divisionpayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AddMember : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_member)

        val event = intent.getStringExtra("EVENTMAIN")

        val textView = findViewById<TextView>(R.id.textView2)
        textView.text = event

    }
}