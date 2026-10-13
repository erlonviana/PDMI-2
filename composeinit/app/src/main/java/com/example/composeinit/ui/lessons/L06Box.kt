package com.example.composeinit.ui.lessons

import android.R.attr.label
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.enuns.BoxAligmentOption
import com.example.composeinit.ui.lesson.LessonScaffold
import com.example.composeinit.ui.lesson.OptionsControl
import com.example.composeinit.ui.theme.ComposeInitTheme

@Composable
fun L06Box(modifier: Modifer = Modifier) {
    var Alignment by remember(mutableStateOf(value = BoxAligmentOption.CENTER)) { }
    LessonScaffold(
        title = "Box",
        notice = "content Aligment",
        controls = {
            OptionsControl((
                    label = "ContentAligment",
                    options = BoxAligmentOption.entries.toList(),
                    selected = aligment,
                {it.label},
                {aligment = it}
                    ))

        }
    ) {
        BOX(
            modifier = Modifier
                .size(160.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentAligment = alignment.value
        ){
            Text(text="FRENTE") //o texto fica na frente da box
        }
    }
}

@Preview

@Composable
private fun L06BoxPreview(){
    ComposeInitTheme() {
        L06Box()
    }
}