package com.example.atv_composable.ui.lessons

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.ui.lesson.LessonScaffold
import com.example.composeinit.ui.theme.ComposeinitTheme
import com.example.composeinit.ui.components.BoasVindas
import com.example.composeinit.ui.components.calcularIrrf


@Composable
fun L01LessonComposable(){
    LessonScaffold(        title = "Segundo Composable",
        notice =  "Esta lição não tem controles. O objetivo é só olhar a função" + "abaixo no código:")
    {
        calcularIrrf(1000.0)
    }

}


@Preview
@Composable
fun GreetingDemo(){
    Text(
        text = "salario de 1000",
        style = MaterialTheme.typography.headlineMedium
    )
}

@Preview
@Composable
private fun L01FirstComposablePreview(){
    ComposeinitTheme {
        GreetingDemo()
    }
}