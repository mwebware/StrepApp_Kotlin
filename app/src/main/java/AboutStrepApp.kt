package com.example.android_strepapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutStrepApp(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bgimage11),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
//                .padding(bottom = 80.dp) // Space for footer
        ) {
            StrepAppHeader(navController = navController)
            About(navController = navController) // Updated to show subscription options
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
fun StrepAppHeader(navController: NavController) {
//    Row(
//        modifier = Modifier
//            .padding(top = 35.dp, start = 16.dp, end = 26.dp)
//            .fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.backicon),
//            contentDescription = "Go back",
//            modifier = Modifier
//                .size(36.dp)
//                .clickable { navController.navigate("customerSupport") }
//        )
//        Spacer(modifier = Modifier.weight(1f))
//        Text(
//            text = "About StrepApp",
//            color = Color.White,
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            textAlign = TextAlign.Center
//        )
//        Spacer(modifier = Modifier.weight(1f))
//    }

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
            text = "About StrepApp",
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun About(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .width(130.dp)
                .height(108.dp)
                .aspectRatio(1.2f),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(26.dp))
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc sagittis tellus nisl, vel tempor lacus mollis in. Nullam pretium mi risus, non fringilla odio molestie et. Vivamus et dui ut velit fermentum viverra. Ut faucibus arcu nec pharetra accumsan. Nulla malesuada metus in augue suscipit, eget ornare ex interdum. Nunc sagittis orci sollicitudin lobortis vulputate. Aenean at lectus aliquam, blandit dolor non, tincidunt mi. Suspendisse malesuada arcu sit amet libero ornare maximus. Proin ullamcorper nisl eu ipsum interdum gravida.\n" +
                    "\n" +
                    "Suspendisse sed consequat dui, id auctor est. Sed vel sodales diam. Phasellus eu tincidunt sapien. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut laoreet porttitor ante, sit amet ullamcorper arcu pulvinar et. Fusce id dolor at lectus egestas auctor. Proin rhoncus venenatis euismod. Suspendisse aliquet sit amet magna et porttitor.",
            color = Color.White,
            fontSize = 17.sp,
            lineHeight = 17.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 0.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                // Handle the submit action (save the review and rating)
            },
            modifier = Modifier.fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7F3E))
        ) {
            Text(
                text = "Refer App",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "© 2024 StrepApp. All rights reserved.",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )

    }
}

@Composable
fun StrepFooter(navController: NavController) {
    Box(
        modifier = Modifier
            .height(1000.dp)
            .width(1000.dp)
            .offset(x = 0.dp, y = 400.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.rectangle),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
                .offset(x = 0.dp, y = 400.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "Home Icon",
                modifier = Modifier
                    .size(18.dp)
                    .clickable { navController.navigate("splash") }
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Home",
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
                .offset(x = 0.dp, y = 400.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Menu Icon",
                modifier = Modifier
                    .size(18.dp)
                    .clickable { navController.navigate("menu") }
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = "Menu",
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Button(
            onClick = { navController.navigate("starttest1") },
            modifier = Modifier
                .align(Alignment.Center)
                .padding(20.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7F3E))
        ) {
            Text(
                text = "Start Test",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAboutStrepApp() {
    val mockNavController = rememberNavController()
    AboutStrepApp(navController = mockNavController)
}
