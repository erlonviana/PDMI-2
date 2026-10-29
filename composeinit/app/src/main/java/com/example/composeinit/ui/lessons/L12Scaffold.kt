package com.example.composeinit.ui.lessons

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.ui.lesson.LessonScaffold
import com.example.composeinit.ui.lesson.SwitchControl
import com.example.composeinit.ui.theme.ComposeInitTheme


@Composable
fun L12Scaffold(modifier: Modifier = Modifier){
    var showFab by remember { mutableStateOf(value = True) }
    var showBottomBar by remember { mutableStateOf(value = True) }
    var ignoreInnerPadding by remember { mutableStateOf(value = True) }

    LessonScaffold(
        title = "Scaffold",
        notice = "Ligue e desligue o FAB e a barra de baixo. Depois ligue 'ignorar " +
                "innerPadding' e veja o conteúdo escorregar para trás da barra de cima.",
        controls = {
            SwitchControl(
                label = "Mostrar FAB",
                checked = showFab,
                onCheckedChange = {showFab = it}
            )

            SwitchControl(
                label = "Mostrar barra baixo",
                checked = showBottomBar,
                onCheckedChange = {showBottomBar = it}
            )

            SwitchControl(
                label = "Ignorar inner padding",
                checked = ignoreInnerPadding,
                onCheckedChange = {ignoreInnerPadding = it}
            )
        }

        ) {
            ScaffoldDemo(
                showFab = showFab,
                showBottomBar = showBottomBar,
                showInnerPadding
            )
    }


}

@Composable
fun ScaffoldDemo(
    showFab: Boolean,
    showBottomBar: Boolean,
    ignoreInnerPadding: Boolean
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface),
        topBar = {
            TopAppBar(
                title = Text(text = "minha tela")

            )
        },
        bottomBar = {
            //regras de visualização
            if (showBottomBar){
                BottomAppBar(

                ) {
                    Text(text = "barra de baixo)
                }
            }else{}

        },
        floatingActionButton = {
            if(showFab) {FloatingActionButton(
                onClick = {}
            ){
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Adicionar")
            }
            }
        }
    ) {innerPadding ->
                        val conteudoModifier = if(ignoreInnerPadding){
                            Modifier.fillMaxSize()
                        } else {
                            Modifier
                                .fillMaxWidth()
                                .padding(paddingValues = innerPadding)
                        }

    }
}

@Preview
@Composable
private fun L12ScaffoldPreview (

){
    ComposeInitTheme {
        L12Scaffold()
    }
}