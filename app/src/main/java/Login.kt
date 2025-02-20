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
    import androidx.compose.ui.platform.LocalConfiguration
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.text.TextStyle
    import androidx.compose.ui.text.input.VisualTransformation
    import androidx.navigation.NavController
    import androidx.compose.ui.unit.Dp
    import androidx.biometric.BiometricManager
    import androidx.biometric.BiometricPrompt
    import androidx.core.content.ContextCompat
    import androidx.fragment.app.FragmentActivity
    import android.widget.Toast
    import android.app.Activity

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Login(navController: NavController, modifier: Modifier = Modifier) {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }
        var errorMessage = remember { mutableStateOf("") }

        val scrollState = rememberScrollState()
        val screenHeight = LocalConfiguration.current.screenHeightDp.dp
        val screenWidth = LocalConfiguration.current.screenWidthDp.dp
        val context = LocalContext.current

        // Safe biometric prompt creation
        val biometricPrompt = remember {
            when {
                context is FragmentActivity -> {
                    val executor = ContextCompat.getMainExecutor(context)
                    BiometricPrompt(context, executor,
                        object : BiometricPrompt.AuthenticationCallback() {
                            override fun onAuthenticationSucceeded(
                                result: BiometricPrompt.AuthenticationResult
                            ) {
                                super.onAuthenticationSucceeded(result)
                                navController.navigate("profile1")
                            }

                            override fun onAuthenticationError(
                                errorCode: Int,
                                errString: CharSequence
                            ) {
                                super.onAuthenticationError(errorCode, errString)
                                errorMessage.value = errString.toString()
                            }

                            override fun onAuthenticationFailed() {
                                super.onAuthenticationFailed()
                                errorMessage.value = "Authentication failed"
                            }
                        })
                }
                else -> null
            }
        }

        val promptInfo = remember {
            BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric login for Strep App")
                .setSubtitle("Log in using your biometric credential")
                .setNegativeButtonText("Cancel")
                .build()
        }

        fun authenticateWithBiometrics() {
            try {
                if (context !is FragmentActivity) {
                    errorMessage.value = "Biometric authentication not available"
                    return
                }

                val biometricManager = BiometricManager.from(context)
                when (biometricManager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG)) {
                    BiometricManager.BIOMETRIC_SUCCESS -> {
                        biometricPrompt?.authenticate(promptInfo) ?: run {
                            errorMessage.value = "Biometric authentication not initialized"
                        }
                    }
                    BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->
                        errorMessage.value = "No biometric features available on this device"
                    BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED ->
                        errorMessage.value = "No biometric credentials have been enrolled"
                    BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE ->
                        errorMessage.value = "Biometric hardware is currently unavailable"
                    else -> errorMessage.value = "Biometric authentication unavailable"
                }
            } catch (e: Exception) {
                errorMessage.value = "Error initializing biometric authentication"
            }
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
                    painter = painterResource(id = R.drawable.loginicon),
                    contentDescription = "Login Icon",
                    modifier = Modifier
                        .width(screenWidth * 0.26f)
                        .aspectRatio(1.2f),
                    contentScale = ContentScale.Fit
                )

                Box(
                    modifier = modifier
                ) {
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .verticalScroll(scrollState),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Login",
                            fontSize = 24.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(screenHeight * 0.05f))

                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("First Name") },
                            modifier = Modifier.fillMaxWidth(),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.user),
                                    contentDescription = "Email icon",
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

                        Spacer(modifier = Modifier.height(screenHeight * 0.03f))

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

                        Spacer(modifier = Modifier.height(screenHeight * 0.03f))

                        if (errorMessage.value.isNotEmpty()) {
                            Text(
                                text = errorMessage.value,
                                color = Color.Red,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                        }

                        Text(
                            text = "Forgot password?",
                            modifier = Modifier.clickable { navController.navigate("forgotPassword") },
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(screenHeight * 0.03f))

                        Button(
                            onClick = {
                                if (email.isBlank() && password.isBlank()) {
                                    errorMessage.value = "Username and Password is required"
                                } else if (email.isEmpty()) {
                                    errorMessage.value = "Username is required"
                                } else if (password.isEmpty()) {
                                    errorMessage.value = "Password is required"
                                } else {
                                    navController.navigate("profile1")
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(screenHeight * 0.07f),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7F3E))
                        ) {
                            Text(
                                text = "Submit",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(screenHeight * 0.02f))

                        // Face ID section with safe click handling
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .padding(vertical = 24.dp)
                                .clickable {
                                    try {
                                        authenticateWithBiometrics()
                                    } catch (e: Exception) {
                                        errorMessage.value = "Failed to initialize biometric authentication"
                                    }
                                }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.faceid),
                                contentDescription = "FaceId",
                                modifier = Modifier
                                    .width(screenWidth * 0.08f)
                                    .height(screenWidth * 0.08f),
                                contentScale = ContentScale.Fit
                            )
                            Text(
                                text = "Use Face ID",
                                fontSize = 12.sp,
                                color = Color(0x70000000)
                            )
                        }

                        Divider(
                            modifier = Modifier.height(1.dp),
                            color = Color(0x26000000)
                        )

                        Spacer(modifier = Modifier.height(screenHeight * 0.03f))

                        Text(
                            text = "Don't have an account?",
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(screenHeight * 0.03f))

                        OutlinedButton(
                            onClick = { navController.navigate("register1") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(screenHeight * 0.07f),
                            shape = RoundedCornerShape(10.dp),
                            border = BorderStroke(1.dp, Color(0xFFFF7F3E))
                        ) {
                            Text(
                                text = "Register",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFF7F3E)
                            )
                        }

                        Spacer(modifier = Modifier.height(screenHeight * 0.05f))
                    }
                }
            }
        }
    }