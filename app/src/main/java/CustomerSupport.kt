package com.example.android_strepapp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerSupport(navController: NavController, modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var comments by remember { mutableStateOf("") }

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
            painter = painterResource(id = R.drawable.vector3),
            contentDescription = null,
            modifier = Modifier
                .size(screenWidth * 1.75f) // Adjust size based on screen width
                .offset(
                    x = 0.dp,
                    y = screenHeight * 0.230f // 15% from the top
                )
        )
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
                            .clickable { navController.navigate("menu") }
                    )
                    Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
                }

                Text(
                    text = "Customer Support",
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(screenHeight * 0.153f)) // Adjust spacing dynamically
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.settings2),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .width(screenWidth * 0.25f)
                        .aspectRatio(1.2f),
                    contentScale = ContentScale.Fit
                )
                Image(
                    painter = painterResource(id = R.drawable.custicon),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .width(screenWidth * 0.13f)
                        .offset(y= screenWidth * -0.175f)
                        .aspectRatio(1.2f),
                    contentScale = ContentScale.Fit
                )
            }



            Spacer(modifier = Modifier.height(screenHeight * 0.05f)) // Adjust spacing
        }
        Box(
            modifier = Modifier
                .height(1000.dp)
                .width(1000.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(screenHeight * 0.26f))

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .verticalScroll(scrollState),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Form fields and buttons
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("First Name") },
                        modifier = Modifier.fillMaxWidth(),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.user),
                                contentDescription = "First Name Icon",
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

                    Spacer(modifier = Modifier.height(21.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Subject") },
                        modifier = Modifier.fillMaxWidth(),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.message),
                                contentDescription = "Password Icon",
                                modifier = Modifier.size(24.dp),
                                tint = Color(0xFFFF7F3E)
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.eye),
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

                    Spacer(modifier = Modifier.height(21.dp))

                    OutlinedTextField(
                        value = comments,
                        onValueChange = { comments = it },
                        label = { Text("Message") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = false,
                        maxLines = 5,
                        minLines = 4,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = { navController.navigate("customerSupport") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7F3E))
                    ) {
                        Text(
                            text = "Send",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(41.dp))
                    Divider(modifier = Modifier.height(0.5.dp), color = Color.White)

                    Spacer(modifier = Modifier.height(41.dp))

                    OutlinedButton(
                        onClick = { navController.navigate("supportHistory") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(1.dp, Color(0xFFFF7F3E))
                    ) {
                        Text(
                            text = "Support History",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF7F3E)
                        )
                    }
                }
            }
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
