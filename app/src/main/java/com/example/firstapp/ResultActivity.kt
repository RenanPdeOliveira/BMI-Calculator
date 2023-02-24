package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val bmiClassification: TextView = findViewById(R.id.textClassification)
        val screenResult: TextView = findViewById(R.id.textResult)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        screenResult.text = result.toString()

        val classification = if (result <= 18.5) {
            "Underweight"
        } else if (result in 18.6..24.9) {
            "Normal"
        } else if (result in 25.0..29.9) {
            "Overweight"
        } else if (result in 30.0..34.9) {
            "Obesity class 1"
        } else if (result in 35.0..39.9) {
            "Obesity class 2"
        } else {
            "Obesity class 3"
        }

        bmiClassification.text = getString(R.string.message_classification, classification)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}