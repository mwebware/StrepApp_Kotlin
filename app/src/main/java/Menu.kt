import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_strepapp.R
import androidx.compose.foundation.rememberScrollState
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu(navController: NavController, modifier: Modifier = Modifier) {

    val scrollState = rememberScrollState()

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


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(130.dp)
                    .height(108.dp)
                    .aspectRatio(1.2f),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
//            .background(Color(0xFFE3ECFF)) // Light blue background
            ) {
                // Individual menu items with separate click listeners
                MenuItem("Welcome", R.drawable.home) {  }
                Divider(modifier = Modifier.height(0.5.dp), color = Color.White)

                MenuItem("Start Test", R.drawable.plussquare) {navController.navigate("starttest1") }
                Divider(modifier = Modifier.height(0.5.dp), color = Color.White)

                MenuItem("How To Use", R.drawable.helpcircle) { navController.navigate("howToUse1") }
                Divider(modifier = Modifier.height(0.5.dp), color = Color.White)

                MenuItem("Family Members", R.drawable.users) { navController.navigate("familymembers") }
                Divider(modifier = Modifier.height(0.5.dp), color = Color.White)

                MenuItem("Subscription", R.drawable.creditcard) { navController.navigate("subscription") }
                Divider(modifier = Modifier.height(0.5.dp), color = Color.White)

                MenuItem("About the App", R.drawable.lock) {navController.navigate("about") }
                Divider(modifier = Modifier.height(0.5.dp), color = Color.White)

                MenuItem("Terms and Conditions", R.drawable.checksquare) { navController.navigate("terms")}
                Divider(modifier = Modifier.height(0.5.dp), color = Color.White)

                MenuItem("Privacy and Security", R.drawable.shield) { /* Handle Privacy and Security click */ }
                Divider(modifier = Modifier.height(0.5.dp), color = Color.White)

                MenuItem("Customer Support", R.drawable.lifebuoy) { navController.navigate("customerSupport") }
                Divider(modifier = Modifier.height(0.5.dp), color = Color.White)

                MenuItem("Settings", R.drawable.settings) { navController.navigate("settings")  }
                Divider(modifier = Modifier.height(0.5.dp), color = Color.White)

                MenuItem("Logout", R.drawable.logout) {navController.navigate("login1") }
            }
        }
    }
}

@Composable
fun MenuItem(title: String, iconResId: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Image icon
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = "$title Icon",
            tint = Color.White, // Apply white color to the icon
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = title,
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
    }
}

