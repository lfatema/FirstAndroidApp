package com.example.firstexercise

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_display.*


class DisplayActivity : AppCompatActivity() {

    lateinit var getname: String
    lateinit var passedUsername: String
    lateinit var passedAge: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar!!.setBackgroundDrawable(
            ColorDrawable(ContextCompat.getColor(this, R.color.black))
        )

        passedUsername = intent.getStringExtra("username")?: "No Name"
        passedAge = intent.getStringExtra("age")?: "No Age"


        Picasso.get().load("https://images.newscientist.com/wp-content/uploads/2019/04/08111018/screenshot-2019-04-08-10.24.34.jpg")
            .into(displayimageView)

        next_display_button.setOnClickListener {
            startFinalActivity()
        }
    }

    private fun startFinalActivity() {
        val displayIntent = Intent(this, FinalActivity::class.java)
        displayIntent.putExtra("username", passedUsername)
        displayIntent.putExtra("age", passedAge)
//       Toast.makeText(this, passedUsername, LENGTH_SHORT ).show()
//       Toast.makeText(this, passedAge, LENGTH_SHORT ).show()

        startActivity(displayIntent)
        }
    }
