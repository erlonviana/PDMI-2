package com.example.composeinit.ui.lessons

import android.icu.number.IntegerWidth
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.composeinit.ui.lesson.LessonScaffold
import com.example.composeinit.ui.lesson.SliderControl
import com.example.composeinit.ui.lesson.SwitchControl
import com.example.composeinit.ui.theme.ComposeInitTheme
import kotlin.math.roundToInt

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
                    text = "caixa",
                    modifier = Modifier
                        .then(
                            if(fillWidth) Modifier.fillMaxWidth() else Modifier
                        )
                        .padding(padding.roundToInt().dp)
                        .background(color)
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "background -> padding",
                    style = MaterialTheme.typography.labelSmall
                )

                Text(
                    text = "caixa",
                    modifier = Modifier
                        .then(
                            if(fillWidth) Modifier.fillMaxWidth() else Modifier
                        )
                        .background(color)  //ver por que inverteu a ordem das propriedades
                        .padding(padding.roundToInt().dp)

                )
            }
        }
    }
}

@Composable
fun ModifierDemo(
    padding: Dp,
    fillWidth: Boolean
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
                text = "caixa",
                modifier = Modifier
                    .then(
                        if(fillWidth) Modifier.fillMaxWidth() else Modifier
                    )
                    .padding(padding)
                    .background(color)
            )
        }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "background -> padding",
                style = MaterialTheme.typography.labelSmall
            )

            Text(
                text = "caixa",
                modifier = Modifier
                    .then(
                        if(fillWidth) Modifier.fillMaxWidth() else Modifier
                    )
                    .background(color)  //ver por que inverteu a ordem das propriedades
                    .padding(padding.)

            ) {
                ModifierDemo(
                    padding = padding.roundToInt().dp,
                    fillWidth = fillWidth
                )
            }

        }


@Preview(showBackground = true)
@Composable
private fun L04ModifierPreview() {
    ComposeInitTheme {

        L04Modifier()
    }
}

        //entender como transformar val color em composable