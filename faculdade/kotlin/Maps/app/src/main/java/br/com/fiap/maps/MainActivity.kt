package br.com.fiap.maps

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.fiap.maps.ui.theme.MapsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }

    fun acessarMapa(view: View) {
        val intent = Intent(this, MapaActivity::class.java);
        startActivity(intent);
    }

    fun acessarLocalizacaoDoUsuario(view: View) {
        val intent = Intent(this, LocalizacaoUsuarioActivity::class.java);
        startActivity(intent);
    }
}

