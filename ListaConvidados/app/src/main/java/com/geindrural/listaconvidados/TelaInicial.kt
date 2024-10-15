package com.geindrural.listaconvidados

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.geindrural.listaconvidados.databinding.ActivityTelaInicialBinding
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch


class TelaInicial : AppCompatActivity() {


    //configurar o carregamento da tela
    private val binding by lazy {
        ActivityTelaInicialBinding.inflate(layoutInflater)
    }

    //carregamento da instancia do firestore

    private val firestore by lazy {
        FirebaseFirestore.getInstance()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //botões e ações
        val btConsulta = binding.btConsultaCadastro
        val btCadastro = binding.btCadastro
        val btSincronizar = binding.btSincronizar

        btConsulta.setOnClickListener {
            startActivity(Intent(this, TelaConsulta::class.java))
        }
        btCadastro.setOnClickListener {
            startActivity(Intent(this, TelaCadastro::class.java))
        }

        btSincronizar.setOnClickListener {
            sincronizarDados()
        }


    }

    private fun sincronizarDados() {
        firestore.collection("Lista de Convidados")
            .get()
            .addOnSuccessListener { result ->
                val numConvidados = result.size()
                AlertDialog.Builder(this)
                    .setTitle("Sincronização")
                    .setMessage("Há $numConvidados convidados. Fazer a sincronização agora?")
                    .setPositiveButton("Sim") { dialog, _ ->
                        salvarDadosOffline(result.documents)
                        dialog.dismiss()
                    }
                    .setNegativeButton("Não") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
            .addOnFailureListener { exception ->
                // Tratar erro
            }
    }

    private fun salvarDadosOffline(documents: List<DocumentSnapshot>) {
        val convidados = documents.map { doc ->
            Convidado(
                id = doc.id.toInt(),
                nome = doc.getString("Convidado") ?: "",
                dataNascimento = doc.getString("Data de Nascimento") ?: ""
            )
        }

        val db = AppDatabase.getDatabase(this)
        val convidadoDao = db.convidadoDao()

        lifecycleScope.launch {
            convidadoDao.inserirConvidados(convidados)
        }
    }
}