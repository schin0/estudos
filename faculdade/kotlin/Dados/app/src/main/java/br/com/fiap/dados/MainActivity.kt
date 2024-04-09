package br.com.fiap.dados

import android.content.Context
import android.content.Intent
import android.os.Bundle
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val btnSalvar = findViewById<Button>(R.id.btnSalvar);
        val btnExibir = findViewById<Button>(R.id.btnExibir);
        val txtNome = findViewById<EditText>(R.id.txtNome);
        val listTratamento = findViewById<Spinner>(R.id.listTratamento);

        btnSalvar.setOnClickListener {
            val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE);
            val editor = saudacaoPersistencia.edit();

            editor.putString("nome", txtNome.editableText.toString());
            editor.putString("tratamento", listTratamento.selectedItem.toString());
            editor.apply();

            Toast.makeText(this, "Saudação gravada com sucesso!", Toast.LENGTH_SHORT).show()
        }

        btnExibir.setOnClickListener {
            val i = Intent(this, SaudacaoActivity::class.java);

            startActivity(i);
        }
    }
}
