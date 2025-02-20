package com.example.android_strepapp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import android.net.Uri

data class TestDetails(
    val id: String,
    val date: String,
    val time: String,
    val status: String
)

@Composable
fun TestHistory(name: String, details: String, imageRes: Int, navController: NavController, modifier: Modifier = Modifier) {
    val testHistory = listOf(
        TestDetails("123456", "Jan 23, 2024", "10:30 AM", "Low Risk"),
        TestDetails("234567", "Apr 2, 2024", "5:00 PM", "At Risk"),
        TestDetails("123456", "Jan 23, 2024", "10:30 AM", "Low Risk"),
        TestDetails("234567", "Apr 2, 2024", "5:00 PM", "At Risk"),
        TestDetails("345678", "Aug 15, 2024", "9:50 AM", "Low Risk")
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bgimage11),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize() // Ensures the Box takes the full screen space
        ) {
            Image(
                painter = painterResource(id = R.drawable.bgimage11), // Replace with your drawable resource
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Footer Content
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


        Column(
            modifier = Modifier.fillMaxSize()
        ) {
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
                            .clickable { navController.navigate("profile1") }
                    )
                    Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
                }

                Text(
                    text = "Test History",
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 31.dp, bottom = 20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(170.dp)
                        .background(Color.White, CircleShape)
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(imageRes),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(150.dp)
                            .background(Color.Gray, CircleShape)
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(11.dp))

                Text(
                    text = details,
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedButton(
                    onClick = { },
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.padding(8.dp),
                    border = BorderStroke(1.dp, Color.White)
                ) {
                    Text(
                        text = "My Reviews",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 50.dp)
                ) {
                    items(testHistory) { test ->
                        TestHistoryCard(
                            test = test,
                            onCardClick = { selectedTest ->
                                val testData = Uri.encode("${selectedTest.id}||${selectedTest.date}||${selectedTest.time}||${selectedTest.status}")
                                navController.navigate("testhistory2/$testData")
                            }
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun TestHistoryCard(
    test: TestDetails,
    onCardClick: (TestDetails) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(255, 255, 255, 204), RoundedCornerShape(8.dp))
            .padding(13.dp)
            .clickable { onCardClick(test) }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Date",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Time",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Status",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = test.date,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = test.time,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = test.status,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = if (test.status == "At Risk") Color.Red else Color.Green,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
