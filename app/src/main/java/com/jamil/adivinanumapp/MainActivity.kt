package com.jamil.adivinanumapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val num1 = Random.nextInt(1,100)
        val escribirNum : EditText = findViewById(R.id.esNumero)
        val btAdivina : Button = findViewById(R.id.btAdivina)
        val texto: TextView = findViewById(R.id.textView2)

        var intentos: Int = 0
        btAdivina.setOnClickListener {
            val num: Int? = escribirNum.text.toString().toInt()
            intentos++

            if (num != null && num in 1..100) {
                if (num < num1) {
                    texto.text = "El numero es mayor"
                } else if (num == num1) {
                    texto.text = "Has acertado en $intentos intentos"
                } else {
                    texto.text = "El numero es menor"
                }
            } else {
                escribirNum.error = "Introduce un numero entre 1 y 100"
                texto.text = "Introduce un valor"
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}