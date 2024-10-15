package com.geindrural.listaconvidados

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "convidados")
data class Convidado(
    @PrimaryKey val id: Int,
    val nome: String,
    val dataNascimento: String,
    )
