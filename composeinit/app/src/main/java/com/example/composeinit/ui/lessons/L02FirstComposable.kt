
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeinit.ui.components.BoasVindas
import com.example.composeinit.ui.lesson.LessonScaffold
import com.example.composeinit.ui.theme.ComposeinitTheme
import com.example.composeinit.ui.theme.ComposeinitTheme

private const val LONG_TEXT =
    "Compose descreve a tela em vez de manipulá-la. Este parágrafo existe para " +
            "ficar comprido o suficiente e mostrar o que acontece quando o texto não cabe."

private enum class TextStyleOption(val label: String){
    BODY(label="bodyLarge"),
    TITLE(label="titleLarge"),
    HEADLINE(label="headlineMedium")
}
@Composable
fun L02FirstComposable() {
var styleOption by remember { mutableStateOf(value = TextStyleOption.BODY) }

    LessonScaffold(
        title = "L02FirstComposable",
        notice = "Troque o estilo e veja o texto mudar de tamanho e peso junto — " +
                "é o tema decidindo, não você. Ligue 'limitar a 1 linha' para ver as " +
                "reticências do overflow.",
        controls = {
            SwitchControl(
                label = "maxLines = 1",
                checked = True,
                onCheckedChange = {}
            )
            OptionsControl(
                label = "style",
                options = TextStyleOption.entries.toList(),
                selected = {}, //onde guarda o estado
                optionLabel = {it.label},//mostra o item que vc está selecionando da lista
                onSelected = {styleOption=it} //escuta a alteração que o usuario faz

            )
        }
    ) {
        Text("DEMO L02FirstComposable")
    }
}

@Preview
@Composable
private fun L02FirstComposablePreview() {
    ComposeinitTheme(){
        L02FirstComposable()
    }
}


 