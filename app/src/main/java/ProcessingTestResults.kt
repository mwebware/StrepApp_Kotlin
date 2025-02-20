import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.graphicsLayer
import androidx.navigation.NavController
import com.example.android_strepapp.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun ProcessingTestResults(navController: NavController, modifier: Modifier = Modifier) {
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(5000) // 5-second delay
        navController.navigate("finalTestResults") // Replace with your actual destination
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bgimage11),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(27.dp))

            // Header Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Processing Test Results",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            // Central Content Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 68.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Logo
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .width(130.dp)
                        .height(108.dp)
                        .aspectRatio(1.2f),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(49.dp))

                // Heading Text
                Text(
                    text = "You're Almost Done",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(26.dp))

                // Rotating Loader
                RotatingLoader()

                Spacer(modifier = Modifier.height(14.dp))

                // Loading Text
                Text(
                    text = "Please Wait...",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W400,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(61.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Image(
                painter = painterResource(id = R.drawable.steps_3), // Replace with your footer image resource
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()

            )
        }
    }
}

@Composable
fun RotatingLoader() {
    // Create an infinite rotation animation using remember and animate
    var currentRotation by remember { mutableStateOf(0f) }

    LaunchedEffect(Unit) {
        // Infinite animation loop
        while(true) {
            animate(
                initialValue = currentRotation,
                targetValue = currentRotation + 360f,
                animationSpec = tween(
                    durationMillis = 2000,
                    easing = LinearEasing
                )
            ) { value, _ ->
                currentRotation = value
            }
        }
    }

    Image(
        painter = painterResource(id = R.drawable.loader),
        contentDescription = "Loader",
        modifier = Modifier
            .width(48.dp)
            .height(48.dp)
            .graphicsLayer(rotationZ = currentRotation)
            .aspectRatio(1.2f),
        contentScale = ContentScale.Fit
    )
}
