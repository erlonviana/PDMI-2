package com.example.composeinit.ui.lessons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeinit.ui.lesson.LessonScaffold

@Composable
fun L03Parameters() {
    var text by remember { mutableStateOf("Tela de login") } // remember serve para guardar o estado da variável
    LessonScaffold(
        title = "Parametros",
        notice = "O primeiro titulo ignora o que vc digita"
    ) {
        ParametersDemo(text)
    }
}

@Composable
fun ParametersDemo(texto: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        Text(text = "Componente Stateless")
        StatelessTitle()
        Text(text = "Componente Stateful")
        StatefullTitle(texto)
        StatefullTitle(text = "$texto (de novo)")
        StatefullTitle(texto.uppercase())
    }
}

@Preview(showBackground = true)
@Composable
private fun ParametersDemoPreview() {
    ParametersDemo(text = "Teste DSM5")
}

@Composable
fun StatelessTitle() {
    Text(
        text = "Componente Stateless",
        fontSize = 28.sp
    )
}

@Composable
fun StatefullTitle(
    text: String
) {
    Text(
        text = text,
        fontSize = 28.sp
    )
}