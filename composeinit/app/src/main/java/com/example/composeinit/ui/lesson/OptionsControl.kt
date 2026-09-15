package com.example.composeinit.ui.lesson

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun <T>OptionsControl(
    label:String,
    options:List<T>,
    selected:T,
    optionLabel:(T)->String,
    onSelected:(T) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ){
        Text(text = label,
            style = MaterialTheme.typography.labelLarge
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(state= rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ){
            options.forEach { option->
                FilterChip(
                    selected = option == selected,
                    onClick = { onSelected(option)},
                    label = { Text(text=optionLabel(option))}
                )
            }
        }
    }

}