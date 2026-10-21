package com.example.composeinit.ui.lessons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.Clipboard
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.enuns.ButtonVariant
import com.example.composeinit.ui.lesson.LessonScaffold
import com.example.composeinit.ui.lesson.OptionsControl
import com.example.composeinit.ui.lesson.SwitchControl
import com.example.composeinit.ui.theme.ComposeInitTheme

@Composable
fun L09Button() {
    var variant by remember { mutableStateOf(value= ButtonVariant.FILLED) }
    var enabled by remember { mutableStateOf(value = True) }
    var clicks by remember { mutableStateOf(value = 0)}
    LessonScaffold(
        title = "Button",
        notice = "Toque o botão e veja o controlador subir",
        controls = {
            OptionsControl(
                label = "Variant",
                options = ButtonVariant.entries.toList(),
                selected = variant,
                optionLabel = {it.label},
                onSelected = {variant = it}
            )
            SwitchControl(
                label = "enabled",
                onCheckedChange = {enabled = it}
            )
        }
    ) {
        //sessão de variante
        ButtonDemo(
            variant = variant,
            enabled = enabled,
            clicks = clicks,
            onClick = { clicks++ }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(space= 12.dp)
            ){
                when(variant){
                    ButtonVariant.FILLED -> Button(
                        onClick = onClick,
                        enabled = enabled
                    ) { Text(text="Entrar FILLED")}


                    ButtonVariant.OUTLINED -> Button(
                         onClick = onClick,
                         enabled = enabled
                    ) { Text(text="Entrar OUTLINED")}

                    ButtonVariant.TEXT-> TextButton(
                        onClick = onClick,
                        enabled = enabled
                    ) { Text(text="Entrar TEXT")}
                }

                Text(
                    text = "clicks : $clicks",
                    style = MaterialTheme.typography.titleMedium { }
                )
            }

        }

    }


}

@Composable
fun ButtonDemo(
    variant: ButtonVariant,
    enabled: Boolean,
    clicks: Int,
    onClick: () -> Unit
)

@Preview
@Composable
private fun L09ButtonPreview(){
    ComposeInitTheme {
        L09Button()
    }
}