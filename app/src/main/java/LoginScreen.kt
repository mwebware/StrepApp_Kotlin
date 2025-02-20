//package com.example.android_strepapp
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.Button
//import androidx.compose.material3.Checkbox
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//
//@Composable
//fun LoginScreen(navController: NavController) {
//    var userName = remember { mutableStateOf(TextFieldValue("test")) }
//    var password = remember { mutableStateOf(TextFieldValue("test")) }
//    var useFaceId = remember { mutableStateOf(false) }
//
//    var errorMessage = remember { mutableStateOf("") }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(
//                Brush.verticalGradient(
//                    colors = listOf(
//                        Color(201, 171, 169),
//                        Color(196, 148, 145)
//                    )
//                )
//            )
//            .padding(16.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            // Logo
//            Image(
//                painter = painterResource(id = R.drawable.logo2),
//                contentDescription = "Logo",
//                modifier = Modifier
//                    .width(326.dp)
//                    .height(173.dp)
//                    .padding(bottom = 16.dp)
//            )
//
//            // User Name Input
//            TextField(
//                value = userName.value,
//                onValueChange = { userName.value = it
//                                  errorMessage.value=""
//                                },
//                placeholder = { Text("User Name") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 16.dp),
//                singleLine = true,
////                colors = TextFieldDefaults.textFieldColors(
////                    containerColor = Color.White // Set background color to white
////                )
//
//            )
//
//            // Password Input
//            TextField(
//                value = password.value,
//                onValueChange = { password.value = it
//                                  errorMessage.value=""
//                                },
//                placeholder = { Text("Password") },
//                visualTransformation = VisualTransformation.None,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 8.dp),
//                singleLine = true,
////                colors = TextFieldDefaults.textFieldColors(
////                    containerColor = Color.White
////                )
//            )
//
//            // Error message display
//            if (errorMessage.value.isNotEmpty()) {
//                Text(
//                    text = errorMessage.value,
//                    color = Color.Red,
//                    modifier = Modifier.padding(bottom = 8.dp)
//                )
//            }
//
//            // Face ID Checkbox
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(bottom = 16.dp)
//            ) {
//                Checkbox(
//                    checked = useFaceId.value,
//                    onCheckedChange = { useFaceId.value = it }
//                )
//                Text(text = "Use Face ID", fontSize = 14.sp)
//            }
//
//            // Login Button
//            Button(
//                onClick = {
//                    //navController.navigate("profile") /* Handle login */
//                    if (userName.value.text.isBlank()) {
//                        errorMessage.value= "Username is required"
//                    } else if (password.value.text.isBlank()) {
//                        errorMessage.value = "Password is required"
//                    } else {
//                        // Proceed with login
//                        navController.navigate("profile")
//                    }
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 16.dp)
//            ) {
//                Text(text = "LOGIN", fontSize = 16.sp)
//            }
//
//            // Forgot Password & Register Links
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Text(
//                    text = "Forgot Password?",
//                    fontSize = 14.sp,
//                    color = Color.Blue,
//                    modifier = Modifier.padding(bottom = 8.dp)
//                )
//                Row {
//                    Text(
//                        text = "Don't have an account? ",
//                        fontSize = 14.sp
//                    )
//                    Text(
//                        text = "Register now",
//                        fontSize = 14.sp,
//                        color = Color(99, 31, 27),
//                        modifier = Modifier
//                            .clickable {
//                                navController.navigate("register")
//                            }
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewLoginScreen() {
//    // Note: You need to provide a NavController for the preview
//}
//
//package com.example.android_strepapp
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.Button
//import androidx.compose.material3.Checkbox
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//
//@Composable
//fun LoginScreen(navController: NavController) {
//    var userName = remember { mutableStateOf(TextFieldValue("test")) }
//    var password = remember { mutableStateOf(TextFieldValue("test")) }
//    var useFaceId = remember { mutableStateOf(false) }
//
//    var errorMessage = remember { mutableStateOf("") }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(
//                Brush.verticalGradient(
//                    colors = listOf(
//                        Color(201, 171, 169),
//                        Color(196, 148, 145)
//                    )
//                )
//            )
//            .padding(16.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            // Logo
//            Image(
//                painter = painterResource(id = R.drawable.logo2),
//                contentDescription = "Logo",
//                modifier = Modifier
//                    .width(326.dp)
//                    .height(173.dp)
//                    .padding(bottom = 16.dp)
//            )
//
//            // User Name Input
//            TextField(
//                value = userName.value,
//                onValueChange = { userName.value = it
//                                  errorMessage.value=""
//                                },
//                placeholder = { Text("User Name") },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 16.dp),
//                singleLine = true,
////                colors = TextFieldDefaults.textFieldColors(
////                    containerColor = Color.White // Set background color to white
////                )
//
//            )
//
//            // Password Input
//            TextField(
//                value = password.value,
//                onValueChange = { password.value = it
//                                  errorMessage.value=""
//                                },
//                placeholder = { Text("Password") },
//                visualTransformation = VisualTransformation.None,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 8.dp),
//                singleLine = true,
////                colors = TextFieldDefaults.textFieldColors(
////                    containerColor = Color.White
////                )
//            )
//
//            // Error message display
//            if (errorMessage.value.isNotEmpty()) {
//                Text(
//                    text = errorMessage.value,
//                    color = Color.Red,
//                    modifier = Modifier.padding(bottom = 8.dp)
//                )
//            }
//
//            // Face ID Checkbox
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier.padding(bottom = 16.dp)
//            ) {
//                Checkbox(
//                    checked = useFaceId.value,
//                    onCheckedChange = { useFaceId.value = it }
//                )
//                Text(text = "Use Face ID", fontSize = 14.sp)
//            }
//
//            // Login Button
//            Button(
//                onClick = {
//                    //navController.navigate("profile") /* Handle login */
//                    if (userName.value.text.isBlank()) {
//                        errorMessage.value= "Username is required"
//                    } else if (password.value.text.isBlank()) {
//                        errorMessage.value = "Password is required"
//                    } else {
//                        // Proceed with login
//                        navController.navigate("profile")
//                    }
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 16.dp)
//            ) {
//                Text(text = "LOGIN", fontSize = 16.sp)
//            }
//
//            // Forgot Password & Register Links
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Text(
//                    text = "Forgot Password?",
//                    fontSize = 14.sp,
//                    color = Color.Blue,
//                    modifier = Modifier.padding(bottom = 8.dp)
//                )
//                Row {
//                    Text(
//                        text = "Don't have an account? ",
//                        fontSize = 14.sp
//                    )
//                    Text(
//                        text = "Register now",
//                        fontSize = 14.sp,
//                        color = Color(99, 31, 27),
//                        modifier = Modifier
//                            .clickable {
//                                navController.navigate("register")
//                            }
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewLoginScreen() {
//    // Note: You need to provide a NavController for the preview
//}
//
package com.example.android_strepapp

import android.R.id.bold
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var userName = remember { mutableStateOf(TextFieldValue("")) }
    var password = remember { mutableStateOf(TextFieldValue("")) }
    var useFaceId = remember { mutableStateOf(false) }
    var errorMessage = remember { mutableStateOf("") }



    Image(
        painter = painterResource(id = R.drawable.bggradiant),
        contentDescription = "Background Image",
        contentScale = ContentScale.Crop, // Ensures the image covers the full screen
        modifier = Modifier.fillMaxSize()
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF604CC3).copy(alpha =0.9f), // #604CC3 with 70% opacity
                        Color(0xFF80C4E9).copy(alpha = 0.7f)  // #80C4E9 with 70% opacity
                    ),
                    startY = 0f,
                    endY = Float.POSITIVE_INFINITY
                )
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top=100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // App Logo
            Image(
                painter = painterResource(id = R.drawable.streppapplogo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .padding(bottom = 24.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.95f) // Card takes 85% of the screen width
                    .background(Color(255, 255, 255, 204),  shape = RoundedCornerShape(16.dp))
                    .padding(24.dp) // Inner padding within the card
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    // "Login" text
                    Text(
                        text = "Login",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W700,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Username Input
                    TextField(
                        value = userName.value,
                        onValueChange = { userName.value = it },
                        placeholder = { Text("User Name") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = RoundedCornerShape(8.dp)) // White background with rounded corners
                            .padding(4.dp), // Inner padding for the text field
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White, // Set container color to white
                            focusedBorderColor = Color.Transparent, // No border when focused
                            unfocusedBorderColor = Color.Transparent, // No border when unfocused
                            cursorColor = Color.Gray // Cursor color
                        )
                    )

                    // Spacer for spacing
                    Spacer(modifier = Modifier.height(16.dp)) // Space of 16.dp

                    // Password Input
                    TextField(
                        value = password.value,
                        onValueChange = { password.value = it },
                        placeholder = { Text("Password") },
                        visualTransformation = VisualTransformation.None,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, shape = RoundedCornerShape(8.dp)) // White background with rounded corners
                            .padding(4.dp), // Inner padding for the text field
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White, // Set container color to white
                            focusedBorderColor = Color.Transparent, // No border when focused
                            unfocusedBorderColor = Color.Transparent, // No border when unfocused
                            cursorColor = Color.Gray // Cursor color
                        )
                         )

                    // Error message display
                    if (errorMessage.value.isNotEmpty()) {
                        Text(
                            text = errorMessage.value,
                            color = Color.Red,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }

                    // Login Button
                    Button(
                        onClick = {
                            if (userName.value.text.isBlank()) {
                                errorMessage.value = "Username is required"
                            } else if (password.value.text.isBlank()) {
                                errorMessage.value = "Password is required"
                            } else {
                                navController.navigate("profile")
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(255, 140, 0)), // Orange
                            shape = RoundedCornerShape(8.dp),
                    ) {
                        Text(text = "Submit", fontSize = 18.sp, color = Color.White)
                    }

                    // "Forgot Password?" Text
                    Text(
                        text = "Forgot Password?",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        color = Color.Black,
                        modifier = Modifier
                            .clickable { /* Navigate to forgot password screen */ }
                            .padding(bottom = 16.dp)
                    )

                    // Face ID Checkbox
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(bottom = 16.dp)
                    ) {
                        Checkbox(
                            checked = useFaceId.value,
                            onCheckedChange = { useFaceId.value = it }
                        )
                        Text(
                            text = "Use Face ID",
                            fontSize = 14.sp,
                            color = Color(0, 0, 0, 112) // Corrected alpha value for ~44% opacity
                        )
                    }

                    // Register Link
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Don't have an account? ",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            color = Color.Black
                        )
//                        Text(
//                            text = "Register",
//                            fontSize = 14.sp,
//                            color = Color(255, 140, 0), // Orange
//                            modifier = Modifier
//                                .clickable {
//                                    navController.navigate("register")
//                                }
//                        )

                    }

                    // Register Button with a white border
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp)
                            .border(2.dp, Color(255, 140, 0), shape = RoundedCornerShape(8.dp)) // White border
                    ) {
                        Button(
                            onClick = {
                                navController.navigate("register")
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                               // .background(Color(255, 140, 0)), // Set background to orange
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), // Make button background transparent
                            shape = RoundedCornerShape(8.dp) // Rounded corners
                        ) {
                            Text(text = "Register", fontSize = 24.sp, color = Color(255, 140, 0), fontWeight = FontWeight.W500) // Use white text for contrast
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    // This is just a preview function to see the layout in the IDE
}
