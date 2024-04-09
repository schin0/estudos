package br.com.fiap.dados

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.StringTokenizer

class SaudacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge();
        setContentView(R.layout.activity_saudacao);

        val txvSaudacao = findViewById<TextView>(R.id.txv_saudacao);
        // obterDadosComSharedPreferences(txvSaudacao);
        obterDadosComArquivo(txvSaudacao);


    }

    private fun obterDadosComSharedPreferences(txvSaudacao: TextView) {
        val saudacaoSharedPreferences = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE);

        val nome = saudacaoSharedPreferences.getString("nome", "");
        val tratamento = saudacaoSharedPreferences.getString("tratamento", "");

        if (tratamento.equals("Sem tratamento"))
            txvSaudacao.text = nome;
        else
            txvSaudacao.text = tratamento + " " + nome;
    }

    private fun obterDadosComArquivo(txvSaudacao: TextView) {
        val dados = recuperarDadosDoArquivo("saudacao");

        val tokenizer = StringTokenizer(dados, ":");
        val nome = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "sem nome";
        val tratamento = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "sem tratamento";

        if (tratamento.equals("Sem tratamento"))
            txvSaudacao.text = nome;
        else
            txvSaudacao.text = tratamento + " " + nome;
    }

    private fun recuperarDadosDoArquivo(nomeArquivo: String) : String {
        try {
            val fi = openFileInput(nomeArquivo);

            val dados = fi.readBytes();

            fi.close();

            return dados.toString(Charset.defaultCharset());
        } catch (e: FileNotFoundException) {
            Log.i("recuperarDadosDoArquivo", "Arquivo não foi encontrado!");
            return "";
        } catch (e: IOException) {
            Log.i("recuperarDadosDoArquivo", "Arquivo foi encontrado, mas os dados não puderam ser gravados!");
            return "";
        }
    }
}