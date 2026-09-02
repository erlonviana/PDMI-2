package com.example.teste2

// Função de suporte para formatar valores em reais
fun Double.emReais(): String {
    return "R$ %.2f".format(this)
}

// Aplica uma regra de desconto ao valor original
fun aplicarDesconto( //criando uma função
    valorOriginal: Double, //que recebe um double
    regraDesconto: (Double) -> Double //e outra função que recebe um double e retorna um double
): Double { //retorno de aplicarDesconto é um double...
    return regraDesconto(valorOriginal) //...no caso, é um double de regraDesconto em cima do valorOriginal
}

// Regras de desconto (serão usadas pela val cenarios
val pagamentoViaPix: (Double) -> Double = { valor ->
    valor * 0.95
}

val cupom: (Double) -> Double = { valor ->
    valor * 0.90
}

val semDesconto: (Double) -> Double = { valor ->
    valor
}

val blackFriday: (Double) -> Double = { valor ->
    valor * 0.80
}

// Cenários disponíveis
val cenarios = mapOf( //mapOf é um dicionário chave-valor
    "Pagamento via Pix" to pagamentoViaPix,
    "Cupom" to cupom,
    "Sem desconto" to semDesconto,
    "Black Friday" to blackFriday
)

fun executarEx04() {
    val valorOriginal = 200.0

    println("Ex04 | Valor original: ${valorOriginal.emReais()}")

    cenarios.forEach { (nome, regra) ->
        val valorFinal = aplicarDesconto(valorOriginal, regra)

        println("$nome -> ${valorFinal.emReais()}")
    }
}