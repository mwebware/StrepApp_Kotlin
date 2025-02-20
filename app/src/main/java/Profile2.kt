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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun Profile2(
        navController: NavController,
        modifier: Modifier = Modifier,
        name: String?,
        details: String?,
        imageRes: Int?
    ) {
    var firstName by remember { mutableStateOf(name ?: "Default Name") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var zipCode by remember { mutableStateOf("") }
    var selectCountry by remember { mutableStateOf("Country") }
    var password by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    val Countries = listOf("India", "USA", "France", "China", "Japan")
    var expanded by remember { mutableStateOf(false) }

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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .offset(x = 0.dp, y = 50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.vector2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth() // Fill the width of the container
                        .fillMaxHeight() // Fill the height of the container
                        .offset(x = 0.dp, y = screenHeight * 0.150f) // Adjust the vertical offset if needed

                )
            }


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
                            .clickable { navController.navigate("profile1") }
                    )
                    Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
                }

                Text(
                    text = "Profile",
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(screenHeight * 0.085f))
                Box(
                    modifier = Modifier
                        .width(screenWidth * 0.45f) // 40% of screen width
                        .height(screenWidth * 0.45f)
                        .background(Color.White.copy(alpha = 0.5f), CircleShape)
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = imageRes ?: R.drawable.profileimage1),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .width(screenWidth * 0.45f)
                            .height(screenWidth * 0.45f)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentScale = ContentScale.Fit
                    )
                    Image(
                        painter = painterResource(id = R.drawable.camera),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                            .offset(
                                x = screenHeight * 0.075f,
                                y = screenHeight * 0.135f
                            )
                            .fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )
                }
                Spacer(modifier = Modifier.height(screenHeight * 0.04f))
                Column(
                    modifier = Modifier
    //                    .padding(top = 15.dp)
                        .verticalScroll(scrollState)
                        .padding(top = 0.dp), // Enable scrolling after "Register"
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = if (firstName == "First Name") "" else firstName,
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
                        value = address,
                        onValueChange = { address = it },
                        label = { Text("Address") },
                        modifier = Modifier
                            .fillMaxWidth(),
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.location),
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

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                          ,
                        horizontalArrangement = Arrangement.spacedBy(8.dp) // Space between fields
                    ) {
                        OutlinedTextField(
                            value = city,
                            onValueChange = { city = it },
                            label = { Text("City") },
                            modifier = Modifier
                                .weight(1f) // Occupies half of the row's width
                                .fillMaxWidth(),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.location),
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
                            value = zipCode,
                            onValueChange = { zipCode = it },
                            label = { Text("ZipCode") },
                            modifier = Modifier
                                .weight(1f) // Occupies the other half of the row's width
                                .fillMaxWidth(),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.location),
                                    contentDescription = "Zip Code icon",
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
                    }

                    Spacer(modifier = Modifier.height(24.dp))


                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.TopStart)
                            .clickable { expanded = true }
                    ) {
                        OutlinedTextField(
                            value = selectCountry,
                            onValueChange = { },
                            modifier = Modifier.fillMaxWidth(),
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.location),
                                    contentDescription = "location icon",
                                    modifier = Modifier.size(24.dp),
                                    tint = Color(0xFFFF7F3E)
                                )
                            },
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.arrow6),
                                    contentDescription = "Dropdown icon",
                                    modifier = Modifier.size(18.dp),
                                    tint = Color.Black
                                )
                            },
                            enabled = false, // Disable input as we are using it as a dropdown trigger
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
                            Countries.forEach { country ->
                                DropdownMenuItem(
                                    onClick = {
                                        selectCountry = country
                                        expanded = false
                                    },
                                    text = { Text(country) }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
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

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                          ,
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
                            leadingIcon = {

                            },
                            singleLine = true,
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                containerColor = Color.White,
                                focusedBorderColor = Color.Transparent,
                                unfocusedBorderColor = Color.Transparent
                            )
                        )
                    }


                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = "Gender",
                        modifier = Modifier.padding(vertical = 24.dp)
                            .align(Alignment.Start),
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 3.dp),
                        horizontalArrangement = Arrangement.SpaceBetween // Ensures spacing between items
                    ) {
                        val genderOptions = listOf("Male", "Female", "Non-binary")
                        var selectedGender by remember { mutableStateOf("") } // State for selected gender

                        genderOptions.forEach { gender ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = selectedGender == gender,
                                    onClick = { selectedGender = gender },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color(
                                            0xFFFF7F3E
                                        )
                                    )
                                )
                                Spacer(modifier = Modifier.width(3.dp)) // Small spacing between radio button and text
                                Text(text = gender)
                            }
                        }
                    }



                    Spacer(modifier = Modifier.height(23.dp))

                    Button(
                        onClick = {
                            // Navigate to login screen when clicked
                            navController.navigate("familymembers")
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
                            text = "Update Profile",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }
            }
            }
        }

