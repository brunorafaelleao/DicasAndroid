package com.geindrural.listaconvidados

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.geindrural.listaconvidados.databinding.ActivityTelaInicialBinding
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class TelaInicial : AppCompatActivity() {

    // Configurar o carregamento da tela
    private val binding by lazy {
        ActivityTelaInicialBinding.inflate(layoutInflater)
    }

    // Carregamento da instância do Firestore
    private val firestore by lazy {
        FirebaseFirestore.getInstance()
    }

    // Instância do DatabaseHelper para gerenciar o SQLite
    private val dbHelper by lazy {
        ConvidadoDatabaseHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Verificar se há dados no SQLite ao abrir a tela
        verificarEEnviarDadosParaFirebase()

        // Botões e ações
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

    // Verifica se há dados no SQLite e envia para o Firebase
    private fun verificarEEnviarDadosParaFirebase() {
        val convidadosDoBanco = dbHelper.listarConvidados()

        if (convidadosDoBanco.isNotEmpty()) {
            // Se há convidados no SQLite, sincronize com o Firebase
            convidadosDoBanco.forEach { convidado ->
                val convidadoMap = hashMapOf(
                    "Convidado" to convidado.nome,
                    "Data de Nascimento" to convidado.dataNascimento
                )

                // Adiciona o convidado ao Firestore
                firestore.collection("Lista de Convidados")
                    .document(convidado.id.toString())
                    .set(convidadoMap)
                    .addOnSuccessListener {
                        Log.d("Firebase", "Convidado ${convidado.nome} enviado para o Firestore")
                    }
                    .addOnFailureListener { e ->
                        Log.e("Firebase", "Erro ao enviar convidado: ${convidado.nome}", e)
                    }
            }
        } else {
            Log.d("SQLite", "Nenhum dado encontrado no SQLite para sincronizar.")
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
                Log.e("Firebase", "Erro ao sincronizar dados com o Firebase", exception)
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
        Lista.dados.clear()
        Lista.dados.addAll(convidados)
        dbHelper.inserirListaConvidados(convidados)

        // Recuperar os convidados inseridos no banco para o log
        val convidadosInseridos = dbHelper.listarConvidados()

        Log.d("banco", "Convidados: ${convidadosInseridos.joinToString { it.toString() }}")
    }
}
