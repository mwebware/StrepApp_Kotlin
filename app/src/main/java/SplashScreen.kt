import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.android_strepapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, modifier: Modifier = Modifier) {
    // Trigger navigation after 10 seconds
    LaunchedEffect(Unit) {
        delay(2_000) // 10 seconds
        navController.navigate("selectLanguage") // Replace "login" with your login screen route
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bgimage11),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        // Logo in the center
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center // Center alignment
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Group",
                modifier = Modifier
                    .size(252.dp)
            )
        }
    }
}
