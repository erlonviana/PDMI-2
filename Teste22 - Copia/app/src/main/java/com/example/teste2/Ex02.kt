// Define o pacote ao qual este arquivo pertence
package com.example.teste

// Importa a função emReais para formatar valores como moeda brasileira (R$)
import util.emReais


// Função responsável por calcular o valor da fatura
//
// consumoKwh = quantidade de energia consumida
// precoKwh   = preço de cada kWh
//
// A função retorna um valor do tipo Double
fun calcularFatura(
    consumoKwh: Double,
    precoKwh: Double
): Double =

// Calcula:
// consumo × preço do kWh
//
    // Depois verifica se o consumo é maior que 150 kWh.
    consumoKwh * precoKwh *

            // if funciona como uma condição:
            //
            // Se consumoKwh > 150:
            //     aplica 1.10 → aumento de 10%
            //
            // Caso contrário:
            //     aplica 1.0 → sem aumento
            if (consumoKwh > 150) 1.10 else 1.0



// Função responsável por executar os exemplos/testes
fun executarEx02() {

    // Define o preço de cada kWh
    val precoKwh = 0.85

    // Cria uma lista com diferentes valores de consumo
    //
    // 100 kWh
    // 150 kWh
    // 200 kWh
    //
    // O forEach irá testar cada um desses valores
    listOf(100.0, 150.0, 200.0).forEach { consumo ->

        // Verifica se o consumo é maior que 150 kWh
        //
        // Se for maior:
        //     "vermelha (+10)"
        //
        // Se não for:
        //     "sem acrescimo"
        val bandeira =
            if (consumo > 150)
                "vermelha (+10)"
            else
                "sem acrescimo"


        // Exibe o resultado no console
        //
        // consumo       → mostra o consumo
        // bandeira      → mostra se houve acréscimo
        // calcularFatura → calcula o valor da conta
        // emReais()     → transforma o número em formato R$
        println(
            "Consumo $consumo Kwh [$bandeira] -> " +
                    "${calcularFatura(consumo, precoKwh).emReais()}"
        )
    }
}
