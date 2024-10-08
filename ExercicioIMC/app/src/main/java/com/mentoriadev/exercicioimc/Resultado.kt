package com.mentoriadev.exercicioimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mentoriadev.exercicioimc.databinding.ActivityResultadoBinding

class Resultado : AppCompatActivity() {
    private val binding by lazy{
        ActivityResultadoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.txtPesoInformado.text = "Peso informado: ${DataManager.imc?.peso} kg"
        binding.txtAlturaInformada.text = "Altura informada: ${DataManager.imc?.altura} m"

        val imc = DataManager.imc?.imc

//        if (imc!! < 18.5){
//            "Abaixo do peso"
//        }else if ()


    }
}