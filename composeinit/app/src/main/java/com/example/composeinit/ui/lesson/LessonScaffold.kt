package com.example.composeinit.ui.lesson

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonScaffold(
    title: String,
    notice: String,
    modifier: Modifier = Modifier,
    controls:(@Composable ColumnScope.()->Unit)? = null,
    //o componente visual é o ultimo para podermos acessá-lo em chamadas futuras
    demo: @Composable () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    IconButton(onClick = {/*OUTRA HORA*/ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
                .imePadding()
        ) {
            DemoArea (content = demo )

            Text(
                text = notice,
                style = MaterialTheme.typography.bodyMedium
            )

            if (controls!=null){
                ControlPanel {content = controls }
            }

        }
    }
}


@Composable
private fun DemoArea(
    content: @Composable () -> Unit
) {
    val outline = MaterialTheme.colorScheme.outline
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 160.dp, max = 320.dp)
            .clipToBounds()
            .drawBehind {
                drawRoundRect(
                    color = outline,
                    style = Stroke(
                        width = 2.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 12f))
                    ),
                    cornerRadius = CornerRadius(12.dp.toPx())
                )
            }
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }

}

@Composable
private fun ControlPanel(
    content:(@Composable ColumnScope.() -> Unit)
) {
    Card(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp),

        content = content,
    )}
}
 