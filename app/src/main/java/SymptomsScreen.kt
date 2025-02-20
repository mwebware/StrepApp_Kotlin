package com.example.android_strepapp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // for paddings, etc.
import androidx.compose.material3.* // Use Material 3 elements
import androidx.compose.runtime.* // for state management
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.LazyColumn // Import LazyColumn
import androidx.compose.foundation.lazy.items // Import items
import androidx.compose.foundation.shape.RoundedCornerShape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SymptomsScreen(navController: NavController) {
    // List of symptoms
    val symptoms = listOf(
        "Cough", "Stuffy nose", "Runny nose", "Change in voice", "Pink eye", "Sore throat",
        "Fever with Temp > 100.4 F or 38 C", "Headache", "Abdominal Pain",
        "Difficulty Swallowing", "Cervical Lymph Nodes",
        "In the past week, have you been around anyone diagnosed with strep throat?"
    )

    var showToast by remember { mutableStateOf(false) }
    var toastMessage by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Symptoms") },
                actions = {
                    TextButton(onClick = { navController.popBackStack() }) { // Back button
                        Text("Back")
                    }
//                    TextButton(onClick = {
//                        // Attempt to navigate
//                        try {
//                            navController.navigate("imageCapture")
//                        } catch (e: Exception) {
//                            // Update the message and trigger toast
//                            toastMessage = "Navigation failed: ${e.message}"
//                            showToast = true
//                        }
//                    }) {
//                        Text("Done")
//                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Handles scaffold padding
                .padding(8.dp)
        ) {
            // Add the new text above the symptoms list
            Text(
                text = "Have you noticed any of these symptoms in the past week?",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 16.dp)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            // Use LazyColumn for a scrollable list
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.weight(1f) // Allow LazyColumn to take available space
            ) {
                items(symptoms) { symptom ->
                    SymptomRow(symptomName = symptom)
                }
            }

            // Add the Continue button after the symptoms list
            Button(
                onClick = {
                    // Action to perform when "Continue" is clicked
                    navController.navigate("imageCapture") // Change "nextScreen" to your desired route
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(48.dp), // Optional height for the button
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)

            ) {
                Text(text = "Continue", fontSize = 16.sp, color = Color.Black, fontWeight = FontWeight.Bold)
            }
        }
    }

    // Show Toast if needed
    if (showToast) {
        val context = LocalContext.current
        LaunchedEffect(toastMessage) {
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
            // Reset state after showing the toast
            showToast = false
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SymptomRow(symptomName: String) {
    // Holds the current selected option for the symptom; null means no selection
    var selectedOption by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        // Symptom name
        Text(
            text = symptomName,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        // Yes/No buttons with 50% border radius on Yes start and No end
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf("Yes", "No").forEachIndexed { index, option ->
                OutlinedButton(
                    onClick = { selectedOption = option },
                    shape = when (index) {
                        0 -> RoundedCornerShape(topStartPercent = 50, bottomStartPercent = 50) // Fully rounded start for "Yes"
                        else -> RoundedCornerShape(topEndPercent = 50, bottomEndPercent = 50)   // Fully rounded end for "No"
                    },
                    border = ButtonDefaults.outlinedButtonBorder.copy(width = 2.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (selectedOption == option) Color(0xFFFFA500) else Color.Transparent,
                        contentColor = if (selectedOption == option) Color.White else Color.Black // Text color based on selection
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Text(
                        text = option
                    )
                }
            }

        }

    }
}
