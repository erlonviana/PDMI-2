package com.example.teste2.model

class AlunoNormal (
    var nome: String,
    var idade: Int,
){
    fun apresentar(){
        println("Olá, meu nome é $nome e tenho $idade anos")
    }

}