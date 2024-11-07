package com.geindrural.listaconvidados

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ConvidadoDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "convidados.db"
        private const val DATABASE_VERSION = 1

        // Nome da tabela e colunas
        const val TABLE_NAME = "convidados"
        const val COLUMN_ID = "id"
        const val COLUMN_NOME = "nome"
        const val COLUMN_DATA_NASCIMENTO = "data_nascimento"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // Criação do banco de dados na primeira vez que ele for acessado
        val createTableSQL = ("CREATE TABLE IF NOT EXISTS $TABLE_NAME ("
                + "$COLUMN_ID INTEGER PRIMARY KEY, "
                + "$COLUMN_NOME TEXT, "
                + "$COLUMN_DATA_NASCIMENTO TEXT)")
        db?.execSQL(createTableSQL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Se houver uma atualização de versão, a tabela existente será removida
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // Função para inserir uma lista de convidados
    fun inserirListaConvidados(convidados: List<Convidado>) {
        val db = this.writableDatabase
        db.beginTransaction()
        try {
            convidados.forEach { convidado ->
                val values = ContentValues().apply {
                    put(COLUMN_ID, convidado.id)
                    put(COLUMN_NOME, convidado.nome)
                    put(COLUMN_DATA_NASCIMENTO, convidado.dataNascimento)
                }
                // Use CONFLICT_REPLACE para substituir se já existir um convidado com o mesmo ID
                db.insertWithOnConflict(TABLE_NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE)
            }
            db.setTransactionSuccessful()
        } finally {
            db.endTransaction()
        }
    }

    fun listarConvidados(): List<Convidado> {
        val db = this.readableDatabase
        val convidados = mutableListOf<Convidado>()
        val cursor = db.query(
            TABLE_NAME, null, null, null, null, null, null
        )

        with(cursor) {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(COLUMN_ID))
                val nome = getString(getColumnIndexOrThrow(COLUMN_NOME))
                val dataNascimento = getString(getColumnIndexOrThrow(COLUMN_DATA_NASCIMENTO))
                convidados.add(Convidado(id, nome, dataNascimento))
            }
        }
        cursor.close()
        return convidados
    }

}
