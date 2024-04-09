package br.com.fiap.dados

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.dados.ui.theme.DadosTheme
import java.io.FileNotFoundException
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val btnSalvar = findViewById<Button>(R.id.btnSalvar);
        val btnExibir = findViewById<Button>(R.id.btnExibir);
        val txtNome = findViewById<EditText>(R.id.txtNome);
        val listTratamento = findViewById<Spinner>(R.id.listTratamento);

        btnSalvar.setOnClickListener {
            // salvarSaudacaoComSharedPreferences(txtNome.editableText.toString(), listTratamento.selectedItem.toString());

            salvarSaudacaoComArquivo(txtNome.editableText.toString(), listTratamento.selectedItem.toString());

            Toast.makeText(this, "Saudação gravada com sucesso!", Toast.LENGTH_SHORT).show();
        }

        btnExibir.setOnClickListener {
            mostrarSaudacaoActivity();
        }
    }

    private fun salvarSaudacaoComSharedPreferences(nome: String, tratamento: String) {
        val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE);
        val editor = saudacaoPersistencia.edit();

        editor.putString("nome", nome);
        editor.putString("tratamento", tratamento);
        editor.apply();
    }

    private fun mostrarSaudacaoActivity() {
        val i = Intent(this, SaudacaoActivity::class.java);

        startActivity(i);
    }

    private fun salvarSaudacaoComArquivo(nome: String, tratamento: String) {
        val dados = nome + ":" + tratamento;

        gravarDadosDoArquivo("saudacao", dados);
    }

    private fun gravarDadosDoArquivo(nomeArquivo: String, dados: String) {
        try {
            val fs = openFileOutput(nomeArquivo, Context.MODE_PRIVATE);

            fs.write(dados.toByteArray());
            fs.close();

        } catch (e: FileNotFoundException) {
            Log.i("gravarDadosDoArquivo", "Arquivo não foi encontrado!");
        } catch (e: IOException) {
            Log.i("gravarDadosDoArquivo", "Arquivo foi encontrado, mas os dados não puderam ser gravados!");
        }
    }
}
