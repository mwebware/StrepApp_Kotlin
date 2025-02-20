package com.example.android_strepapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.android_strepapp.R

// Define the doctor data class
data class Doctor(val name: String, val address: String, val imageRes: Int)

val doctorList = listOf(
    Doctor("Dr. Anthony Rodriguez", "3114 Maple Street, NY 10003, USA", R.drawable.doctor),
    Doctor("Dr. Charles Conger", "1308 Calvin Street, NY 10003, USA", R.drawable.doctor2),
    Doctor("Dr. Anthony Rodriguez", "3114 Maple Street, NY 10003, USA", R.drawable.doctor),
    Doctor("Dr. Charles Conger", "1308 Calvin Street, NY 10003, USA", R.drawable.doctor2),
    Doctor("Dr. Stuart Willis", "3995 Sussex Court, NY 10003, USA", R.drawable.sample1),

)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConsultPhysician(navController: NavController) {
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
            Header(navController = navController)
            Spacer(modifier = Modifier.height(26.dp))
            DoctorList(navController = navController)
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
fun Header(navController: NavController) {
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
                    .clickable { navController.navigate("finalTestResults") }
            )
            Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
        }

        Text(
            text = "Consult a Physician",
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}




@Composable
fun DoctorCard(
    doctor: Doctor,
    onScheduleClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 15.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xCCFFFFFF)) // Light blue background
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Doctor image
                Image(
                    painter = painterResource(id = doctor.imageRes),
                    contentDescription = "Doctor Image",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color(0xFFB0BEC5), CircleShape) // Gray border
                )
                Spacer(modifier = Modifier.width(16.dp))

                // Doctor name and address
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = doctor.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = doctor.address,
                        fontSize = 14.sp,
                        color = Color.Black,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(
                onClick = onScheduleClick,
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFFFF7F3E)),

            ) {
                Text(
                    text = "Schedule Appointment",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF7F3E)
                )
            }
        }
    }
}

@Composable
fun DoctorList(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        doctorList.forEach { doctor ->
            DoctorCard(
                doctor = doctor,
                onScheduleClick = {
                    // Handle scheduling action
                }
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConsultPhysician() {
    val mockNavController = rememberNavController()
    ConsultPhysician(navController = mockNavController)
}

