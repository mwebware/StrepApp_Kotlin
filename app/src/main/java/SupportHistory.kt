package com.example.android_strepapp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

data class Test1(val date: String, val time: String, val title: String)

// Static Test Data List
val testHistory = listOf(
    Test1("Mar 23, 2024", "08:40 PM", "Lorem Ipsum Dolor Sit Amet, Consectetur Lorem Ipsum Dolor Sit Amet, ConsecteturLorem Ipsum Dolor Sit Amet, Consectetur"),
    Test1("Feb 23, 2024", "10:53 AM", "Lorem Ipsum Dolor Sit Amet, Consectetur..."),
    Test1("Jan 23, 2024", "05:10 PM", "Lorem Ipsum Dolor Sit Amet, Consectetur..."),
    Test1("Mar 23, 2024", "08:40 PM", "Lorem Ipsum Dolor Sit Amet, Consectetur..."),
    Test1("Feb 23, 2024", "10:53 AM", "Lorem Ipsum Dolor Sit Amet, Consectetur..."),
    Test1("Jan 23, 2024", "05:10 PM", "Lorem Ipsum Dolor Sit Amet, Consectetur..."),
    Test1("Mar 23, 2024", "08:40 PM", "Lorem Ipsum Dolor Sit Amet, Consectetur..."),
    Test1("Feb 23, 2024", "10:53 AM", "Lorem Ipsum Dolor Sit Amet, Consectetur..."),
    Test1("Jan 23, 2024", "05:10 PM", "Lorem Ipsum Dolor Sit Amet, Consectetur...")
)

// Support History Screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupportHistory(navController: NavController, modifier: Modifier = Modifier) {
    var selectedTest by remember { mutableStateOf<Test1?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bgimage11),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Header Row
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
                            .clickable { navController.navigate("customerSupport") }
                    )
                    Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
                }

                Text(
                    text = "Support History",
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        // Scrollable Content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
                .verticalScroll(rememberScrollState())
        ) {
            InfoCardList(
                navigateToLogin = { navController.navigate("login") },
                onCardClick = { selectedTest = it }
            )
        }

        // Footer
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

        // Modal Dialog
        if (selectedTest != null) {
            AlertDialog(
                onDismissRequest = { selectedTest = null },
                confirmButton = {
                    TextButton(onClick = { selectedTest = null }) {
                        Text("Close", color = Color.Black)
                    }
                },
                title = {
                    Text(
                        text = "Test Details",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                text = {
                    Column {
                        Row {
                            Text(
                                text = "Title: ",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            Text(
                                text = selectedTest?.title ?: "",
                                color = Color.Black
                            )
                        }
                        Row {
                            Text(
                                text = "Date: ",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            Text(
                                text = selectedTest?.date ?: "",
                                color = Color.Black
                            )
                        }
                        Row {
                            Text(
                                text = "Time: ",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            Text(
                                text = selectedTest?.time ?: "",
                                color = Color.Black
                            )
                        }
                    }
                },
//                modifier = Modifier.background(Color(0xFFFF7F3E)) // Background color
            )
        }

    }
}

// InfoCard Component
@Composable
fun InfoCard(title: String, date: String, time: String, onViewClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD6D6FF)),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                // Title with truncation
                ClickableText(
                    text = AnnotatedString(title),
                    onClick = {},
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 1, // Limit the title to 1 line
                    overflow = TextOverflow.Ellipsis // Show ellipsis when text overflows
                )
                Spacer(modifier = Modifier.height(4.dp))
                // Date and Time
                Text(
                    text = "$date | $time",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color.Black,
                        fontSize = 12.sp
                    ),
                    overflow = TextOverflow.Ellipsis
                )
            }

            OutlinedButton(
                onClick = onViewClick,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFFFF7F3E)), // Default outlined border
                colors = ButtonDefaults.outlinedButtonColors( // Transparent background and colored content
                    containerColor = Color.Transparent, // Background transparent
                    contentColor = Color(0xFFEF7A62) // Text and border color
                ),
            ) {
                Text(text = "View", color = Color(0xFFEF7A62))
            }
        }
    }
}


// InfoCardList Composable
@Composable
fun InfoCardList(navigateToLogin: () -> Unit, onCardClick: (Test1) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        testHistory.forEach { test ->
            InfoCard(
                title = test.title,
                date = test.date,
                time = test.time,
                onViewClick = { onCardClick(test) }
            )
        }
        Spacer(modifier = Modifier.height(100.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSupportHistory() {
    val mockNavController = rememberNavController()
    SupportHistory(navController = mockNavController)
}
