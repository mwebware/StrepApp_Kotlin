import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_strepapp.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectLanguage(navController: NavController, modifier: Modifier = Modifier) {
    var selectedLanguage by remember { mutableStateOf("Select Language") }
    var expanded by remember { mutableStateOf(false) }

    val languages = listOf("English", "Spanish", "French", "German", "Chinese")

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bgimage11), // Replace with your drawable resource
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Adjust the forgoticon position using percentage-based offsets
        Image(
            painter = painterResource(id = R.drawable.vector),
            contentDescription = null,
            modifier = Modifier
                .size(screenWidth * 1.5f) // Adjust size based on screen width
                .offset(
                    x = 0.dp,
                    y = screenHeight * 0.345f // 15% from the top
                )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(screenHeight * 0.05f)) // Adjust spacing dynamically

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(screenWidth * 0.4f) // 40% of screen width
                    .aspectRatio(1.2f),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(screenHeight * 0.061f)) // Dynamic spacing

            Image(
                painter = painterResource(id = R.drawable.forgoticon),
                contentDescription = "Forgot Icon",
                modifier = Modifier
                    .width(screenWidth * 0.26f) // 25% of screen width
                    .aspectRatio(1.2f),
                contentScale = ContentScale.Fit
            )

            Box(
                modifier = modifier
            ) {
                Column(
                    modifier = Modifier.padding(screenHeight * 0.01f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Select Language",
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(screenHeight * 0.05f)) // Adjust spacing

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { expanded = true }
                    ) {
                        OutlinedTextField(
                            value = selectedLanguage,
                            onValueChange = { },
                            shape = RoundedCornerShape(6.dp),
                            modifier = Modifier.fillMaxWidth()
                                .height(screenHeight * 0.06f),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.globe),
                                    contentDescription = "Globe icon",
                                    modifier = Modifier.size(24.dp),
                                    tint = Color(0xFFFF7F3E)
                                )
                            },
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.arrow6),
                                    contentDescription = "Dropdown icon",
                                    modifier = Modifier.size(screenHeight * 0.018f),
                                    tint = Color.Black
                                )
                            },
                            enabled = false,
                            placeholder = {
                                Text(
                                    text = "Select Language",
                                    color = Color.Black
                                )
                            },
                            textStyle = TextStyle(color = Color.Black),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color.White,
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent
                            )
                        )

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier.background(Color.White)
                        ) {
                            languages.forEach { language ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectedLanguage = language
                                        expanded = false
                                    },
                                    text = { Text(language) }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(screenHeight * 0.03f)) // Adjust spacing

                    Button(
                        onClick = {
                            navController.navigate("login1")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(screenHeight * 0.06f), // Button height based on screen height
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF7F3E)
                        )
                    ) {
                        Text(
                            text = "Submit",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(screenHeight * 0.05f)) // Adjust spacing
                }
            }
        }
    }
}
