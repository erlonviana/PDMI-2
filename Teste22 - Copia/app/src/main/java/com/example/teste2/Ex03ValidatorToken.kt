package com.example.teste2

private const val TAMANHO_MINIMO_DO_TOKEN = 10

fun validadorAcesso(token:String?): String = when{
    token == null -> "Alerta: token ausente"
    token.length > TAMANHO_MINIMO_DO_TOKEN -> "Autorizado"
    else -> "Alerta: Token muito curto"
}

fun executarEx03(){
    val casosDeTeste: List<String?> = listOf("abc123xyz789", "abc123", null)

    casosDeTeste.forEach{ token ->
        //verificar função let********
        val entrada = token?.let { "$it (${it.length} caracteres)" }?: "null"
        println("Token $entrada -> ${validadorAcesso(token)}")

    }
}