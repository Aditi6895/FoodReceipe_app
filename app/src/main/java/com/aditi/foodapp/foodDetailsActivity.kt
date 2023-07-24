package com.aditi.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class foodDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        supportActionBar?.hide()

        val heading = intent.getStringExtra("heading")
        val foodContent = intent.getStringExtra("foodContent")
        val imageId = intent.getIntExtra("imageId", R.drawable.img1)

        val headingTV = findViewById<TextView>(R.id.foodHeading)
        val headingIV = findViewById<ImageView>(R.id.foodImage)
        val foodContentTV = findViewById<TextView>(R.id.foodContent)

        headingTV.text = heading
        foodContentTV.text = foodContent
        headingIV.setImageResource(imageId)
    }
}