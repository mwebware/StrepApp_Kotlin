import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.android_strepapp.R

@Composable
fun FamilyMembers(navController: NavController, modifier: Modifier = Modifier) {
    val familyMembers = listOf(
        FamilyMember("Jane Doe", "22 Years, Female", R.drawable.sample1),
        FamilyMember("Ben Doe", "10 Years, Male", R.drawable.sample1),
        FamilyMember("John Doe", "24 Years, Male", R.drawable.sample1),
        FamilyMember("Emma Doe", "18 Years, Female", R.drawable.doctor2),
        FamilyMember("Alice Doe", "30 Years, Female", R.drawable.sample1)
    )

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
        Box(
            modifier = Modifier
                .fillMaxSize() // Ensures the Box takes the full screen space
        ) {
            Image(
                painter = painterResource(id = R.drawable.bgimage11), // Replace with your drawable resource
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Footer Content
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


        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Header Row
            Row(
                modifier = Modifier
                    .padding(top = 35.dp, bottom = 16.dp)
                    .align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.backicon),
                    contentDescription = "Go back",
                    modifier = Modifier
                        .size(36.dp)
                        .clickable { navController.navigate("profile1") }
                )
                Text(
                    text = "Family Members",
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier.offset(x = -5.dp, y = 0.dp),
                )
                Image(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = "Add Family Member",
                    modifier = Modifier
                        .size(36.dp)
                        .clickable { navController.navigate("profile2/First Name/Family Member Details/${R.drawable.profileimage1}") }
                )
            }

            // LazyVerticalGrid for displaying family members in two columns
            LazyVerticalGrid(
                columns = GridCells.Fixed(2), // Two items in a row
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                .padding(bottom = 90.dp, top = 30.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(familyMembers) { member ->
                    FamilyMemberCard(
                        name = member.name,
                        details = member.details,
                        imageRes = member.imageRes,
                        onTestHistoryClick  = {
                            navController.navigate("testHistory/${member.name}/${member.details}/${member.imageRes}")
                        },
                        onViewProfileClick = {
                            navController.navigate("profile2/${member.name}/${member.details}/${member.imageRes}")
                        },
                    )
                }
            }
        }
    }
}

data class FamilyMember(val name: String, val details: String, val imageRes: Int)

@Composable
fun FamilyMemberCard(
    name: String,
    details: String,
    imageRes: Int,
    onViewProfileClick: () -> Unit,
    onTestHistoryClick:() -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background( color = Color(255, 255, 255, 204), RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .background(Color.White, CircleShape)
                .padding(4.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = details,
            fontSize = 12.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                onClick = onViewProfileClick  ,
                colors = ButtonDefaults.buttonColors(Color(0xFFFF6F3F)),

            ) {
                Text("View Profile", color = Color.White, fontSize = 12.sp)
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                onClick = onTestHistoryClick ,
                colors = ButtonDefaults.buttonColors(Color(0xFFFF6F3F))
            ) {
                Text("Test History", color = Color.White, fontSize = 12.sp)
            }
        }
    }
}


@Composable
fun SmallButton(text: String, backgroundColor: Color) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
        modifier = Modifier.width(160.dp)

    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FamilyMembersPreview() {
    val mockNavController = rememberNavController()
    FamilyMembers(navController = mockNavController)
}
