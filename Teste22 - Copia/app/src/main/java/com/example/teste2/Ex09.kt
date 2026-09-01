package com.example.teste2.model

import com.example.app_teste.model.emReais

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


