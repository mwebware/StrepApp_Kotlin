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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPassword(navController: NavController, modifier: Modifier = Modifier) {
    var repeatPassword by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var passwordRepeatVisible by remember { mutableStateOf(false) }
    var showError by remember { mutableStateOf(false) }
    var showError2 by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    // Success Dialog
    if (showSuccessDialog) {
        AlertDialog(
            onDismissRequest = {
                showSuccessDialog = false
                navController.navigate("login1")
            },
            containerColor = Color.White,
            shape = RoundedCornerShape(10.dp),
            title = null,
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Thank you.",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Your password has been reset successfully. Please login with the new password.",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            },
            confirmButton = {},
            properties = DialogProperties(dismissOnClickOutside = true)
        )
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bgimage11),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Vector Image
        Image(
            painter = painterResource(id = R.drawable.vector),
            contentDescription = null,
            modifier = Modifier
                .size(screenWidth * 1.5f)
                .offset(
                    x = 0.dp,
                    y = screenHeight * 0.345f
                )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(screenHeight * 0.05f))

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(screenWidth * 0.4f)
                    .aspectRatio(1.2f),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(screenHeight * 0.061f))

            Image(
                painter = painterResource(id = R.drawable.forgoticon),
                contentDescription = "Forgot Icon",
                modifier = Modifier
                    .width(screenWidth * 0.26f)
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
                        text = "Reset Password?",
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(screenHeight * 0.01f))

                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            showError2 = false
                        },
                        label = { Text("Enter New password") },
                        modifier = Modifier
                            .offset(x = 0.dp, y = 40.dp)
                            .fillMaxWidth(),
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
                        onValueChange = {
                            repeatPassword = it
                            showError = repeatPassword.isNotEmpty() && repeatPassword != password
                            showError2 = false
                        },
                        label = { Text("Repeat New password") },
                        modifier = Modifier
                            .offset(x = 0.dp, y = 40.dp)
                            .fillMaxWidth(),
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

                    if (showError) {
                        Text(
                            text = "Passwords must match.",
                            color = Color.Red,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .offset(x = 0.dp, y = if (showError != null) 50.dp else 0.dp),
                            textAlign = TextAlign.Center,
                        )
                    }
                    if (showError2) {
                        Text(
                            text = "Enter password and Repeat password",
                            color = Color.Red,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .offset(x = 0.dp, y = if (showError2 != null) 50.dp else 0.dp),
                            textAlign = TextAlign.Center,
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            if (!showError && !repeatPassword.isEmpty() && !password.isEmpty()) {
                                showSuccessDialog = true  // Show the success dialog
//                                navController.navigate("login1")
                                if(!password.isEmpty() && !repeatPassword.isEmpty()){
                                    showError2 = false
                                }
                            }
                            else{
                                showError2 = true
                                if(!password.isEmpty() && !repeatPassword.isEmpty()){
                                    showError2 = false
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(x = 0.dp, y = 40.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(10.dp),
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

                    Spacer(modifier = Modifier.height(33.dp))

                    Text(
                        text = "Back to login",
                        modifier = Modifier
                            .offset(x = 0.dp, y = 40.dp)
                            .clickable {
                                navController.navigate("login1")
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