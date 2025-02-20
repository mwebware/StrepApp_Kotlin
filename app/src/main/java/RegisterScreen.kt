import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RegisterScreen() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }

    // Error state for each field
    var errorMessage by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(201, 171, 169),
                        Color(196, 148, 145)
                    )
                )
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // Padding inside the column
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(text = "Register", fontSize = 24.sp)

            // Input fields
            CustomTextField(
                placeholder = "First Name",
                value = firstName,
                onValueChange = { firstName = it }
            )
            CustomTextField(
                placeholder = "Last Name",
                value = lastName,
                onValueChange = { lastName = it }
            )
            CustomTextField(
                placeholder = "Date of Birth",
                value = dateOfBirth,
                onValueChange = { dateOfBirth = it }
            )
            CustomTextField(
                placeholder = "Address",
                value = address,
                onValueChange = { address = it }
            )
            CustomTextField(
                placeholder = "Phone Number",
                value = phoneNumber,
                onValueChange = { phoneNumber = it }
            )
            CustomTextField(
                placeholder = "Email",
                value = email,
                onValueChange = { email = it }
            )
            CustomTextField(
                placeholder = "Password",
                value = password,
                onValueChange = { password = it }
            )
            CustomTextField(
                placeholder = "Repeat Password",
                value = repeatPassword,
                onValueChange = { repeatPassword = it }
            )

            // Display error message if there is any
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            Button(
                onClick = {
                    // Validate fields
                    errorMessage = when {
                        firstName.isBlank() -> "First Name is required"
                        lastName.isBlank() -> "Last Name is required"
                        dateOfBirth.isBlank() -> "Date of Birth is required"
                        address.isBlank() -> "Address is required"
                        phoneNumber.isBlank() -> "Phone Number is required"
                        email.isBlank() -> "Email is required"
                        password.isBlank() -> "Password is required"
                        repeatPassword.isBlank() -> "Repeat Password is required"
                        password != repeatPassword -> "Passwords do not match"
                        else -> ""
                    }

                    // If no errors, proceed with registration logic
                    if (errorMessage.isEmpty()) {
                        // Handle registration logic
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text(text = "REGISTER", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun CustomTextField(placeholder: String, value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
//        colors = TextFieldDefaults.textFieldColors(
//            containerColor = Color.White // Set background color to white
//        )
    )
}
