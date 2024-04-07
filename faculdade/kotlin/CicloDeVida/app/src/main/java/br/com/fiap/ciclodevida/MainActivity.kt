package br.com.fiap.ciclodevida

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
import br.com.fiap.ciclodevida.ui.theme.CicloDeVidaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        val btnCliqueAqui = findViewById<Button>(R.id.btn_clique_aqui);
        val edtNome = findViewById<EditText>(R.id.edt_nome);
        val txvResultado = findViewById<TextView>(R.id.txv_resultado);

        // setOnClickListener sobreescreve a chamada onclick via xml:
        btnCliqueAqui.setOnClickListener {
            val nome: String = edtNome.editableText.toString();

            txvResultado.text = nome;
        }
    }

    fun preencherTexto(view: View) {
        Toast.makeText(this, "Clicado", Toast.LENGTH_SHORT).show();
    }
}
