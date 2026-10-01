package com.example.composeinit.ui.lessons

import android.R.attr.value
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.enuns.ArrangementOption
import com.example.composeinit.enuns.RowAligmentOption
import com.example.composeinit.ui.components.Caixa
import com.example.composeinit.ui.components.RowDemo
import com.example.composeinit.ui.lesson.LessonScaffold
import com.example.composeinit.ui.lesson.OptionsControl
import com.example.composeinit.ui.theme.ComposeInitTheme

@Composable
fun L05ColumnRow(
) {

    var arrangement by remember { mutableStateOf(ArrangementOption.START) }
    var alignment by remember { mutableStateOf((value = RowAligmentOption.CENTER)) }
    LessonScaffold(
        title = "Column e Row",
        notice = "As três caixas estão numa Row. 'arrangement' muda como o espaço " +
                "horizontal é distribuído; 'alignment' encosta as caixas no topo, no " +
                "meio ou na base. A Column faria o mesmo, só que na vertical.",
        controls = {
            OptionsControl(
                label = "horizontalArrangement",
                options = ArrangementOption.entries.toList(),
                selected = arrangement,
                optionLabel = {it.label},
                onSelected = {arrangement = it}
            )
            OptionsControl(
                label = "verticalAlignment",
                options = RowAligmentOption.entries.toList(),
                selected = alignment,
                optionLabel = {it.label},
                onSelected = {arrangement = it}
        }
    ) {
        RowDemo(
            arrangement = arrangement.value,
            alignmentOption = aligment.value
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun L05ColumnRowPreview() {
    ComposeInitTheme {
        L05ColumnRow()
    }
}