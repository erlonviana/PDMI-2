package com.example.composeinit.ui.lesson

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlin.math.roundToInt

@Composable
fun SliderControl(
    label:String,
    value:Float,
    onValueChange:(Float)-> Unit,
    range: ClosedFloatingPointRange<Float>,
    modifier: Modifier = Modifier) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "$label= ${value.roundToInt()}"
        )
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = range
        )
    }
}