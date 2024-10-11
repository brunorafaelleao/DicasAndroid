package com.mentoriadev.exercicioimc

import android.os.Bundle
import android.window.OnBackInvokedDispatcher
import androidx.appcompat.app.AppCompatActivity
import com.mentoriadev.exercicioimc.databinding.ActivityResultadoBinding

class Resultado : AppCompatActivity() {
    private val binding by lazy{
        ActivityResultadoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.txtPesoInformado.text = "Seu peso informado: ${DataManager.imc?.peso} kg"
        binding.txtAlturaInformada.text = "Sua altura informada: ${DataManager.imc?.altura} m"
        binding.txtIMC.text = "Seu IMC: ${String.format("%.2f",DataManager.imc?.imc)}"

        val imc = DataManager.imc?.imc

        if (imc!! < 18.5){
           binding.txtResultado.text = "Abaixo do peso"
        }else if (imc!! >=18.5 && imc <= 24.9) {
            binding.txtResultado.text = "Peso normal"
        }else if (imc!! >24.9 && imc!!<=29.9){
            binding.txtResultado.text = "Sobrepeso"
        }else
            binding.txtResultado.text = "Obesidade"

    }

}