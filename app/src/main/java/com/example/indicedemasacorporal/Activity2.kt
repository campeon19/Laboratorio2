package com.example.indicedemasacorporal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import java.text.DecimalFormat
import kotlin.math.pow

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val est = intent.getIntExtra(EXTRA_EST, 1)
        val peso = intent.getIntExtra(EXTRA_PESO, 1)
        print(peso)
        print (est)
        val estM = cm_a_m(est)
        val pesoKg = lb_a_kg(peso)
        val res = IMC(estM, pesoKg)
        val dec = DecimalFormat("##.00")
        val res1 = dec.format(res)

        val textView = findViewById<TextView>(R.id.resultado).apply {
            text = res1.toString()
        }

        if(res < 18.4){
            val imageView = findViewById<ImageView>(R.id.imagenResultado)
            imageView.setImageResource(R.drawable.bajo)
            val textView2 = findViewById<TextView>(R.id.mensaje).apply {
                text = "Su peso es bajo!"
            }
        } else if (res > 24.9){
            val imageView = findViewById<ImageView>(R.id.imagenResultado)
            imageView.setImageResource(R.drawable.sobrepeso)
            val textView2 = findViewById<TextView>(R.id.mensaje).apply {
                text = "Su peso es alto!"
            }
        } else {
            val imageView = findViewById<ImageView>(R.id.imagenResultado)
            imageView.setImageResource(R.drawable.ideal)
            val textView2 = findViewById<TextView>(R.id.mensaje).apply {
                text = "Esta en su peso ideal!"
            }
        }

    }

    fun lb_a_kg(peso: Int): Double {
        return peso * 0.453592
    }

    fun cm_a_m(est: Int): Double {
        return est * 0.01
    }

    fun IMC(est: Double, peso: Double): Double{
        return peso / (est.pow(2))
    }
}
