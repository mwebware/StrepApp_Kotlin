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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(navController: NavController, modifier: Modifier = Modifier) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var Dob by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var passwordRepeatVisible by remember { mutableStateOf(false) }
    var city by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }



    val scrollState = rememberScrollState()

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
                painter = painterResource(id = R.drawable.register),
                contentDescription = "Register Icon",
                modifier = Modifier
                    .width(screenWidth * 0.26f) // 25% of screen width
                    .aspectRatio(1.2f),
                contentScale = ContentScale.Fit
            )

            Box(
                modifier = modifier
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                        .verticalScroll(scrollState),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Register",
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(screenHeight * 0.05f)) // Adjust spacing

                    OutlinedTextField(
                        value = firstName,
                        onValueChange = { firstName = it },
                        label = { Text("First Name") },
                        modifier = Modifier
                            .fillMaxWidth(),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.user),
                                contentDescription = "Email icon",
                                modifier = Modifier.size(24.dp),
                                Color(0xFFFF7F3E)
                            )
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    OutlinedTextField(
                        value = lastName,
                        onValueChange = { lastName = it },
                        label = { Text("Last Name") },
                        modifier = Modifier
                            .fillMaxWidth(),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.user),
                                contentDescription = "Email icon",
                                modifier = Modifier.size(24.dp),
                                Color(0xFFFF7F3E)
                            )
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    OutlinedTextField(
                        value = Dob,
                        onValueChange = { Dob = it },
                        label = { Text("Date of Birth") },
                        modifier = Modifier
                            .fillMaxWidth(),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.calender),
                                contentDescription = "Email icon",
                                modifier = Modifier.size(24.dp),
                                Color(0xFFFF7F3E)
                            )
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        modifier = Modifier
                            .fillMaxWidth(),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.email),
                                contentDescription = "Email icon",
                                modifier = Modifier.size(24.dp),
                                Color(0xFFFF7F3E)
                            )
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        modifier = Modifier.fillMaxWidth(),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.lock),
                                contentDescription = "Password Icon",
                                modifier = Modifier.size(24.dp),
                                tint = Color(0xFFFF7F3E)
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    painter = if (passwordVisible)
                                        painterResource(id = R.drawable.eye)
                                    else
                                        painterResource(id = R.drawable.eyeoff),
                                    contentDescription = "Toggle Password Visibility",
                                    modifier = Modifier.size(20.dp),
                                    tint = Color.Black
                                )
                            }
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    OutlinedTextField(
                        value = repeatPassword,
                        onValueChange = { repeatPassword = it },
                        label = { Text("Repeat Password") },
                        modifier = Modifier.fillMaxWidth(),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.lock),
                                contentDescription = "Password Icon",
                                modifier = Modifier.size(24.dp),
                                tint = Color(0xFFFF7F3E)
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { passwordRepeatVisible = !passwordRepeatVisible }) {
                                Icon(
                                    painter = if (passwordRepeatVisible)
                                        painterResource(id = R.drawable.eye)
                                    else
                                        painterResource(id = R.drawable.eyeoff),
                                    contentDescription = "Toggle Password Visibility",
                                    modifier = Modifier.size(20.dp),
                                    tint = Color.Black
                                )
                            }
                        },
                        visualTransformation = if (passwordRepeatVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp) // Space between fields
                    ) {
                        OutlinedTextField(
                            value = city,
                            onValueChange = { city = it },
                            label = { Text("+1") },
                            modifier = Modifier
                                .weight(0.35f) // Smaller width (30% of the row's width)
                                .fillMaxWidth(),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.phone),
                                    contentDescription = "Location icon",
                                    modifier = Modifier.size(24.dp),
                                    tint = Color(0xFFFF7F3E)
                                )
                            },
                            singleLine = true,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color.White,
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent
                            )
                        )

                        OutlinedTextField(
                            value = phoneNumber,
                            onValueChange = { phoneNumber = it },
                            label = { Text("000-000-000") },
                            modifier = Modifier
                                .weight(0.65f) // Larger width (70% of the row's width)
                                .fillMaxWidth(),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number // Opens numeric keyboard
                            ),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color.White,
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "Terms and conditions",
                        modifier = Modifier
                            .clickable {
                                // Navigate to login screen when clicked
                                navController.navigate("terms")
                            },
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,

                        )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            // Navigate to login screen when clicked
                            navController.navigate("login1")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF7F3E)
                        )
                    ) {
                        Text(
                            text = "Register",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Desclaimer",
                        modifier = Modifier
                            .clickable {
                                // Navigate to login screen when clicked
                                navController.navigate("desclaimer")
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
