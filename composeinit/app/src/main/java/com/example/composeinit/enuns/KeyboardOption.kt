package com.example.composeinit.enuns

import androidx.compose.ui.text.input.KeyboardType

enum class KeyboardOption(
    val label: String,
    val value: KeyboardType
) {
    TEXT("Text", KeyboardType.Text),
    NUMBER("Number", KeyboardType.Number),
    EMAIL("Email", KeyboardType.Email)
}