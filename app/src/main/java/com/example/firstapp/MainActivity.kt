package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val textWeight: EditText = findViewById(R.id.edtextWeight)
        val textHeight: EditText = findViewById(R.id.edtextHeight)

        btnCalculate.setOnClickListener {
            val weightEmp = textWeight.text.toString()
            val heightEmp = textHeight.text.toString()

            if (weightEmp.isNotEmpty() && heightEmp.isNotEmpty()) {

                val weight: Float = weightEmp.toFloat()
                val height: Float = heightEmp.toFloat()
                val result = weight / (height * height)

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Fill in all fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}