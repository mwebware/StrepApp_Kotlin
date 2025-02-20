import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import java.io.File
import android.net.Uri
import com.example.android_strepapp.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.draw.clip

@Composable
fun ReviewSymptoms(navController: NavController, imageUri: String, viewModel: SymptomsViewModel) {
    // Decode the URL-encoded path
    val decodedPath = Uri.decode(imageUri)
    val context = LocalContext.current

    // State to control the expanded state of the Box
    var isExpanded by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val selectedSymptoms by viewModel.selectedSymptoms.collectAsState()
    val group1Symptoms = listOf(
        "Sore Throat",
        "Fever",
        "Headache",
        "Abdominal Pain"
    )

    val group2Symptoms = listOf(
        "Cough",
        "Congestion",
        "Runny Nose",
        "Hoarseness",
        "Conjunctivitis"
    )

    val group3Symptoms = listOf(
        "Known Recent Contact",
        "History of Tonsillectomy",
        "Antibiotics in last 48 hours?"
    )

    Box(modifier = Modifier.fillMaxSize())
    {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bgimage11),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Header Section
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
                            .clickable {
                                navController.navigate(
                                    "imagecapturestatus/${
                                        Uri.encode(
                                            imageUri
                                        )
                                    }"
                                )
                            }
                    )
                    Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
                }

                Text(
                    text = "Review",
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.height(27.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
            Box(
                modifier = Modifier
                    .width(400.dp)
                    .height(if (isExpanded) 550.dp else 270.dp) // Adjust height based on expanded state
                    .border(
                        width = 6.dp,
                        color = Color(0xCCFFFFFF),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(Color(0xCCFFFFFF), shape = RoundedCornerShape(12.dp))
                    .padding(0.dp)
            ) {
                Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(File(decodedPath))
                            .crossfade(true)
                            .build(),
                        contentDescription = "Captured Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(203.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                            .clickable { isExpanded = !isExpanded }
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Symptoms Summary",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            painter = if (isExpanded) {
                                painterResource(id = R.drawable.expandarrow) // Use the expand arrow icon when expanded
                            } else {
                                painterResource(id = R.drawable.arrow6) // Use the default arrow icon when not expanded
                            },
                            contentDescription = "Dropdown icon",
                            modifier = Modifier
                                .size(18.dp)
                                .clickable { isExpanded = !isExpanded },
                            tint = Color.Black
                        )
                    }

                    if (isExpanded) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            // Group 1
                            Column {
                                Text(
                                    text = "Group 1",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Spacer(modifier = Modifier.height(11.dp))
                                SymptomGroup(
                                    symptoms = group1Symptoms.map { symptom ->
                                        symptom to (selectedSymptoms[symptom] ?: "Null")
                                    }
                                )
                            }

                            Spacer(modifier = Modifier.height(21.dp))

                            // Group 2
                            Column {
                                Text(
                                    text = "Group 2",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Spacer(modifier = Modifier.height(11.dp))
                                SymptomGroup(
                                    symptoms = group2Symptoms.map { symptom ->
                                        symptom to (selectedSymptoms[symptom] ?: "Null")
                                    }
                                )
                            }

                            Spacer(modifier = Modifier.height(21.dp))

                            // Group 3
                            Column {
                                Text(
                                    text = "Group 3",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                                Spacer(modifier = Modifier.height(11.dp))
                                SymptomGroup(
                                    symptoms = group3Symptoms.map { symptom ->
                                        symptom to (selectedSymptoms[symptom] ?: "Null")
                                    }
                                )
                            }
                        }
                    }
                }
            }

                if (isExpanded) {
                    Spacer(modifier = Modifier.height(10.dp))
                } else {
                    Spacer(modifier = Modifier.height(24.dp))
                }
            Text(
                text = "We will use this information to diagnose strep throat",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            if (isExpanded) {
                Spacer(modifier = Modifier.height(10.dp))
            } else {
                Spacer(modifier = Modifier.height(221.dp))
            }
            Button(
                onClick = { navController.navigate("processingTestResults") },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7745)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(4.dp),
            ) {
                Text(text = "Submit", color = Color.White)
            }

            Spacer(modifier = Modifier.height(61.dp))
        }
    }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Image(
                painter = painterResource(id = R.drawable.steps_2), // Replace with your footer image resource
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()

            )
        }
    }
}

@Composable
fun SymptomGroup( symptoms: List<Pair<String, String>>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
    ) {
        Column {
                symptoms.forEachIndexed { index, symptom ->
                SymptomsRow(symptom.first, symptom.second)
                    Spacer(modifier = Modifier.height(17.dp))
                if (index < symptoms.lastIndex) {
                    Divider(color = Color(0xD1B3B3B3), thickness = 1.dp)
                }
            }
        }
    }
}
@Composable
fun SymptomsRow(symptom: String, status: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Symptom Column
        Text(
            text = symptom,
            fontSize = 15.sp,
            color = Color.Black,
            fontWeight = FontWeight.W500,
            modifier = Modifier
                .weight(6f)
        )

        // Circle Column
        Box(
            modifier = Modifier
                .weight(0.5f),// Weight to align with the table structure
//                .offset(x = 40.dp),
//                .padding(start = 35.dp), // Padding to avoid circle stretching
            contentAlignment = Alignment.Center // Ensure the circle is centered
        ) {
            Box(
                modifier = Modifier
                    .size(15.dp) // Equal width and height to make it a perfect circle
                    .clip(CircleShape)
                    .background(
                        when (status) {
                            "Yes" -> Color(0xFF9C27B0) // Purple for Yes
                            "No" -> Color(0xFFFF9800) // Orange for No
                            "Not Sure" -> Color(0xFFBDBDBD) // Gray for Not Sure
                            else -> Color.Transparent
                        }
                    )
            )
        }

        // Status Column
        Text(
            text = status,
            fontSize = 15.sp,
            color = Color.Gray,
            modifier = Modifier
                .weight(2f) // Adjust weight for status column
//                .padding(end = 12.dp)
            ,
            textAlign = TextAlign.Start // Align text to the end
        )
    }
}
