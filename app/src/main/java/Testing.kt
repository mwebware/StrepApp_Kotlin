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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.LayoutDirection
import com.example.android_strepapp.R


@Composable
fun rememberSemiCircleExtrudeShape(radius: Dp): Shape {
    val density = LocalDensity.current
    return remember(radius) {
        GenericShape { size: Size, _: LayoutDirection ->
            val radiusPx = with(density) { radius.toPx() }

            // Start from bottom-left corner
            moveTo(0f, size.height)
            // Draw left side up to where semi-circle begins
            lineTo(0f, radiusPx)
            // Line to where semi-circle begins
            lineTo(size.width / 2 - radiusPx, radiusPx)
            // Draw the semi-circle
            arcTo(
                rect = androidx.compose.ui.geometry.Rect(
                    left = size.width / 2 - radiusPx,
                    top = 0f,
                    right = size.width / 2 + radiusPx,
                    bottom = radiusPx * 2
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = -180f,  // Positive 180f to extrude upward
                forceMoveTo = false
            )
            // Continue to right side
            lineTo(size.width, radiusPx)
            // Complete right side
            lineTo(size.width, size.height)
            // Close the shape
            close()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Testing(modifier: Modifier = Modifier) {
    var selectedLanguage by remember { mutableStateOf("Select Language") }
    var expanded by remember { mutableStateOf(false) }

    val languages = listOf("English", "Spanish", "French", "German", "Chinese")

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val semiCircleRadius = screenWidth * 0.11f

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

        // Box with semi-circle cut
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 15.dp)
                .offset(
                    x = 0.dp,
                    y = screenHeight * 0.275f
                )
                .clip(shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                .clip(rememberSemiCircleExtrudeShape(radius = semiCircleRadius)) // Increased radius to match design
                .background(Color(0xCCFFFFFF))
                .clipToBounds()
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

            Spacer(modifier = Modifier.height(screenHeight * 0.038f))

            Image(
                painter = painterResource(id = R.drawable.forgoticon),
                contentDescription = "Forgot Icon",
                modifier = Modifier
                    .width(semiCircleRadius * 2.5f)
                    .aspectRatio(1.2f),
                contentScale = ContentScale.Fit
            )

            Column(
                modifier = Modifier.padding(screenHeight * 0.01f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Testing",
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(screenHeight * 0.05f))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = true }
                ) {
                    OutlinedTextField(
                        value = selectedLanguage,
                        onValueChange = { },
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier
                            .fillMaxWidth()
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

                Spacer(modifier = Modifier.height(screenHeight * 0.03f))

                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(screenHeight * 0.06f),
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

                Spacer(modifier = Modifier.height(screenHeight * 0.05f))
            }
        }
    }
}