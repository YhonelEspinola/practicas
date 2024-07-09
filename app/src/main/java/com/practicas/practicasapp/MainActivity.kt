package com.practicas.practicasapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.practicas.practicasapp.calculadora.CalculadoraActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btnbutton)
        val btnCalculadora = findViewById<Button>(R.id.btncalcular)

        button.setOnClickListener{
             registrarCalculo()
        }


        btnCalculadora.setOnClickListener{
            val intent = Intent(this, CalculadoraActivity::class.java)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun registrarCalculo() {
        val valorOne = findViewById<EditText>(R.id.valorOne)
        val valorTwo = findViewById<EditText>(R.id.valorTwo)
        val valorTree = findViewById<EditText>(R.id.valorTree)
        val nombre = findViewById<EditText>(R.id.textNombre)
        val valorValueone = valorOne.text.toString().toDouble()
        val valorValueTwo = valorTwo.text.toString().toDouble()
        val valorValueTree = valorTree.text.toString().toDouble()
        val nombreValue = nombre.text.toString()
        val resultado = findViewById<TextView>(R.id.btnResultado)
        var result = ""
        var promedio = (valorValueone + valorValueTwo+valorValueTree)/3
        if (promedio >= 13){
            result="El Alumno ${nombreValue} esta aprobado con ${promedio}"
        }else{
            result="El Alumno ${nombreValue} esta desaprobado con ${promedio}"
        }

        resultado.text=result

        //Toast.makeText(this, result, Toast.LENGTH_LONG).show()invalidateMenu()
        //println(result)
    }
}