package com.example.teste2.model

//open permite veiculo ser herdada para outras classes
open class Veiculo(//classe com parenteses: construtor da classe, são os valores mínimos (obrigatórios) para criar a classe
    val placa: String,
    val taxaDiaria:Double

) {
    //valores dentro das chaves NÂO são obrigatórios para criação da classe
    open fun calcularAluguel(dias:Int): Double = dias * taxaDiaria
}

class Carro(
    placa: String,
    taxaDiaria: Double
): Veiculo(placa:String, taxaDiaria:Double){//para vincular à nossa classe pai, precisa ter os dois pontos

}

class Caminhao(
    placa: String,
    taxaDiaria: Double,
    val tonelagem: Double,
    val taxaPorPeso: Double
): Veiculo(placa:String, taxaDiaria:Double){//para vincular à nossa classe pai, precisa ter os dois pontos
//override: opçao de acessar uma função na classe pai
override fun calcularAluguel(dias: Int): Double {
    return super.calcularAluguel(dias)+ (tonelagem * taxaPorPeso)
}
}

/*
O professor escolheu open class para ser mais flexível e reutilizar código. O Carro não precisa
reescrever o método porque ele já funciona com a implementação padrão do pai. O Caminhao sobrescreve
para adicionar o cálculo do peso. É uma escolha de design inteligente! 🚀
*/