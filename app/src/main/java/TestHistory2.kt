import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.core.content.FileProvider
import com.example.android_strepapp.MainActivity
import com.example.android_strepapp.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

@Composable
fun TestHistory2(navController: NavController, testData: String?, context: Context) {
    val (id, date, time, status) = testData?.split("||") ?: listOf("", "", "", "")
    val scrollState = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bgimage11),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
//                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
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
                            .clickable { navController.navigateUp() }
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
            // Main content box
            Box(
                modifier = Modifier
                    .width(400.dp)
                    .height(750.dp)
                    .border(
                        width = 0.dp,
                        color = Color(0xCCFFFFFF),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(Color(0xCCFFFFFF), shape = RoundedCornerShape(12.dp))
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    // Test Details Header
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = RoundedCornerShape(12.dp))
                            .padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Row {
                                    Text("Test ID:")
                                    Text(id, fontWeight = FontWeight.Bold)
                                }
                                Row {
                                    Text("Date:")
                                    Text(date, fontWeight = FontWeight.Bold)
                                }
                                Row {
                                    Text("Time:")
                                    Text(time, fontWeight = FontWeight.Bold)
                                }
                            }

                            Column(
                                horizontalAlignment = Alignment.Start
                            ) {
                                Row {
                                    Text("Status:")
                                }
                                Row {
                                    Text(
                                        text = status,
                                        color = if (status == "At Risk") Color.Red else Color.Green,
                                        fontWeight = FontWeight.W700
                                    )
                                }
                                Row {
                                    OutlinedButton(
                                        onClick = { shareScreenAsImage(context) },
                                        shape = RoundedCornerShape(8.dp),
                                        border = BorderStroke(1.dp, Color(0xFFFF7F3E)),
                                        colors = ButtonDefaults.outlinedButtonColors(
                                            containerColor = Color.Transparent,
                                            contentColor = Color(0xFFEF7A62)
                                        ),
                                        modifier = Modifier
                                    ) {
                                        Text(text = "Share", color = Color(0xFFEF7A62))
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Mouth Image
                    Image(
                        painter = painterResource(id = R.drawable.mouth),
                        contentDescription = "Throat Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(203.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
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
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    // Display symptom groups
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Column {
                            Text(
                                text = "Group 1",
                                color = Color.Black,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Spacer(modifier = Modifier.height(11.dp))
                            SymptomGroup1(
                                symptoms = listOf(
                                    "Sore Throat" to "Yes",
                                    "Fever" to "No",
                                    "Headache" to "Yes",
                                    "Abdominal Pain" to "Not Sure",
                                    "Difficulty Swallowing" to "Yes"
                                )
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
                            SymptomGroup1(
                                symptoms = listOf(
                                    "Cough" to "Yes",
                                    "Congestion" to "No",
                                    "Runny Nose" to "Yes",
                                    "Hoarseness" to "Not Sure",
                                    "Conjunctivitis" to "No"
                                )
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
                            SymptomGroup1(
                                symptoms = listOf(
                                    "Known Recent Contact" to "Not Sure",
                                    "History of Tonsillectomy" to "No",
                                    "Antibiotics in last 48 hours?" to "Yes"
                                )
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(61.dp))
        }
    }
    }
}

@Composable
fun SymptomGroup1(symptoms: List<Pair<String, String>>) {
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
                SymptomsRow1(symptom.first, symptom.second)
                Spacer(modifier = Modifier.height(17.dp))
                if (index < symptoms.lastIndex) {
                    Divider(color = Color(0xD1B3B3B3), thickness = 1.dp)
                }
            }
        }
    }
}

@Composable
fun SymptomsRow1(symptom: String, status: String) {
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
                .weight(0.5f), // Weight to align with the table structure
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
            ,
            textAlign = TextAlign.Start // Align text to the end
        )
    }
}

fun shareScreenAsImage(context: Context) {
    // Step 1: Capture the composable screen as a bitmap
    val bitmap = captureScreenAsBitmap(context)

    // Step 2: Save the bitmap to a temporary file
    try {
        val file = File(context.cacheDir, "shared_image.png")
        FileOutputStream(file).use { out ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
        }

        // Step 3: Share the image using an Intent
        val uri = FileProvider.getUriForFile(context, "com.example.android_strepapp.fileprovider", file)
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "image/png"
            putExtra(Intent.EXTRA_STREAM, uri)
        }
        context.startActivity(Intent.createChooser(intent, "Share Image"))
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

fun captureScreenAsBitmap(context: Context): Bitmap {
    val rootView = (context as MainActivity).window.decorView.findViewById<View>(android.R.id.content)
    val scrollableHeight = rootView.height + rootView.scrollY
    val bitmap = Bitmap.createBitmap(rootView.width, scrollableHeight, Bitmap.Config.ARGB_8888)
    val canvas = android.graphics.Canvas(bitmap)
    rootView.draw(canvas)
    return bitmap
}
