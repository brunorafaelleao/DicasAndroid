package com.geindrural.listaconvidados

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geindrural.listaconvidados.databinding.ActivityTelaCadastroBinding

class TelaCadastro : AppCompatActivity() {

    private val binding by lazy{
        ActivityTelaCadastroBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}