package com.example.composeinit.ui.lessons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.enuns.AccentOption
import com.example.composeinit.ui.lesson.LessonScaffold
import com.example.composeinit.ui.lesson.OptionsControl
import com.example.composeinit.ui.lesson.SliderControl
import com.example.composeinit.ui.theme.ComposeInitTheme

@Composable
fun L11CardSurface(modifier: Modifier = Modifier)
    var elevation by remember { mutableStateOf(value = 2f)
        var accent by remember { mutableStateOf(value = AccentOption.PRIMARY)}

        LessonScaffold(
            title="Card e Surface",
            notice="notice = \"Aumente a elevação e veja a sombra crescer sob o card. Troque a \" +\n" +
                    "    \"cor de destaque do ícone e do divisor.\",",
            controls = {
                SliderControl((
                        label = "elevation",
                        value= elevation,
                    {
                        elevation = it
                    },
                        range = 0..12
                        )

                OptionsControl(
                    label = "cor destaque",
                    options = AccentOption.entries.toList(),
                    selected = accent,
                    {it.label},
                    onSelected = {accent = it}
                ))
            }
        ) {
            CardDemo(
                elevation = elevation.roundToInt().dp,
                accentOption = accent,
            )
        }
@Composable
fun CardDemo(
    elevation: Dp,
    accentOption: AccentOption
){
    val cor: Color = when(accentOption){
        AccentOption.PRIMARY -> MaterialTheme.colorScheme.primary
        AccentOption.TERTIARY -> MaterialTheme.colorScheme.tertiary
        AccentOption.ERROR -> MaterialTheme.colorScheme.Error
    }
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = Elevation)
    ){
        Column(
            modifier = Modifier.padding(all = 16.dp)
        ) {
            Row(
                verticalAligment = Aligment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
            ){
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = cor
                )
                Text(
                    text="Favorito",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            HorizontalDivider(
                modifier = Modifier.padding(
                    vertical = 8.dp
                ),
                color = cor
            )
            Text(text="Conteúdo do card, agrupado numa superfície elevada.")
        }
    }
}
    }



@Preview
@Composable
private fun L11CardSurfacePreview() {
    ComposeInitTheme {
        L11CardSurface()
    }
}
