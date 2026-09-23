package com.example.composeinit.ui.lessons

import android.R
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.ui.lesson.LessonScaffold
import com.example.composeinit.ui.lesson.OptionsControl
import com.example.composeinit.ui.lesson.SwitchControl
import com.example.composeinit.ui.theme.ComposeInitTheme


private const val LONG_TEXT =
    "Compose descreve a tela em vez de manipulá-la. Este parágrafo existe para " +
            "ficar comprido o suficiente e mostrar o que acontece quando o texto não cabe."


enum class TextStyleOption(
    val label: String
) {
    BODY("bodyLarge"),
    TITLE("titleLarge"),
    HEADLINE("headlineMedium")
}


@Composable
fun L02FirstComposable() {
    var styleOption by remember { mutableStateOf(TextStyleOption.BODY) }
    var limitLines by remember { mutableStateOf(false) }

    LessonScaffold(
        title = "Text",
        notice = "Troque o estilo e veja o texto mudar de tamanho e peso junto — " +
                "é o tema decidindo, não você. Ligue 'limitar a 1 linha' para ver as " +
                "reticências do overflow.",

        controls = {
            SwitchControl(
                label = "maxLines = 1",
                checked = limitLines,
                onCheckedChange = { limitLines = it }
            )
            OptionsControl(
                label = "style",
                options = TextStyleOption.entries.toList(),
                selected = styleOption,
                optionLabel = { it.label },
                onSelected = { styleOption = it }
            )
        }
    ) {
        TextDemo(
            styleOption = styleOption,
            limitLines = limitLines
        )


    }
}

@Composable
fun TextDemo(
    styleOption: TextStyleOption,
    limitLines: Boolean,
) {
    val styleCustom: TextStyle = when (styleOption) {
        TextStyleOption.BODY -> MaterialTheme.typography.bodyLarge
        TextStyleOption.TITLE -> MaterialTheme.typography.titleLarge
        TextStyleOption.HEADLINE -> MaterialTheme.typography.headlineLarge
    }
    Text(
        text = LONG_TEXT,
        maxLines = if (limitLines) 1 else 10,
        style = styleCustom
    )
}


@Preview
@Composable
private fun L02FirstComposablePreview() {
    ComposeInitTheme {
        L02FirstComposable()
    }
}


