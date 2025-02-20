import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.android_strepapp.R
import coil.compose.rememberImagePainter
import java.io.File
import android.net.Uri
import coil.compose.AsyncImage
import coil.request.ImageRequest

// Modify your ImageCaptureStatus composable to handle the file path:
@Composable
fun ImageCaptureStatus(navController: NavController, imageUri: String) {
    // Decode the URL-encoded path
    val decodedPath = Uri.decode(imageUri)
    val context = LocalContext.current

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
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            // Header Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.backicon),
                        contentDescription = "Go back",
                        modifier = Modifier
                            .size(36.dp)
                            .clickable { navController.navigate("imagecapture2") }
                    )
                    Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
                }

                Text(
                    text = "Image Capture Status",
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(27.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.SpaceBetween
            ) {
            Box(
                modifier = Modifier
                    .width(400.dp)
                    .height(529.dp)
                    .border(
                        width = 6.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
                    .padding(6.dp)
            ) {
                // Use AsyncImage instead of Image with rememberImagePainter
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(File(decodedPath))
                        .crossfade(true)
                        .build(),
                    contentDescription = "Captured Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(449.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Picture taken successfully",
                        color = Color(0xFF34C759),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(modifier = Modifier.height(23.dp))
            Button(
                onClick = { navController.navigate("reviewsymptoms/${Uri.encode(imageUri)}") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7745)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(4.dp),
            ) {
                Text(text = "Next", color = Color.White)
            }

            Spacer(modifier = Modifier.height(61.dp))
        }
    }
        Box(
            modifier = Modifier
                .fillMaxWidth()

                .align(Alignment.BottomCenter)
        ) {
            Image(
                painter = painterResource(id = R.drawable.steps_2), // Replace with your footer image resource
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}