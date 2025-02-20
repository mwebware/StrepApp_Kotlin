import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavController
import com.example.android_strepapp.R

@Composable
fun InfoPopup(
    message: String,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(186.dp)
            .height(100.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = message,
            color = Color.Black,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun Symptoms3(navController: NavController,
              viewModel: SymptomsViewModel,
              modifier: Modifier = Modifier) {
    // Define symptoms with their corresponding info messages
    val symptomsInfo = listOf(
        Pair("Known Recent Contact", "Has the patient been in contact with someone diagnosed with strep throat in the past 2 weeks?"),
        Pair("History of Tonsillectomy", "Has the patient previously had their tonsils surgically removed?"),
        Pair("Antibiotics in last 48 hours?", "Has the patient taken any antibiotics in the last 48 hours that might affect test results?")
    )

    val selectedSymptoms by viewModel.selectedSymptoms.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Rest of your existing Box content remains the same until LazyColumn
        Image(
            painter = painterResource(id = R.drawable.bgimage11),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp)
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
                            .clickable { navController.navigate("symptoms2") }
                    )
                    Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
                }

                Text(
                    text = "Symptoms",
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Group 3 of 3",
                color = Color.LightGray,
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight(0.85f)
                    .padding(horizontal = 16.dp)
            ) {
                items(symptomsInfo) { (symptom, info) ->
                    SymptomItem3(
                        symptom = symptom,
                        infoMessage = info,
                        selectedOption = selectedSymptoms[symptom] ?: "",
                        onOptionSelected = { option -> viewModel.updateSymptom(symptom, option) }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            // Navigation buttons
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .offset(x = 0.dp, y = -25.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = { navController.navigate("symptoms2") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6A37)),
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                    ) {
                        Text(text = "Back", color = Color.White, fontSize = 18.sp)
                    }

                    Button(
                        onClick = { navController.navigate("imagecapture") },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6A37)),
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp)
                    ) {
                        Text(text = "Next", color = Color.White, fontSize = 18.sp)
                    }
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Image(
                painter = painterResource(id = R.drawable.steps),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun SymptomItem3(
    symptom: String,
    infoMessage: String,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var showInfoPopup by remember { mutableStateOf(false) }
    var infoIconPosition by remember { mutableStateOf(0f) }
    val density = LocalDensity.current

    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = Color(0xCCFFFFFF)),
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xCCFFFFFF))
                .fillMaxSize() // Optional, based on your layout needs
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = symptom,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.info),
                            contentDescription = "Information",
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp)
                                .clickable { showInfoPopup = !showInfoPopup }
                                .onGloballyPositioned { coordinates ->
                                    infoIconPosition = with(density) {
                                        coordinates.size.height.toDp().value
                                    }
                                }
                        )

                        if (showInfoPopup) {
                            Popup(
                                onDismissRequest = { showInfoPopup = false },
                                properties = PopupProperties(focusable = true),
                                alignment = Alignment.TopEnd
                            ) {
                                Box(
                                    modifier = Modifier
                                        .padding(top = infoIconPosition.dp)
                                ) {
                                    InfoPopup(
                                        message = infoMessage,
                                        onDismiss = { showInfoPopup = false }
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    RadioButtonWithText("Yes", selectedOption, Color(0xFF7E57C2), onOptionSelected)
                    RadioButtonWithText("No", selectedOption, Color(0xFFFFA726), onOptionSelected)
                    RadioButtonWithText("Not Sure", selectedOption, Color.Gray, onOptionSelected)
                }
            }
        }
    }
}