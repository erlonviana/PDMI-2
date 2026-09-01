// 1. Classe abstrata Veiculo (não pode ser instanciada diretamente)
abstract class Veiculo(
    val placa: String,
    val taxaDiaria: Double
) {
    // Método abstrato: cada tipo de veículo implementa sua própria fórmula
    abstract fun calcularAluguel(dias: Int): Double
}

// 2. Carro: usa a fórmula simples
class Carro(
    placa: String,
    taxaDiaria: Double
) : Veiculo(placa, taxaDiaria) {
    override fun calcularAluguel(dias: Int): Double {
        return dias * taxaDiaria
    }
}

// 3. Caminhão: tem campos adicionais e fórmula diferente
class Caminhao(
    placa: String,
    taxaDiaria: Double,
    val tonelagem: Double,
    val taxaPorPeso: Double
) : Veiculo(placa, taxaDiaria) {
    override fun calcularAluguel(dias: Int): Double {
        return (dias * taxaDiaria) + (tonelagem * taxaPorPeso)
    }
}

// 4. Criando a lista e calculando
fun main() {
    // Criando os veículos
    val carro = Carro("ABC-1234", 120.0)
    val caminhao = Caminhao("XYZ-5678", 300.0, 8.0, 50.0)

    // Lista contendo ambos os tipos (polimorfismo!)
    val veiculos: List<Veiculo> = listOf(carro, caminhao)

    // Percorrendo a lista SEM verificar o tipo (regra 4!)
    val dias = 5
    veiculos.forEach { veiculo ->
        val valorAluguel = veiculo.calcularAluguel(dias)
        println("${veiculo::class.simpleName} - Placa: ${veiculo.placa} -> Aluguel: R$ %.2f".format(valorAluguel))
    }
}

