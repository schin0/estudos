package br.com.fiap.ciclodevida

import android.content.Intent
import android.net.Uri
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

        val btnAbrirSite = findViewById<Button>(R.id.btn_abrir_site);
        val btnAbrirProximaActivity = findViewById<Button>(R.id.btn_abrir_proxima_activity);

        // Chamada implícita
        btnAbrirSite.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fiap.com.br"));
            startActivity(i);
        }

        // Chamada explícita
        btnAbrirProximaActivity.setOnClickListener {
            val i = Intent(this, ProximaActivity::class.java);
            startActivity(i);
        }

        // Compartilhar conteúdo:
        val btnCompartilhar = findViewById<Button>(R.id.btn_compartilhar);

        btnCompartilhar.setOnClickListener{
            val i = Intent();
            i.action = Intent.ACTION_SEND;
            i.putExtra(Intent.EXTRA_TEXT, "Texto ou URL a ser compartilhada");
            i.type = "text/plain";
            startActivity(i);
        }

        val btnAbrirConstraintLayout = findViewById<Button>(R.id.btn_abrir_constraint_layout);

        btnAbrirConstraintLayout.setOnClickListener {
            val i = Intent(this, Layouts::class.java);
            startActivity(i);
        }

        val btnAbrirTableLayout = findViewById<Button>(R.id.btn_abrir_table_layout);

        btnAbrirTableLayout.setOnClickListener {
            val i = Intent(this, TableLayout::class.java);
            startActivity(i);
        }

        val btnAbrirProjetoPomar = findViewById<Button>(R.id.btn_abrir_projeto_pomar);

        btnAbrirProjetoPomar.setOnClickListener {
            val i = Intent(this, ProjetoPomar::class.java);
            startActivity(i);
        }
    }

    fun preencherTexto(view: View) {
        Toast.makeText(this, "Clicado", Toast.LENGTH_SHORT).show();
    }
}
