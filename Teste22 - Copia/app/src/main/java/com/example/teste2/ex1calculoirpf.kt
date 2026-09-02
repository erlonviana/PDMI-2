package com.example.teste2

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

fun executarEx01() {
    // Teste 1: Salário R$ 1.000,00 (isento)
    val imposto1 = calcularIrrf(1000.0)
    println("Ex01 | Salário R$ 1.000,00 -> Imposto: R$ $imposto1") // 0.0

    // Teste 2: Salário R$ 2.500,00 (alíquota 7.5%)
    val imposto2 = calcularIrrf(2500.0)
    println("Ex01 | Salário R$ 2.500,00 -> Imposto: R$ $imposto2") // 187.5

    // Teste 3: Salário R$ 3.000,00 (alíquota 15%)
    val imposto3 = calcularIrrf(3000.0)
    println("Ex01 | Salário R$ 3.000,00 -> Imposto: R$ $imposto3") // 450.0

    // Teste 4: Salário não informado (usa valor padrão 0.0)
    val imposto4 = calcularIrrf()
    println("Ex01 | Salário não informado -> Imposto: R$ $imposto4") // 0.0

    // Teste 5: Passando null explicitamente
    val imposto5 = calcularIrrf(null)
    println("Ex01 | Salário null -> Imposto: R$ $imposto5") // 0.0
}