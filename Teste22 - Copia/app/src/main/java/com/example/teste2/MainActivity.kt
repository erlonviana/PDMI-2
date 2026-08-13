package com.example.teste2

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
import com.example.teste2.model.AlunoNormal
import com.example.teste2.model.Curso
import com.example.teste2.ui.theme.Teste2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Teste2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var aluno = AlunoNormal(nome = "Erlon", idade = 37)

                    aluno.apresentar()

                    val cursoTeste = Curso(id = 1, titulo = "PDMI", descricao = "")

                    exemploLambda()
                    Greeting(
                        name = "Erlon",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

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
    Teste2Theme {
        Greeting("Android")
    }
}

fun exemploLambda(){
    val numeros= listOf(1,2,3,4)
    val quadrados = numeros.map{ it * it}
    println("Valor dos numeros quadrados: "+quadrados)

    val todosNumeros = listOf(1,2,3,4,5,6,7,8,9,10)
    val pares = todosNumeros.filter {it %2 ==0}
    println("ValoresPares:" +pares)

    numeros
        .filter{it>2} //3,4
        .map{it * 10} //30,40
        .forEach { println("Valor:$it") }
//fun exemploLambda(){
    //println("exemploLambda")

}

fun calcularIrrf(salarioBruto: Double?): Double{
    if salarioBruto <= 2259,20
}