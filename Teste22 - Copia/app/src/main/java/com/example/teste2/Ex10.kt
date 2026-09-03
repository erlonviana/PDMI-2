package com.example.teste2

//herança serve para "replicar" uma caracteristica
//interface é um pouco diferente...
//usar quando vc não quer deixar uma classe altamente acoplada à outra ou criar um padrão de rota de navegação

//interface + nome da regra (remunerável) {atributos ou funções obrigatórios para a classe}
interface Remuneravel {
    val nome: String

    fun calcularPagamentoDoMes():Double
}

class Mensalista(
    override val nome: String,
    private val salarioFixo:Double
): Remuneravel{
    override fun calcularPagamentoDoMes(): Double = salarioFixo
}

class Freelancer(
    override val nome: String,
    private val horasTrabalhadas: Double,
    private val valorHora: Double
    ): Remuneravel {
    override fun calcularPagamentoDoMes(): Double = horasTrabalhadas * valorHora
}

fun imprimirDemonstrativo(colaborador: Remuneravel){
    println("${colaborador.nome}: ${colaborador.calcularPagamentoDoMes().emReais()}")

}

fun executarEx10(){
    val folha: List<Remuneravel> = listOf(
        Mensalista(nome= "Ana (Mensalista)", salarioFixo = 4500.0),
        Freelancer(nome= "Bruno (Freelancer)", horasTrabalhadas = 80.0, valorHora = 75.0),
    )

    folha.forEach { colaborador -> imprimirDemonstrativo(colaborador)}

    val totalFolha = folha.sumOf { colaborador -> colaborador.calcularPagamentoDoMes() }

    println("Ex10 | Total da folha: ${totalFolha.emReais()}")
}