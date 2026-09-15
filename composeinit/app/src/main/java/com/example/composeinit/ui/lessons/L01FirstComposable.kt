package com.example.composeinit.ui.lessons

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.ui.components.BoasVindas
import com.example.composeinit.ui.lesson.LessonScaffold        // ← ADICIONADO
import com.example.composeinit.ui.theme.ComposeinitTheme

@Composable
fun L01FirstComposable() {
    LessonScaffold(
        title = "Seu primeiro Composable",
        notice = "Esta lição não tem controles. O objetivo é só olhar a função " +
                "abaixo no código: ela é uma função normal, marcada com @Composable, " +
                "que descreve um texto na tela.",
    ) {
        BoasVindas("Erlon", Modifier)
    }
}

@Composable
fun GreetingDemo() {
    Text(
        text = "Olá, Compose",
        style = MaterialTheme.typography.headlineMedium
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingDemoPreview() {
    ComposeinitTheme() {
        GreetingDemo()
    }
}

@Preview
@Composable
private fun L01FirstComposablePreview() {
    ComposeinitTheme() {
        L01FirstComposable()
    }
}