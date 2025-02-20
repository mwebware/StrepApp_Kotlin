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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(navController: NavController, modifier: Modifier = Modifier) {

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bgimage11), // Replace with your drawable resource
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Adjust the forgoticon position using percentage-based offsets
        Image(
            painter = painterResource(id = R.drawable.vector),
            contentDescription = null,
            modifier = Modifier
                .size(screenWidth * 1.5f) // Adjust size based on screen width
                .offset(
                    x = 0.dp,
                    y = screenHeight * 0.615f // 15% from the top
                )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth() // Ensures the footer spans the width of the screen
                .align(Alignment.BottomCenter) // Places it at the bottom
                .background(Color.White) // Optional: Add a background color if needed
                .padding(vertical = 10.dp) // Add some vertical padding
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Home Icon with Label
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "Home Icon",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { navController.navigate("splash") }
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Home",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Center Button
                Button(
                    onClick = { navController.navigate("starttest1") },
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7F3E))
                ) {
                    Text(
                        text = "Start Test",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Menu Icon with Label
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "Menu Icon",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { navController.navigate("menu") }
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Menu",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

           // Spacer(modifier = Modifier.height(screenHeight * 0.04f)) // Adjust spacing dynamically
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Welcome",
                fontSize = 30.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(screenHeight * 0.022f))
            Box(
                modifier = Modifier
                    .size(172.dp)
                    .background(Color.White.copy(alpha = 0.5f), CircleShape)
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profileimage1),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .background(Color.White),
                    contentScale = ContentScale.Fit
                )
            }
            Spacer(modifier = Modifier.height(screenHeight * 0.022f))

            Text(
                text = "Jane Doe",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(screenHeight * 0.016f))
            Button(
                onClick = {
                    // Navigate to login screen when clicked
                    navController.navigate("familymembers")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF7F3E)
                )
            ) {
                Text(
                    text = "Update Profile",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(screenHeight * 0.018f))
            Button(
                onClick = {
                    // Navigate to login screen when clicked
                    navController.navigate("profile2/First Name/Family Member Details/${R.drawable.profileimage1}")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF7F3E)
                )
            ) {
                Text(
                    text = "Add a Family Member",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(screenHeight * 0.03f)) // Dynamic spacing

            Image(
                painter = painterResource(id = R.drawable.forgoticon),
                contentDescription = "Forgot Icon",
                modifier = Modifier
                    .width(screenWidth * 0.25f) // 25% of screen width
                    .aspectRatio(1.2f),
                contentScale = ContentScale.Fit
            )

            Box(
                modifier = modifier
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Start Test",
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(screenHeight * 0.01f)) // Adjust spacing

                        OutlinedButton(
                            onClick = {   navController.navigate("subscription") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            border = BorderStroke(1.dp, Color(0xFFFF7F3E)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Text(
                                text = "Subscription",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFF7F3E)
                            )
//                        Spacer(modifier = Modifier.height(15.dp))
                        }


                        Spacer(modifier = Modifier.height(25.dp))
                        OutlinedButton(
                            onClick = {  navController.navigate("about") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            border = BorderStroke(1.dp, Color(0xFFFF7F3E)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Text(
                                text = "About",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFF7F3E)
                            )
//                        Spacer(modifier = Modifier.height(15.dp))
                        }


                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "© 2024 StrepApp. All rights reserved.",
                            modifier = Modifier,
                            fontSize = 14.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )


//                        Spacer(modifier = Modifier.height(60.dp))

                }
            }
        }
    }
}
