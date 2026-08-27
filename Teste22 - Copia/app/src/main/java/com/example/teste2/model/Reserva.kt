package com.example.teste2.model


//não será data class
//dentro dos parenteses é o construtor da classe
class Reserva(
    val quantidadeDeHospedes:Int,
    val diasDeEstadia:Int
) {
    //criado dentro das chaves
    var status:String = "PENDENTE"
        //privado permite alterar um valor apenas dentro da classe
    private set

    fun confirmar(): Boolean{
        //só confirma a reserva/estadia se hospedes ou dias de estadia maiores que 0
        val dadosValidados = quantidadeDeHospedes>0 && diasDeEstadia>0
        //abaixo: se o meu dado não for validado...
        if (!dadosValidados){
            return false
        }

        status = "CONFIRMADA"
        return true
    }
}

