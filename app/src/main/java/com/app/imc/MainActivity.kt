package com.app.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var peso: Int = 0
    var altura: Double = 0.0
    var imc: Double =0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun CalcularIMC(v: View){
        if(etPeso.text.isEmpty()){
            Toast.makeText(this, "Falta Peso en Kg", Toast.LENGTH_LONG).show()
            etPeso.requestFocus()
        }
        else if(etAltura.text.isEmpty()){
            Toast.makeText(this, "Falta Altura en Mts", Toast.LENGTH_LONG).show()
            etAltura.requestFocus()
        }
        else{
            peso = etPeso.text.toString().toInt()
            altura = etAltura.text.toString().toDouble()
            imc = peso / (altura*altura)
            //Toast.makeText(this, "Tu IMC es de: ${imc}", Toast.LENGTH_LONG).show()
            when{
                imc < 25 -> Toast.makeText(this, "Tu IMC es de: ${imc} (Adecuado)", Toast.LENGTH_LONG).show()
                imc > 25 && imc < 30 -> Toast.makeText(this, "Tu IMC es de: ${imc} (Sobrepeso)", Toast.LENGTH_LONG).show()
                imc > 25 && imc <= 40 -> Toast.makeText(this, "Tu IMC es de: ${imc} (Obesidad)", Toast.LENGTH_LONG).show()
            }
        }
    }
}
