package com.example.composeinit.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeinit.ui.theme.ComposeInitTheme

@Composable
fun Caixa(texto: String) {
    Text(
        text = texto,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(12.dp)
    )

}

@Preview(showBackground = true)
@Composable
private fun CaixaPreview() {
    ComposeInitTheme {
        Caixa("TESTE DE PREVIEW")
    }
}