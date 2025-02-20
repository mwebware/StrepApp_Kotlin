package com.example.android_strepapp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuySubscription(navController: NavController, price: String, description: String, modifier: Modifier = Modifier) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bgimage11),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp) // Space for footer
        ) {
            Header2(navController = navController)
            Spacer(modifier = Modifier.height(26.dp))
            ReviewSection2(navController = navController, price = price, description = description) // Adding the review section here
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
                            .clickable { navController.navigate("splash") }
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

@Composable
fun Header2(navController: NavController) {
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
                    .clickable { navController.navigate("subscription") }
            )
            Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
        }

        Text(
            text = "Buy Subscription",
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewSection2(navController: NavController, price: String, description: String, modifier: Modifier = Modifier) {
    var CardholderName by remember { mutableStateOf("") }
    var CreditcardNumber by remember { mutableStateOf("") }
    var Expiry by remember { mutableStateOf("") }
    var CVV by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .width(400.dp)
            .padding(16.dp)
            .background(Color(0xCCFFFFFF), shape = RoundedCornerShape(16.dp))
            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(16.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 32.sp, color = Color(0xFF007AFF))) {
                    append("$price ")
                }
                withStyle(style = SpanStyle(fontSize = 20.sp, color = Color.Black)) {
                    append(description)
                }
            },
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(21.dp))
        Divider(
            modifier = Modifier
                .height(1.dp),
            color = Color.White
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Enter your card details",
            color = Color.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = CardholderName,
            onValueChange = { CardholderName = it },
            label = { Text("Cardholder Name") },
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
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = CreditcardNumber,
            onValueChange = { CreditcardNumber = it },
            label = { Text("Creditcard Number") },
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
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number // Opens numeric keyboard
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Space between fields
        ) {
            OutlinedTextField(
                value = Expiry,
                onValueChange = { Expiry = it },
                label = { Text("Expiry") },
                modifier = Modifier
                    .weight(1f) // Occupies half of the row's width
                    .fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.calender),
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
                value = CVV,
                onValueChange = { CVV = it },
                label = { Text("CVV") },
                modifier = Modifier
                    .weight(1f) // Occupies the other half of the row's width
                    .fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.cvv),
                        contentDescription = "Zip Code icon",
                        modifier = Modifier.size(24.dp),
                        tint = Color(0xFFFF7F3E)
                    )
                },
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
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("showReview") },
            modifier = Modifier.fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7F3E))
        ) {
            Text(
                text = "Pay $price",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
        Spacer(modifier = Modifier.height(41.dp))
    }
}


