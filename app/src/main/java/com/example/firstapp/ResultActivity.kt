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

        val imcClassificacao: TextView = findViewById(R.id.textClassificacao)
        val telaResult: TextView = findViewById(R.id.textResult)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        telaResult.text = result.toString()

        val classificacao = if (result <= 18.5) {
            "Abaixo do peso"
        } else if (result in 18.6..24.9) {
            "Peso ideal"
        } else if (result in 25.0..29.9) {
            "Acima do peso"
        } else if (result in 30.0..34.9) {
            "Obesidade Grau 1"
        } else if (result in 35.0..39.9) {
            "Obesidade Grau 2"
        } else {
            "Obesidade Grau 3"
        }

        imcClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}