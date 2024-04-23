package br.com.fiap.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting()
                    CriarPrimeiroComponente()
                }
            }
        }
    }
}

@Composable
fun CriarPrimeiroComponente() {
    var idade = remember {
        mutableStateOf(0)
    }

    var textoIdade = remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Qual a sua idade?",
            fontSize = 24.sp,
            color = Color(0xFFAD1F4E),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Pressione os botões para informar a sua idade.",
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "${idade.value}",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row (horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    idade.value--;

                    if (idade.value < 0)
                        idade.value = 0;

                    textoIdade.value = ObterTextoIdade(idade.value);
                  },
                modifier = Modifier.size(84.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(0XFFAD1F4E))
            ) {
                Text(
                    text = "-",
                    fontSize = 40.sp
                )
            }
            Button(
                onClick = {
                    idade.value++;
                    
                    if (idade.value > 130)
                        idade.value = 130;

                    textoIdade.value = ObterTextoIdade(idade.value);
                },
                modifier = Modifier.size(84.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(Color(0XFFAD1F4E))
            ) {
                Text(
                    text = "+",
                    fontSize = 40.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        ObterTextoIdade(textoIdade.value)
    }
}

fun ObterTextoIdade(idade: Int): String {
    if (idade >= 18)
        return "Você é MAIOR de idade!";

    return "Você é MENOR de idade!";
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CriarPrimeiroComponentePreview() {
    JetpackComposeTheme {
        CriarPrimeiroComponente()
    }
}

@Composable
fun ObterTextoIdade(texto: String) {
    Column(verticalArrangement = Arrangement.Center) {
        Row {
            Text(text = texto)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        ObterTextoIdade("teste")
    }
}

@Composable
fun Greeting() {
    Column (modifier = Modifier
        .padding(32.dp)
        .fillMaxWidth()) {
        OutlinedTextField(modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            placeholder = {
                Text(text = "O que você deseja buscar hoje?")
            },
            trailingIcon = {
                Icon(painter = painterResource(id = R.drawable.baseline_search_24), contentDescription = "Botão de busca")
            }
        )
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    JetpackComposeTheme {
//        Greeting()
//    }
//}