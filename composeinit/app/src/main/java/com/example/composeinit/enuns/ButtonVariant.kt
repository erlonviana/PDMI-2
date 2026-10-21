package com.example.composeinit.enuns

import kotlinx.serialization.descriptors.PrimitiveKind

class ButtonVariant (
    val label: String
) {
    FILLED(label="Filled"),
    OUTLINED(label="Outlined"),
    TEXT(label="Text")
}