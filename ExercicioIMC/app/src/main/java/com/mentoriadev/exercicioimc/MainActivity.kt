package com.mentoriadev.exercicioimc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mentoriadev.exercicioimc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy { 
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //variaveis
        var botaoCalcular = binding.btnCalcular
        var peso = binding.edtPeso.text.toString()
        var altura = binding.edtAltura.text.toString()

        botaoCalcular.setOnClickListener{
            val intent = Intent(this, Resultado::class.java)
            startActivity(intent)
        }
        
    }
}