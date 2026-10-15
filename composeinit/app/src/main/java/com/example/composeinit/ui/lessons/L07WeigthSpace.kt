package com.example.composeinit.ui.lessons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeinit.ui.lesson.LessonScaffold
import com.example.composeinit.ui.lesson.SliderControl

@Composable
fun L07WeightSpace() {
    var weightA by remember { mutableFloatStateOf(value = 1f) }
    var weightB by remember { mutableFloatStateOf(value = 1f) }
    var weightC by remember { mutableFloatStateOf(value = 1f) }
    var rangeWeight = 1f..3f

    LessonScaffold(
        title = "Peso e Espaço",
        notice = "Cada caixa tem um peso. Aumente um e veja-o roubar espaço",
        controls = {
            SliderControl(label = "Peso A", value= weightA, onValueChange = {weightA = it}, rangeWeight)
            SliderControl(label = "Peso B", value= weightB, onValueChange = {weightB = it}, rangeWeight)
            SliderControl(label = "Peso C", value= weightC, onValueChange = {weightC = it}, rangeWeight)

        }
    ){
        WeightDemo(
            weightA = weightA,
            weightB = weightB,
            weightC = weightC,

            )
    }
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)

        ) {

            PesoCaixa("A", weightA, MaterialTheme.colorScheme.primaryContainer)
            PesoCaixa("B", weightB, MaterialTheme.colorScheme.secondaryContainer)
            PesoCaixa("C", weightC, MaterialTheme.colorScheme.tertiaryContainer)


        }
    }
}

@Composable
fun RowScope.PesoCaixa(
    rotulo:String,
    peso:Float,
    cor: Color
) {
    Text(text = rotulo,
        modifier = Modifier
            .weight(peso)
            .background(cor)
            .fillMaxHeight()
            .wrapContentHeight(Alignment.CenterVertically),
        textAlign = TextAlign.Center
    )
}

@Composable
fun WeightDemo(
    weightA: Float,
    weightB: Float,
    weightC: Float
    ){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)

    ){

        PesoCaixa("A", weightA, MaterialTheme.colorScheme.primaryContainer)
        PesoCaixa("B", weightB, MaterialTheme.colorScheme.secondaryContainer)
        PesoCaixa("C", weightC, MaterialTheme.colorScheme.tertiaryContainer)


    }
}

@Preview(showBackground = true
)
@Composable
private fun L07WeightSpacePreview() {
    L07WeightSpace()
}