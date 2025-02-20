import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.android_strepapp.R
import androidx.navigation.compose.rememberNavController

@Composable
fun StartTest1(navController: NavController, modifier: Modifier = Modifier ,viewModel: SymptomsViewModel) {
    val users = listOf(
        User("Jane Doe", "22 Years, Female", R.drawable.sample1),
        User("Ben Doe", "10 Years, Male", R.drawable.profileimage),
        User("John Doe", "24 Years, Male", R.drawable.sample1),
        User("Emma Doe", "18 Years, Female", R.drawable.sample1),
        User("Alice Doe", "30 Years, Female", R.drawable.sample1)

    )
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.bgimage11), // Replace with your drawable resource
            contentDescription = null,
            contentScale = ContentScale.Crop, // Ensure the image fills the box
            modifier = Modifier.fillMaxSize() // Cover the entire box
        )
    // Main Column
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top =35.dp, bottom = 16.dp),
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
                text = "Start Test",
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
        // Scrollable list of user cards
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            users.forEach { user: User ->
                UserCard( user = user,
                    navController = navController,
                    viewModel = viewModel)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
    }
        }
}
@Composable
fun UserCard(    user: User,
                 navController: NavController,
                 viewModel: SymptomsViewModel) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xCCFFFFFF)),
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp) // Adjust height to give space for the button
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile Image
            Image(
                painter = painterResource(user.imageRes),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(106.dp)
                    .clip(RoundedCornerShape(50))
                    .border(5.dp, Color.White, RoundedCornerShape(50))
            )

            Spacer(modifier = Modifier.width(16.dp))

            // User Info and Button
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween // Space between text and button
            ) {
                // User Info
                Column {
                    Text(
                        text = user.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = user.details,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }

                // Start Button
                OutlinedButton(
                    onClick = {
                        viewModel.clearSymptoms()
                        navController.navigate("starttest2") },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFFFF7F3E)), // Default outlined border
                    colors = ButtonDefaults.outlinedButtonColors( // Transparent background and colored content
                        containerColor = Color.Transparent, // Background transparent
                        contentColor = Color(0xFFEF7A62) // Text and border color
                    ),
                    modifier = Modifier
                        .align(Alignment.Start) // Align button to the start

                ) {
                    Text(text = "Start", color = Color(0xFFEF7A62))
                }
            }
        }
    }
}

data class User(val name: String, val details: String, val imageRes: Int)


