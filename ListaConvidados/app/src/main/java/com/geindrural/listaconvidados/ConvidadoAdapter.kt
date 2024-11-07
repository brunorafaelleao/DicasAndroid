package com.geindrural.listaconvidados

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ConvidadoAdapter(private val convidados: List<Convidado>) : RecyclerView.Adapter<ConvidadoAdapter.ConvidadoViewHolder>() {

    class ConvidadoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeTextView: TextView = itemView.findViewById(R.id.textViewNome)
        val dataNascimentoTextView: TextView = itemView.findViewById(R.id.textViewDataNascimento)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConvidadoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_convidado, parent, false)
        return ConvidadoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConvidadoViewHolder, position: Int) {
        val convidado = convidados[position]
        holder.nomeTextView.text = convidado.nome
        holder.dataNascimentoTextView.text = convidado.dataNascimento
    }

    override fun getItemCount() = convidados.size
}