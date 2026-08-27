package com.example.teste2

import com.example.teste2.model.Reserva

//Visibilidade de atributos dentro da classe


fun executarEx08(){
    val casosDeTeste = listOf(
        Reserva(quantidadeDeHospedes = 2, diasDeEstadia = 3),
        Reserva(quantidadeDeHospedes = 0, diasDeEstadia = 3),
        Reserva(quantidadeDeHospedes = 2, diasDeEstadia = 0),

    )

    //val reservaExplicacao = Reserva(quantidadeDeHospedes = 2, 2)
    //println("Ex08 | status inicial ${reservaExplicacao.status}")

    //reservaExplicacao.status = "OK"
    //println("Ex08 | status inicial ${reservaExplicacao.status}")

    casosDeTeste.forEach { reserva ->
        val retorno = reserva.confirmar()
        println(
            "Ex08 | Hospedes ${reserva.quantidadeDeHospedes}, dias${reserva.diasDeEstadia}"+"- confirma() = $retorno, status = ${reserva.status}"
        )
    }


    println("Ex08 | status inicial ${reservaExplicacao.status}")


    println("Ex08 | ")
}