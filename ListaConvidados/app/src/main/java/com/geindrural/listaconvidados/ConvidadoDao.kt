//package com.geindrural.listaconvidados
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//
//@Dao
//interface ConvidadoDao {
//    @Insert
//    suspend fun inserirConvidados(convidados: List<Convidado>)
//
//    @Query("SELECT * FROM convidados")
//    suspend fun obterTodosConvidados(): List<Convidado>
//}