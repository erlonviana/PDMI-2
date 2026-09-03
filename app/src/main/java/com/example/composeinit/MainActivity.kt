package com.example.composeinit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.ui.theme.ComposeinitTheme
import com.example.composeinit.ui.theme.components.BoasVindas

//classe principal logo abaixo
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //local onde é definido o conteúdo exibido
        setContent {
            ComposeinitTheme {
                //innerPadding: impede o estouro a construir o composable (não avança na barra superior e de menu)
                //scaffold: material Design, serve como template, dando slots pré-definidos
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BoasVindas(
                        name = "Erlon." +
                                "",
                        modifier = Modifier.padding(paddingValues = innerPadding)
                    )
                }
            }
        }
    }
}

//composable logo abaixo (indicado com @ e precisa de uma função para saber quais componentes visuais renderizar)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeinitTheme {
        Greeting("Android")
    }
}