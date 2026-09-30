package com.example.composeinit.ui.lessons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.ui.lesson.LessonScaffold
import com.example.composeinit.ui.lesson.SliderControl
import com.example.composeinit.ui.lesson.SwitchControl
import com.example.composeinit.ui.theme.ComposeInitTheme

@Composable
fun L04Modifier(modifier: Modifier = Modifier) {
    var padding by remember { mutableStateOf(16f) }
    var fillWidth by remember { mutableStateOf(false) }
    LessonScaffold(
        title = "Modifier",
        "As duas caixas usam os mesmos modificadores — só a ordem muda. " +
                "Aumente o padding e repare que na primeira a cor encolhe, e na " +
                "segunda a cor fica e o texto é que se afasta.",
        controls = {
            SliderControl(
                "padding",
                value = padding,
                onValueChange = { padding = it },
                range = 0f..48f
            )
            SwitchControl(
                label = "fillMaxWidth()",
                checked = fillWidth,
                onCheckedChange = { fillWidth = it }
            )
        }
    ) {
        val color = MaterialTheme.colorScheme.primaryContainer
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "padding -> background",
                    style = MaterialTheme.typography.labelSmall
                )

                Text(
                    "caixa"

                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "padding -> background",
                    style = MaterialTheme.typography.labelSmall
                )
                Text("caixa")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun L04ModifierPreview() {
    ComposeInitTheme {

        L04Modifier()
    }
}