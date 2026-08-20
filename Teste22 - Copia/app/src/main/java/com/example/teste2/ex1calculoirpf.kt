package com.example.teste2

import util.emReais

private const val TETO_ISENCAO = 2259.20
private const val TETO_FAIXA_INTERMEDIARIA = 2826.65

fun calcularIrrf(salarioBruto:Double?):Double{
    //criando uma constante para que, caso o salarioBruto seja null, o valor seja 0
    val salario = salarioBruto?: 0.0
    val aliquota = when{
        salario<= TETO_ISENCAO -> 0.0
        salario<= TETO_FAIXA_INTERMEDIARIA ->7.5
        else ->15.0
    }

    return salarioBruto * (aliquota/100)
}

fun executarEx01(){
    val casosDeTeste:List<Double?> = ListOf(2000.0,2500.0,5000.0,null)

    casosDeTeste.forEach {salarioBruto ->
        val entrada = salarioBruto?.emReais() ?: "null (não informado)"
        println(
            "Salario bruto $entrada -> IRRF ${calcularIrrf(salarioBruto).emReais()}"
        )
    }
}