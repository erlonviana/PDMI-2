package com.example.teste2.ui.theme

import com.example.teste2.calcularFatura

fun calcular(consumoKwh:Double,precoKwh:Double):Double = consumoKwh * precoKwh * if(consumoKwh>150) 1.10 else 1.0

fun exeEx02(){
    val precoKwh = 0.85

    listOf(100.0,150.0,200.0).forEach { consumo ->
        val bandeira = if(consumo > 150) "vermelha (+10%)" else "sem acrescimo"
        println("Consumo $consumo kWh [$bandeira] -> ${calcularFatura( consumoKwh= consumo, precoKwh).emReais()}")
    }
}