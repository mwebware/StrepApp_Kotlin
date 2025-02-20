import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
class Theme
{
}


private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFF7F3E),
    background = Color(0xFF5EA6D1)
)

@Composable
fun TermsAndConditionsTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}