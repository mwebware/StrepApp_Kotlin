package com.example.android_strepapp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
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

// Data class for reviews with profileImage field
data class Review(
    val name: String,
    val date: String,
    val time: String,
    val rating: Int,
    val reviewText: String,
    val profileImage: Int // Added profileImage field for dynamic profile picture
)

// Sample list of reviews with different profile images
val reviewList = listOf(
    Review(
        "Antonio Baker",
        "Sep 5, 2024",
        "10:40 pm",
        4,
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        R.drawable.review2 // Unique image for Antonio
    ),
    Review(
        "Jonathan N. Hernandez",
        "Apr 22, 2024",
        "09:22 am",
        4,
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        R.drawable.review1 // Unique image for Jonathan
    ),
    Review(
        "Joel M. Perez",
        "Sep 5, 2024",
        "10:40 pm",
        3,
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        R.drawable.doctor2 // Unique image for Joel
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowReview(navController: NavController) {
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
            ShowReviewHeader(navController = navController)
            ShowReviewSection()  // Section for dynamically displaying reviews
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
    }
}

@Composable
fun ShowReviewHeader(navController: NavController) {
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
                    .clickable { navController.navigate("addReview") }
            )
            Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
        }

        Text(
            text = "Reviews",
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun ShowReviewFooter(navController: NavController) {
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

        // Home and Menu icons with labels
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
                    .clickable { navController.navigate("profile1") }
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

@Composable
fun ShowReviewSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Iterate over the reviewList and display each ReviewCard
        reviewList.forEach { review ->
            ReviewCard(
                name = review.name,
                date = review.date,
                time = review.time,
                rating = review.rating,
                review = review.reviewText,
                profileImage = review.profileImage // Pass the dynamic profile image
            )
            Spacer(modifier = Modifier.height(16.dp)) // Add space between reviews
        }
        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Composable
fun ReviewCard(
    name: String,
    date: String,
    time: String,
    rating: Int,
    review: String,
    profileImage: Int // Add the profileImage parameter here
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xCCFFFFFF)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "$date | $time",
                fontSize = 14.sp,
                color = Color.Black
            )
            Text(
                text = "\"$review\"",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Use the dynamic profile image here
                Image(
                    painter = painterResource(id = profileImage), // Dynamically set the profile image
                    contentDescription = "Profile picture of $name",
                    modifier = Modifier
                        .size(72.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row {
                            repeat(5) { index ->
                                Icon(
                                    painter = painterResource(
                                        id = if (index < rating) R.drawable.filled_star
                                        else R.drawable.outlined_star
                                    ),
                                    contentDescription = null,
                                    modifier = Modifier.size(23.dp),
                                    tint = if (index < rating) Color(0xFFFF7F3E)
                                    else Color.Gray
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShowReview() {
    val mockNavController = rememberNavController()
    ShowReview(navController = mockNavController)
}
