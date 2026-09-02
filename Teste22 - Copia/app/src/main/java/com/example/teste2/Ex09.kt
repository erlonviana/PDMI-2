package com.example.teste2

import com.example.teste2.model.Veiculo
import com.example.teste2.model.Carro
import com.example.teste2.model.Caminhao

fun executarEx09(){
    val diasLocacao = 5

    val frota:List<Veiculo> = listOf(
        Carro(placa = "CAR-1C23", taxaDiaria = 120.0),
        Caminhao(placa = "CAM-4C56", taxaDiaria = 300.0, tonelagem = 8.0, taxaPorPeso = 50.0),
    )

    frota.forEach { veiculo ->
        println("EX09 | ${Veiculo.placa} -> ${veiculo.calcularAluguel(dias = diasLocacao).emReais()}")
    }

}

/*
O professor escolheu open class para ser mais flexível e reutilizar código. O Carro não precisa
reescrever o método porque ele já funciona com a implementação padrão do pai. O Caminhao sobrescreve
para adicionar o cálculo do peso. É uma escolha de design inteligente! 🚀
*/


