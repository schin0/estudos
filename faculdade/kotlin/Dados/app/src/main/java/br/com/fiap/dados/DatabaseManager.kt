package br.com.fiap.dados

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager(context: Context, nomeDoBanco: String): SQLiteOpenHelper(context, nomeDoBanco, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val scriptCriarTabela = "CREATE TABLE TBL_SAUDACAO(" +
                "ID_SAUDACAO INT NOT NULL," +
                "NOME VARCHAR(20)," +
                "TRATAMENTO VARCHAR(20)," +
                "PRIMARY KEY (ID_SAUDACAO)" +
                ");";

        db!!.execSQL(scriptCriarTabela);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS TBL_SAUDACAO");
        onCreate(db);
    }

    fun inserirSaudacao(id: Int, nome: String, tratamento: String){
        var db = this.writableDatabase

        var cv = ContentValues()

        cv.put("ID_SAUDACAO",id);
        cv.put("NOME",nome);
        cv.put("TRATAMENTO",tratamento);

        db.insert("TBL_SAUDACAO","ID_SAUDACAO",cv);
    }

    fun listarSaudacao(): Cursor {
        var db = this.readableDatabase;
        var saudacao = db.rawQuery("SELECT NOME, TRATAMENTO FROM TBL_SAUDACAO",null);
        return saudacao;
    }

    fun removerSaudacao(){
        var db = this.writableDatabase;
        db.delete("TBL_SAUDACAO","ID_SAUDACAO=1",null);
    }

}
