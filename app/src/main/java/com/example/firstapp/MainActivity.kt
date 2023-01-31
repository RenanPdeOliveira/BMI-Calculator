package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val textPeso: EditText = findViewById(R.id.edtextPeso)
        val textAltura: EditText = findViewById(R.id.edtextAltura)

        btnCalculate.setOnClickListener {
            val pesoEmp = textPeso.text.toString()
            val alturaEmp = textAltura.text.toString()

            if (pesoEmp.isNotEmpty() && alturaEmp.isNotEmpty()) {

                val peso: Float = pesoEmp.toFloat()
                val altura: Float = alturaEmp.toFloat()
                val result = peso / (altura * altura)

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}