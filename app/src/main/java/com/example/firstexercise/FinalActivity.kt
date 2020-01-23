package com.example.firstexercise

import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat


class FinalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar!!.setBackgroundDrawable(
            ColorDrawable(ContextCompat.getColor(this, R.color.black))
        )

        val displayname = intent.getStringExtra("username")
        val displayage = intent.getStringExtra("age")

        val name = findViewById<TextView>(R.id.name_display_textview)
        name.text = displayname
        val age = findViewById<TextView>(R.id.age_display_textView)
        age.text = displayage

    }
}
