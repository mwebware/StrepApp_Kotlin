import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_strepapp.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import java.time.format.TextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HowToUse3(navController: NavController, modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.howtouse3), // Replace with your drawable resource
            contentDescription = null,
            contentScale = ContentScale.Crop, // Ensure the image fills the box
            modifier = Modifier.fillMaxSize() // Cover the entire box
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Image(
                painter = painterResource(id = R.drawable.rectangle56), // Replace with your footer image resource
                contentDescription = null,
                modifier = Modifier
                    .width(440.dp)
                    .height(342.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp), // Add top padding
                contentAlignment = Alignment.TopCenter // Align content at the top center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 36.dp, end = 36.dp),
                    horizontalAlignment = Alignment.CenterHorizontally // Center the content horizontally
                ) {
                    Text(
                        text = "Step 3",
                        modifier = Modifier.clickable { },
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(15.dp)) // Add spacing between the two texts
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt",
                        fontSize = 18.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        style = androidx.compose.ui.text.TextStyle(
                            lineHeight = 21.sp // Set line height to 21
                        )
                    )
                    Spacer(modifier = Modifier.height(36.dp))
                    Button(
                        onClick = {
                            navController.navigate("howToUse4")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF7F3E)
                        ),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            text = "Next",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Image(
                        painter = painterResource(id = R.drawable.dots3), // Replace with your footer image resource
                        contentDescription = null,
                        modifier = Modifier
                            .width(94.dp)
                            .height(12.dp)
                    )
                }
            }
        }


    }
}