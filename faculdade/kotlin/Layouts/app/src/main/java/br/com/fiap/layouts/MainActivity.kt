package br.com.fiap.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.fiap.layouts.ui.theme.LayoutsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.size(width = 200.dp, height = 200.dp),
                    color = Color.Green,
                    shape = RoundedCornerShape(32.dp),
                    shadowElevation = 4.dp,
                    border = BorderStroke(4.dp, Color.Blue)
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Teste",
                            modifier = Modifier.align(Alignment.BottomCenter)
                        )
                        Button(
                            onClick = {},
                            modifier = Modifier.offset(20.dp, -(30).dp)
                        ) {
                            Text(text = "Clique aqui")
                        }
                    }
                }
            }
        }
    }
}
