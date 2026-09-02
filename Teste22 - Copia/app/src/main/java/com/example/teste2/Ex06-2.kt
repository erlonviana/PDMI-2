package com.example.teste2

import com.example.teste2.model.Produto
import util.emReais

//private const val CATEGORIA_ALVO = "Eletrônicos"
private const val FATOR_REAJUSTE = 1000.00

//acrescentar 1000 a todos os precos e incluir fatec no nome do produto

fun reajusteParaCategoriaEletronicos(catalogo: List<Produto>): List<Produto =
    catalogo

        .map { eletronico -> eletronico.copy(
            nome = eletronico.nome + "Fatec",
            preco = eletronico.preco + FATOR_REAJUSTE
        )

        }


fun executarEx06_2(){
    val catalogo = listOf(
        Produto(nome = "Notebook", preco = 3000.0, categoria = "Eletrônicos"),
        Produto(nome = "Cadeira", preco = 800.0, categoria = "Móveis"),
        Produto(nome = "Fone", preco = 200.0, categoria = "Eletrônicos"),
    )

    reajusteParaCategoriaEletronicos(catalogo).forEach { produto ->
        println("EX06-2 | ${produto.nome} (${produto.categoria}): ${produto.preco.emReais()}")
    }


}

