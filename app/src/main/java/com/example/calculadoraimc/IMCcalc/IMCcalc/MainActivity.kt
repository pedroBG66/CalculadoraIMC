package com.example.calculadoraimc.IMCcalc.IMCcalc

import android.media.tv.TvView
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.example.calculadoraimc.R
import java.util.Locale
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var etHeight: EditText
    lateinit var etWeight: EditText
    lateinit var btnCalc: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        etHeight = findViewById(R.id.etHeight)
        etWeight = findViewById(R.id.etWeight)
        btnCalc = findViewById(R.id.btnCalc)
        tvResult = findViewById(R.id.tvResult)

        btnCalc.setOnClickListener {
            val height = etHeight.text.toString().toFloatOrNull() ?: return@setOnClickListener
            val weight = etWeight.text.toString().toFloatOrNull() ?: return@setOnClickListener

            imcCalculator(height, weight)
        }

    }



    fun imcCalculator (height: Float, weight: Float){
        val heightInCm = height/100
        val imc = weight / heightInCm.pow(2)
        val result = String.format(Locale.getDefault(), "IMC: %.2f", imc)
        tvResult.text = result

    }

}