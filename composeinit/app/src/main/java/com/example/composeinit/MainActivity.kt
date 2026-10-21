package com.example.composeinit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.ui.lessons.L01FirstComposable
import com.example.composeinit.ui.lessons.L02FirstComposable
import com.example.composeinit.ui.lessons.L03Parameters
import com.example.composeinit.ui.lessons.L04Modifier
import com.example.composeinit.ui.lessons.L05ColumnRow
import com.example.composeinit.ui.lessons.L06Box
import com.example.composeinit.ui.lessons.L07WeigthSpace
import com.example.composeinit.ui.lessons.L08LazyColumn
import com.example.composeinit.ui.lessons.L09Button
import com.example.composeinit.ui.theme.ComposeinitTheme

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
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    BoasVindas(
//                        name = "Erlon",
//                        modifier = Modifier.padding(paddingValues = innerPadding)
//                    )
                //L02FirstComposable()
                L03Parameters()
                L04Modifier()
                L05ColumnRow()
                L06Box()
                L07WeigthSpace()
                L08LazyColumn()
                L09Button()
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