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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.android_strepapp.R

@Composable
fun ImageCapture(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bgimage11),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Floating Steps Image


        // Main Content
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
                            .clickable { navController.navigate("symptoms3") }
                    )
                    Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
                }

                Text(
                    text = "Image Capture",
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Instructions Text
                Text(
                    text = "For an acquire strep test, we require a clear picture of the back of the mouth.\n\n" +
                            "Please make sure the picture shows uvula, tonsils, and back of the throat (pharynx).",
                    color = Color.White,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Watch Tutorial Button
                Button(
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7745)),
                    modifier = Modifier.fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Text(text = "Watch Tutorial", color = Color.White)
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Image Placeholder

                Box(
                    modifier = Modifier
                        .width(370.dp)
                        .height(313.dp)
                        .border(
                            width = 6.dp, // Border width
                            color = Color.White, // Border color
                            shape = RoundedCornerShape(12.dp) // Rounded corners for the border
                        )
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(12.dp)
                        ) // Background with rounded corners
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mouth),
                        contentDescription = "Mouth Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Take Picture Button
                Button(
                    onClick = { navController.navigate("imagecapture2") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7745)),
                    modifier = Modifier.fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Text(text = "Take Picture", color = Color.White)
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
