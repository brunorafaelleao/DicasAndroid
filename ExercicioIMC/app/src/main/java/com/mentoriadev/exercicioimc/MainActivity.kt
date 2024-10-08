package com.mentoriadev.exercicioimc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.mentoriadev.exercicioimc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding by lazy { 
        ActivityMainBinding.inflate(layoutInflater)
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //variaveis
        val botaoCalcular = binding.btnCalcular



        botaoCalcular.setOnClickListener{
            val peso = binding.edtPeso.text.toString()
            val altura = binding.edtAltura.text.toString()

            if(peso.isNotEmpty() && altura.isNotEmpty()){
                DataManager.imc = Imc(peso.toDouble(), altura.toDouble())
                val intent = Intent(this, Resultado::class.java)
                startActivity(intent)
            }else{
                Snackbar.make(it, "Preencha ambos os campos", Snackbar.LENGTH_LONG).show()
            }

        }
        
    }
}