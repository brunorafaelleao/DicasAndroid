package com.geindrural.listaconvidados

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.geindrural.listaconvidados.databinding.ActivityTelaConsultaBinding
import kotlinx.coroutines.launch


class TelaConsulta : AppCompatActivity() {

    private val binding by lazy{
        ActivityTelaConsultaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //val db = AppDatabase.getDatabase(this)
       // val convidadoDao = db.convidadoDao()

        lifecycleScope.launch {
           // val convidadosList = convidadoDao.obterTodosConvidados()
           // val adapter = ConvidadoAdapter(convidadosList)
            binding.recyclerViewConvidados.layoutManager = LinearLayoutManager(this@TelaConsulta)
          //  binding.recyclerViewConvidados.adapter = adapter
            Log.d("TelaConsulta", "Convidados: ${Lista.dados}")
        }




    }
}