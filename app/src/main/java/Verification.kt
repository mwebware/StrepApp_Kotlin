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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Verification(navController: NavController, modifier: Modifier = Modifier) {
    var field1 by remember { mutableStateOf("") }
    var field2 by remember { mutableStateOf("") }
    var field3 by remember { mutableStateOf("") }
    var field4 by remember { mutableStateOf("") }

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
                painter = painterResource(id = R.drawable.verify),
                contentDescription = "Verify Icon",
                modifier = Modifier
                    .width(screenWidth * 0.26f) // 25% of screen width
                    .aspectRatio(1.2f),
                contentScale = ContentScale.Fit
            )

            Box(
                modifier = modifier
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Verification",
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(screenHeight * 0.01f)) // Adjust spacing

                    Text(
                        text = "Please enter the verification code sent to your registered email address below.",
                        modifier = Modifier
                            .fillMaxWidth() // Ensure text takes the full width for proper alignment
//                            .padding(horizontal = 16.dp) // Optional: Add padding for better appearance
                            .offset(x = 0.dp, y = 20.dp)
                            .clickable {
                                // Navigate to the login page
                                navController.navigate("login")
                            },
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center // Centers the text on both lines
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
//                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedTextField(
                            value = field1,
                            onValueChange = { newValue ->
                                // Only allow a single character and ensure it is a digit
                                if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                                    field1 = newValue
                                }
                            },

                            label = { Text("") },
                            modifier = Modifier
                                .weight(1f)
//                                .padding(horizontal = 4.dp)
                                .height(40.dp),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number // Opens numeric keyboard
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color.White,
                            )
                        )
                        OutlinedTextField(
                            value = field2,
                            onValueChange = { newValue ->
                                // Only allow a single character and ensure it is a digit
                                if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                                    field2 = newValue
                                }
                            },
                            label = { Text("") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 4.dp)
                                .height(40.dp),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number // Opens numeric keyboard
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color.White,
                            )
                        )
                        OutlinedTextField(
                            value = field3,
                            onValueChange = { newValue ->
                                // Only allow a single character and ensure it is a digit
                                if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                                    field3 = newValue
                                }
                            },
                            label = { Text("") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 4.dp)
                                .height(40.dp),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number // Opens numeric keyboard
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color.White,
                            )
                        )
                        OutlinedTextField(
                            value = field4,
                            onValueChange = { newValue ->
                                // Only allow a single character and ensure it is a digit
                                if (newValue.length <= 1 && newValue.all { it.isDigit() }) {
                                    field4 = newValue
                                }
                            },
                            label = { Text("") },
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 4.dp)
                                .height(40.dp),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number // Opens numeric keyboard
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color.White,
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            // Navigate to login screen when clicked
                            navController.navigate("resetPassword")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(x = 0.dp,
                                y = 40.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF7F3E)
                        )
                    ) {
                        Text(
                            text = "Verify Code",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(33.dp))

                    Text(
                        text = "Haven't got the email yet? resend email",
                        modifier = Modifier
                            .offset(x = 0.dp,
                                y = 40.dp)
                            .clickable {
                                // Navigate to the login page
                                navController.navigate("login")
                            },
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(40.dp))
                }
            }
        }
    }
}
