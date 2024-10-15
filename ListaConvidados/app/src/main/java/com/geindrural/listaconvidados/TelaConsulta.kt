package com.geindrural.listaconvidados

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geindrural.listaconvidados.databinding.ActivityTelaConsultaBinding


class TelaConsulta : AppCompatActivity() {

    private val binding by lazy{
        ActivityTelaConsultaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




    }
}