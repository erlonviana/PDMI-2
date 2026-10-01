package com.example.composeinit.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RowDemo(
    arrangementOption: Arrangement.Horizontal,
    alignmentOption: Alignment.Vertical,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        horizontalArrangement = arrangementOption,
        verticalAlignment = alignmentOption
    ) {
        Caixa("Nome")
        Caixa("Perfil")
        Caixa("100")
    }
}