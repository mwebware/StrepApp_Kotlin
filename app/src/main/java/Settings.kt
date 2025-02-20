package com.example.android_strepapp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navController: NavController, modifier: Modifier = Modifier) {

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
            painter = painterResource(id = R.drawable.vector3),
            contentDescription = null,
            modifier = Modifier
                .size(screenWidth * 1.75f) // Adjust size based on screen width
                .offset(
                    x = 0.dp,
                    y = screenHeight * 0.230f // 15% from the top
                )
        )
        Column(modifier = Modifier.fillMaxSize()) {
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
                            .clickable { navController.navigate("menu") }
                    )
                    Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
                }

                Text(
                    text = "Settings",
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(screenHeight * 0.153f)) // Adjust spacing dynamically
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.settings2),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .width(screenWidth * 0.25f)
                        .aspectRatio(1.2f),
                    contentScale = ContentScale.Fit
                )
                Image(
                    painter = painterResource(id = R.drawable.settings3),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .width(screenWidth * 0.13f)
                        .offset(y= screenWidth * -0.175f)
                        .aspectRatio(1.2f),
                    contentScale = ContentScale.Fit
                )
            }



            Spacer(modifier = Modifier.height(screenHeight * 0.05f)) // Adjust spacing
        }
        Box(
            modifier = Modifier
                .height(1000.dp)
                .width(1000.dp)
                .offset(x = 0.dp, y = 400.dp)
        ) {
            Column(
                modifier = Modifier.padding(28.dp).offset(x = 0.dp, y = -170.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MenuItem("Change Password", R.drawable.lock) { navController.navigate("forgotPassword") }
                Divider(modifier = Modifier.height(0.5.dp).fillMaxWidth(), color = Color.Black)

                MenuItem("Manage Payment Method", R.drawable.creditcard) { /* Handle click */ }
                Divider(modifier = Modifier.height(0.5.dp), color = Color.Black)

                MenuItem("Subscription History", R.drawable.dollar) {navController.navigate("supportHistory")}
                Divider(modifier = Modifier.height(0.5.dp), color = Color.Black)

                MenuItem("Notifications", R.drawable.bell) { /* Handle click */ }
                Divider(modifier = Modifier.height(0.5.dp), color = Color.Black)

                MenuItem("Language", R.drawable.globeicon) { navController.navigate("selectLanguage") }
                Divider(modifier = Modifier.height(0.5.dp), color = Color.Black)
            }
        }
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
                            .clickable { navController.navigate("profile1") }
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

    }
}
@Composable
fun MenuItem(title: String, iconResId: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Image icon
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = "$title Icon",
            tint = Color(0xFFFF7F3E), // Apply color to the icon
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = title,
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium
        )
    }
}


