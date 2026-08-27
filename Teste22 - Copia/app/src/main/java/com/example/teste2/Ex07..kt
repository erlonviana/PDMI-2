package com.example.teste2

import com.example.teste2.model.Transacao

private const val FATOR_CASHBACK = 1.02

fun aplicarCashback(transacao: Transacao): Transacao{
    return transacao
        .copy(
            valor = transacao.valor * FATOR_CASHBACK
        )}




fun executarEx07(){
    val compraFreitas = Transacao( id = 1, descricao = "Comprei um cachorrao escondido", valor = 100.0)

    val comCashback = aplicarCashback(transacao = compraFreitas)


    println("Ex07 | Valor original: ${compraFreitas.valor} ")
    println("Ex07 | Valor com cashback: ${comCashback.valor} ")

    val copiaCompraFreitas = Transacao( id = 1, descricao = "Comprei um cachorrao escondido", valor = 100.0)

    println("Ex07 | Dois registros do mesmo conteúdo são iguais? ${ compraFreitas == copiaCompraFreitas}")
    println("Ex07 | São os mesmos objetos em memória?  ${ compraFreitas === copiaCompraFreitas}")

    //no caso acima, eles serão diferentes pois são variáveis diferentes
}