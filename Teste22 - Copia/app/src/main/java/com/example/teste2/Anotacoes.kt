//*package com.example.teste2

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
import com.example.teste2.calcularIrrf
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

//Ex1: Calculo de IRRF
fun calcularIrrf(salarioBruto: Double? = 0.0): Double {
    val aliquota = when (salarioBruto) {
            < 2259.20 -> 0
        in 2259.21 < .. < 2826.65 -> 0.075
        else -> 0.15
    }
    val salarioLiquido = aliquota * salarioBruto
    println("O valor do salario liquido será $salarioLiquido")
}

calcularIrrf(1000);
calcularIrrf(3000);

//Ex1 Corrigido:
// Ex1: Calculo de IRRF (Imposto de Renda)
fun calcularIrrf(salarioBruto: Double? = 0.0): Double {
    // 1. Trata o 'null' sem usar o '!!' (exigência cumprida!)
    // Se for null ou não informado, vira 0.0
    val salario = salarioBruto ?: 0.0

    // 2. Alíquota determinada em UM ÚNICO LUGAR no código
    // Usamos when sem argumento para permitir comparações (<, >, in)
    val aliquota = when {
        salario <= 2259.20 -> 0.0      // Isento (usei 0.0 para manter tudo Double)
        salario in 2259.21..2826.65 -> 0.075  // 7.5%
        else -> 0.15                   // 15% (acima de 2826.65)
    }

    // 3. Cálculo do valor do imposto (seguindo sua fórmula original)
    val valorImposto = aliquota * salario

    // 4. PONTO ÚNICO DE SAÍDA (exigência cumprida!)
    return valorImposto
}

// Testando a função
fun main() {
    // Caso 1: Salário informado (1000) -> isento
    println("Imposto para 1000: R$ ${calcularIrrf(1000.0)}") // 0.0

    // Caso 2: Salário informado (3000) -> 15%
    println("Imposto para 3000: R$ ${calcularIrrf(3000.0)}") // 450.0

    // Caso 3: Salário NÃO informado -> 0.0
    println("Imposto sem salário: R$ ${calcularIrrf()}")      // 0.0

    // Caso 4: Passando null explicitamente -> 0.0 (sem usar !!)
    println("Imposto com null: R$ ${calcularIrrf(null)}")     // 0.0
}

//Ex2: Fatura de energia com bandeira tarifaria
fun calcularFatura(consumoKwh: Double, precoKwh: Double): Double{
    val valorFinal = if (consumoKwh>150) consumoKwh * precoKwh * 1.10 else consumoKwh * precoKwh
    println("R$ $valorFinal")
}

//Correção ex2:
// Ex2: Fatura de energia com bandeira tarifária
fun calcularFatura(consumoKwh: Double, precoKwh: Double): Double =
    if (consumoKwh > 150) consumoKwh * precoKwh * 1.10 else consumoKwh * precoKwh

//Execução ex.2
fun main() {
    // Consumo menor ou igual a 150 -> sem acréscimo
    println(calcularFatura(100.0, 0.50)) // 50.0

    // Consumo acima de 150 -> com acréscimo de 10%
    println(calcularFatura(200.0, 0.50)) // 110.0 (200 * 0.5 = 100 + 10% = 110)
}

//Ex3: Validador de segurança de token
fun validarAcesso(token: String?) : String{
    val tamanho: Int? = token?.length
    // WHEN: o Switch-Case potente do Kotlin
    when (tamanho) {
        null           -> println("Token ausente")
        in 0.0..9.9    -> println("Token muito curto")
        else           -> println("Token aprovado")
    }
}

validarAcesso();
validarAcesso("abc123");
validarAcesso("abc123xyz789");

//Ex.3 Corrigido

// Ex3: Validador de segurança de token
fun validarAcesso(token: String?): String {
    // 1. Captura o tamanho do token (null se o token for null)
    val tamanho: Int? = token?.length

    // 2. WHEN como expressão (retorna uma String)
    val mensagem = when (tamanho) {
        null -> "Token ausente"
        in 0..9 -> "Token muito curto"
        else -> "Token aprovado"
    }

    // 3. Único ponto de saída (a função RETORNA a mensagem)
    return mensagem
}

// Testando a função
fun main() {
    // Teste 1: Token nulo
    println(validarAcesso(null))          // Token ausente

    // Teste 2: Token curto (menos de 10 caracteres)
    println(validarAcesso("abc"))          // Token muito curto

    // Teste 3: Token com 10 caracteres
    println(validarAcesso("0123456789"))   // Token aprovado

    // Teste 4: Token com mais de 10 caracteres
    println(validarAcesso("SenhaMuitoForte123")) // Token aprovado
}

//ex3 - 🧠 Bônus: Versão Super Enxuta (Single-Expression)
fun validarAcesso(token: String?): String =
    when (token?.length) {
        null -> "Token ausente"
        in 0..9 -> "Token muito curto"
        else -> "Token aprovado"
    }

//Ex4:
fun aplicarDesconto(valorOriginal: Double?, formaPagamento: String) {
    val precoFinal = valorOriginal * (1-porcentagemDesconto)
    val porcentagemDesconto = desconto
    val desconto: Double = when(formaPagamento){
        null -> 0.0
        "PIX" -> 0.05
        else -> 0.1
    }

    return precoFinal


}

//Ex4: minha versão mais simples
fun aplicarDesconto(valorOriginal: Double, desconto: Double): Double {
    return valorOriginal - (valorOriginal * desconto)
}

fun main() {
    val preco = aplicarDesconto(100.0, 0.10)  // 10% de desconto
    println(preco) // 90.0
}

//Ex 4 resposta com comentarios (envolvendo lambda)
// 1. DECLARAÇÃO: Eu vou receber uma função que, quando executada,
//    vai receber UM Double e devolver UM Double
fun aplicarDesconto(valorOriginal: Double, calcularDesconto: (Double) -> Double): Double {

    // 2. EXECUÇÃO: Agora eu vou EXECUTAR essa função,
    //    e vou PASSAR 'valorOriginal' como o Double que ela espera
    val desconto = calcularDesconto(valorOriginal)

    // 3. RESULTADO: Eu usei o resultado da função para calcular o preço final
    return valorOriginal - desconto
}

fun main() {
    // 4. CHAMADA: Aqui eu defino a função que vai ser passada
    //    O 'valor' dentro das chaves é o PARÂMETRO que a função vai receber
    val preco = aplicarDesconto(100.0) { valor ->
        //               ↑            ↑
        //               |            +--> Esse 'valor' é o 'valorOriginal' passado na execução
        //               +--> Esse é o 'valorOriginal' da função
        valor * 0.10
    }
}
*//

