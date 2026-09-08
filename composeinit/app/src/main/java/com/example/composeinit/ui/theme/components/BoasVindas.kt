package com.example.composeinit.ui.theme.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

// Componente visual sempre usar text com cubo azul
// modifier estiliza componente
@Composable
fun BoasVindas(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Nosso Primeiro Componente, Olá $name!",
        modifier = modifier
    )
}