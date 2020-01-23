package com.example.firstexercise

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar!!.setBackgroundDrawable(
            ColorDrawable(ContextCompat.getColor(this, R.color.black))
        )

        showSoftKeyboard(username_textview)

        next_details_button.setOnClickListener {
            val validUsername = isValidUsername()
            val validAge = isValidAge()

            if (validUsername && validAge) {
                startDisplayActivity() }
            }
    }

        private fun isValidUsername(): Boolean {
        var isValid = true
        if (username_edittext.text.isBlank()) {
            isValid = false
            username_edittext?.error = "Name Required"
        }
        return isValid
    }

    private fun isValidAge(): Boolean {
        var isValid = true
        if (age_edittext.text.isBlank()) {
            isValid = false
            age_edittext?.error = "Age Required"
        }
        return isValid
    }

    fun showSoftKeyboard(view: View){
        if(view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    private fun startDisplayActivity() {
       val detailIntent = Intent(this, DisplayActivity::class.java)
        val inputUsername: String = username_edittext.text.toString()
        val inputAge: String = age_edittext.text.toString()
        detailIntent.putExtra("username", inputUsername)
        detailIntent.putExtra("age", inputAge)

        startActivity(detailIntent)

    }

}
