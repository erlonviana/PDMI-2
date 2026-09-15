package com.example.composeinit.ui.lessons

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.ui.lesson.LessonScaffold
import com.example.composeinit.ui.lesson.OptionsControl
import com.example.composeinit.ui.lesson.SwitchControl
import com.example.composeinit.ui.theme.ComposeinitTheme

private const val LONG_TEXT =
    "Compose descreve a tela em vez de manipulá-la. Este parágrafo existe para " +
            "ficar comprido o suficiente e mostrar o que acontece quando o texto não cabe."

private enum class TextStyleOption(val label: String){
    BODY(label="bodyLarge"),
    TITLE(label="titleLarge"),
    HEADLINE(label="headlineMedium")
}

@Composable
fun L02FirstComposable() {
    var styleOption by remember { mutableStateOf(value = TextStyleOption.BODY) } //busca os valores a partir de BODY
    var limitLines by remember { mutableStateOf(value = false) }   // limite de linhas *

    LessonScaffold(
        title = "L02FirstComposable",
        notice = "Troque o estilo e veja o texto mudar de tamanho e peso junto — " +
                "é o tema decidindo, não você. Ligue 'limitar a 1 linha' para ver as " +
                "reticências do overflow.",
        controls = {
            SwitchControl(
                label = "maxLines = 1",
                checked = limitLines,                          // ← USA O ESTADO *
                onCheckedChange = { limitLines = it }          // ← ATUALIZA O ESTADO
            )
            OptionsControl(
                label = "style",
                options = TextStyleOption.entries.toList(),
                selected = styleOption, //onde guarda o estado
                optionLabel = {it.label},//mostra o item que vc está selecionando da lista
                onSelected = {styleOption=it} //escuta a alteração que o usuario faz
            )
        }
    ) {
        Text(
            text = LONG_TEXT,                                // ← usa LONG_TEXT
            style = when (styleOption) {                     // ← aplica o estilo escolhido
                TextStyleOption.BODY -> MaterialTheme.typography.bodyLarge
                TextStyleOption.TITLE -> MaterialTheme.typography.titleLarge
                TextStyleOption.HEADLINE -> MaterialTheme.typography.headlineMedium
            },
            maxLines = if (limitLines) 1 else Int.MAX_VALUE,   // ← aplica o switch *
            overflow = TextOverflow.Ellipsis                 // ← mostra "..." quando corta
        )
    }
}

@Preview
@Composable
private fun L02FirstComposablePreview() {
    ComposeinitTheme(){
        L02FirstComposable()
    }
}