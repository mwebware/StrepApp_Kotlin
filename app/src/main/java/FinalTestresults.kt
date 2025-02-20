import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.graphicsLayer
import androidx.navigation.NavController
import com.example.android_strepapp.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import coil.compose.AsyncImage
import coil.request.ImageRequest
import java.io.File

@Composable
fun FinalTestResults(navController: NavController, modifier: Modifier = Modifier) {

    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bgimage11),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(27.dp))

            // Header Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Test Results",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .width(410.dp)
                    .height(75.dp) // Adjust height based on expanded state
                    .border(
                        width = 0.dp,
                        color = Color(0xCCFFFFFF),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(Color(0xCCFFFFFF), shape = RoundedCornerShape(12.dp))
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 15.dp, bottom = 14.dp)
                ){
                    Row{
                        Image(
                            painter = painterResource(id = R.drawable.caution),
                            contentDescription = "Caution",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(49.dp)
                                .height(49.dp)
                                .padding(start = 12.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row{
                        Text(
                            text = "This is not a medical diagnosis.\n" +
                                    "Consult your physician for health concerns. (Results are in Beta, not for actual patient care)",
                            color = Color.Black,
                            fontSize = 14.sp,
                            lineHeight = 15.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.widthIn(max = 320.dp)
                        )
                    }
                }

            }
            Spacer(modifier = Modifier.height(20.dp))
            // Central Content Section
            Box(
                modifier = Modifier
                    .width(410.dp)
                    .height(410.dp) // Adjust height based on expanded state
                    .border(
                        width = 0.dp,
                        color = Color(0xCCFFFFFF),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .background(Color(0xCCFFFFFF), shape = RoundedCornerShape(12.dp))
                    .padding(11.dp)
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.mouth),
                        contentDescription = "Throat Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(203.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                            .clickable { }
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row {
                            Text(
                                text = "Test ID:",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                        Row{
                            Text(
                                text = " 987654",
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))

                    }
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.riskbar),
                            contentDescription = "Throat Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(376.dp)
                                .height(11.dp)
                                .padding(start = 16.dp, end = 16.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                    ){
                        Row{
                            Text(
                                text = "Low Risk",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Start
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))

                        Row{
                            Text(
                                text = "High Risk",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.End
                            )
                        }
                    }
                    Column{
                        OutlinedButton(
                            onClick = {  },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.Red),
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = Color(0xFFFFF2F2) // Background color equivalent to rgba(255, 242, 242, 1)
                            )
                        ) {
                            Text(
                                text = "High Risk",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFF7F3E)
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Column{
                Button(
                    onClick = { navController.navigate("consultPhysician") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7745)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Text(text = "Consult A Physician", color = Color.White)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Column{
                Button(
                    onClick = { navController.navigate("addReview") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7745)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Text(text = "Leave A Review", color = Color.White)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Column{
                Button(
                    onClick = { navController.navigate("profile1") },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF7745)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(4.dp),
                ) {
                    Text(text = "Complete", color = Color.White)
                }
            }
            Spacer(modifier = Modifier.weight(1f))




            Spacer(modifier = Modifier.height(61.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Image(
                painter = painterResource(id = R.drawable.steps3), // Replace with your footer image resource
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()

            )
        }
    }
}
