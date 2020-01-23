package com.example.firstexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        proceed_button.setOnClickListener {
            startDetailsActivity()
        }
    }

    private fun startDetailsActivity() {
        val mainIntent = Intent(this, DetailsActivity::class.java)
        startActivity(mainIntent)
    }
}
