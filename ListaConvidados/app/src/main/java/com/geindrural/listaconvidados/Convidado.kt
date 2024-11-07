package com.geindrural.listaconvidados

//import androidx.room.Entity
//import androidx.room.PrimaryKey

//@Entity(tableName = "convidados")
data class Convidado(
    val id: Int,
    val nome: String,
    val dataNascimento: String,
    )

object Lista{
    val dados = mutableListOf<Convidado>()
}
