package com.practicas.practicasapp.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.practicas.practicasapp.R

class CalculadoraActivity: AppCompatActivity() {
    private lateinit var textResultado: TextView
    private var operacion: String = ""
    private var operador1: String = ""
    private var operador2: String = ""
    private var resultado: Double = 0.0
    private var isOperador1Set: Boolean = false
    private var isOperador2Set: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        textResultado = findViewById(R.id.textResultado)

        val buttons = listOf(
            findViewById<Button>(R.id.btn0),
            findViewById<Button>(R.id.btn1),
            findViewById<Button>(R.id.btn2),
            findViewById<Button>(R.id.btn3),
            findViewById<Button>(R.id.btn4),
            findViewById<Button>(R.id.btn5),
            findViewById<Button>(R.id.btn6),
            findViewById<Button>(R.id.btn7),
            findViewById<Button>(R.id.btn8),
            findViewById<Button>(R.id.btn9)
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                val value = (it as Button).text.toString()
                if (!isOperador1Set) {
                    operador1 += value
                    textResultado.text = operador1
                } else if (!isOperador2Set) {
                    operador2 += value
                    textResultado.text = "${operador1} ${operacion} ${operador2}"
                }
            }
        }

        findViewById<Button>(R.id.btnSuma).setOnClickListener {
            if (operador1.isNotEmpty()) {
                operacion = "+"
                isOperador1Set = true
                textResultado.text = "$operador1 + "
            }
        }
        findViewById<Button>(R.id.btnResta).setOnClickListener {
            if (operador1.isNotEmpty()) {
                operacion = "-"
                isOperador1Set = true
                textResultado.text = "$operador1 - "
            }
        }
        findViewById<Button>(R.id.btnMultiplicar).setOnClickListener {
            if (operador1.isNotEmpty()) {
                operacion = "*"
                isOperador1Set = true
                textResultado.text = "$operador1 * "
            }
        }
        findViewById<Button>(R.id.btnDividir).setOnClickListener {
            if (operador1.isNotEmpty()) {
                operacion = "/"
                isOperador1Set = true
                textResultado.text = "$operador1 / "
            }
        }
        findViewById<Button>(R.id.btnIgual).setOnClickListener {
            if (operador1.isNotEmpty() && operador2.isNotEmpty()) {
                when (operacion) {
                    "+" -> resultado = operador1.toDouble() + operador2.toDouble()
                    "-" -> resultado = operador1.toDouble() - operador2.toDouble()
                    "*" -> resultado = operador1.toDouble() * operador2.toDouble()
                    "/" -> resultado = operador1.toDouble() / operador2.toDouble()
                }
                textResultado.text = resultado.toString()
                operador1 = ""
                operador2 = ""
                isOperador1Set = false
                isOperador2Set = false
            }
        }
        findViewById<Button>(R.id.btnLimpiar).setOnClickListener {
            textResultado.text = ""
            operador1 = ""
            operador2 = ""
            isOperador1Set = false
            isOperador2Set = false
        }
    }
}
