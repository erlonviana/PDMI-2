package com.example.composeinit.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

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
                        if (fillWidth) Modifier.fillMaxWidth() else Modifier
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
                "background->padding ",
                style = MaterialTheme.typography.labelSmall
            )

            Text(
                text = "caixa",
                modifier = Modifier
                    .then(
                        if (fillWidth) Modifier.fillMaxWidth() else Modifier
                    )
                    .background(color)
                    .padding(padding)

            )
        }
    }
}