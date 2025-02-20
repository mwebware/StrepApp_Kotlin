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
fun Subscription(navController: NavController) {
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
                .padding(bottom = 80.dp) // Space for footer
        ) {
            SubscriptionHeader(navController = navController)
            SubscriptionOptions(navController = navController)
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.White)
                .padding(vertical = 10.dp)
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
fun SubscriptionHeader(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 35.dp, bottom = 16.dp),
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
        }

        Text(
            text = "Subscription",
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun SubscriptionOptions(navController: NavController) {
    var testPackCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SubscriptionHeaderBox(testPackCount)

        Spacer(modifier = Modifier.height(50.dp))
        Divider(
            modifier = Modifier
                .height(1.dp),
            color = Color.White
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Buy Subscription",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 26.dp)
        )

        SubscriptionCard("$10", "1 Test Pack") {
            navController.navigate("buySubscription/$10/1 Test Pack")
        }
        SubscriptionCard("$90", "10 Test Pack") {
            navController.navigate("buySubscription/$90/10 Test Pack")
        }
        SubscriptionCard("$200", "25 Test Pack") {
            navController.navigate("buySubscription/$200/25 Test Pack")
        }
    }
}

@Composable
fun SubscriptionHeaderBox(testPackCount: Int) {
    val backgroundColor = if (testPackCount == 0) {
        Color(0xFFFFF7DD)
    } else {
        Color(0xFFC1FFD1)
    }
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            val text = if (testPackCount == 0) {
                "Currently you have no subscription.\nPlease select from the options below."
            } else {
                "You have $testPackCount Test Pack Subscription."
            }
            Text(
                text = text,
                color = if (testPackCount == 0) Color.Red else Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun SubscriptionCard(price: String, description: String, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xCCFFFFFF))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = price,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    color = Color(0xFF007AFF),
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = description,
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Spacer(modifier = Modifier.weight(1f))

                OutlinedButton(
                    onClick = onClick,
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFFFF7F3E))
                ) {
                    Text(
                        text = "Buy",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFFF7F3E)
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}


@Composable
fun Footer(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Footer content
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSubscription() {
    val mockNavController = rememberNavController()
    Subscription(navController = mockNavController)
}