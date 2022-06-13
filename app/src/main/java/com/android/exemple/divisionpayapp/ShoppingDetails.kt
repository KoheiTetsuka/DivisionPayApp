package com.android.exemple.divisionpayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShoppingDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_details)

        val member = intent.getStringExtra("MEMBER")

        val textView = findViewById<TextView>(R.id.detailsSum)
        textView.text = member
    }
}