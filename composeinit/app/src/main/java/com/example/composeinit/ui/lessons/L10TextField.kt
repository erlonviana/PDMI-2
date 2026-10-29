package com.example.composeinit.ui.lessons

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.ImeAction.Companion
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.enuns.KeyboardOption
import com.example.composeinit.ui.lesson.LessonScaffold
import com.example.composeinit.ui.lesson.OptionsControl
import com.example.composeinit.ui.lesson.SwitchControl
import com.example.composeinit.ui.theme.ComposeInitTheme
import kotlin.math.sin

@Composable
fun L10TextField() {
    var text by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf(false) }
    var keyboard by remember { mutableStateOf(KeyboardOption.TEXT) }

    LessonScaffold(
        title = "TextField",
        notice = "Digite no campo. Ligue 'senha' para mascarar, 'erro' para ver o " +
                "vermelho, e troque o teclado — repare como o conjunto de teclas muda.",
        controls = {
            SwitchControl(
                label = "senha",
                checked = password,
                onCheckedChange = { password = it }
            )
            SwitchControl(
                label = "erro",
                checked = isError,
                onCheckedChange = { isError = it }
            )
            OptionsControl(
                label = "KeyboardType",
                options = KeyboardOption.entries.toList(),
                selected = keyboard,
                optionLabel = { it.label },
                onSelected = {
                    keyboard = it
                }
            )
        }
    ) {
        TextFieldDemo(
            value = text,
            onValueChange = { text = it },
            isError = isError,
            password = password,
            keyboardType = keyboard.value, //dentro de value é onde tem a tipagem do nosso teclado
        )
    }
}

@Composable
fun TextFieldDemo(
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean,
    password: Boolean,
    keyboardType: KeyboardType
) {
    val masked = if (password) PasswordVisualTransformation() else VisualTransformation.None
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Digite Aqui") },
        isError = isError,
        singleLine = true,
        visualTransformation = masked,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = ImeAction.Done)
    )

}


@Preview
@Composable
private fun L10TextFieldPreview() {
    ComposeInitTheme {
        L10TextField()
    }
}