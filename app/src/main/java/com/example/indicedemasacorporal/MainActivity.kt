package com.example.indicedemasacorporal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

const val EXTRA_EST = "com.example.indicedemasacorporal.Est"
const val EXTRA_PESO = "com.example.indicedemasacorporal.Peso"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            openActivity2()
        }

    }


    private fun openActivity2(){
        val editText1 = findViewById<EditText>(R.id.estatura)
        val est = Integer.parseInt(editText1.text.toString())

        val editText2 = findViewById<EditText>(R.id.estatura)
        val peso = Integer.parseInt(editText2.text.toString())


        val intent = Intent(this, Activity2::class.java).apply {
            putExtra(EXTRA_EST, est)
            putExtra(EXTRA_PESO, peso)
        }
        startActivity(intent)
    }
}
