package com.example.teste2

import util.emReais

private const val FATOR_LIQUIDO = 0.89 //100%-11% = 89%

private const val PATAMAR_MINIMO = 2000.0

fun filtrarSalarios(salariosBrutos:List<Double>):List<Double>{
    //val salariosFiltrados = salariosBrutos
    return salariosBrutos
        .map { bruto -> bruto * FATOR_LIQUIDO)}
        .filter { liquido -> liquido > PATAMAR_MINIMO }

    //manipulando a lista criada
    //salariosFiltrados. (trabalhando com a variável criada)

    //return salariosFiltrados
}


fun executarEx05(){
    val salariosBrutos = ListOf(1500.0, 2000.0, 2500.0, 3000.0, 5000.0)
    val liquidosAprovados = filtrarSalarios(salariosBrutos)
    println("EX05 | Salarios Liquidos acima de ${PATAMAR_MINIMO.emReais()}")
    liquidosAprovados.forEach { liquido ->
        println("Salario liquido ${liquido.emReais()}")
    }
    println("Lista original: $salariosBrutos")
}

//.map : cria uma nova lista temporaria com base na lista fornecida, de acordo com os parametros indicados
//.filter : acessa a lista recém criada e exibe os itens que atendam os requisitos