import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.android_strepapp.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
@Composable
fun Desclaimer(navController: NavController) {
    val scrollState = rememberScrollState()
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF5EA6D1))
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.bgimage11),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .offset(x = 0.dp, y = 0.dp)
            ) {

                Spacer(modifier = Modifier.height(22.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(100.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.backicon),
                        contentDescription = "Go back",
                        modifier = Modifier.size(36.dp)
                            .clickable { navController.navigate("register1") }
                    )
                    Text(
                        text = "Desclaimer",
                        color = Color.White,
                        fontSize = 30.sp,
                        modifier = Modifier
                            .offset(x = -30.dp, y = 0.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                TermsContent(navController)
            }
        }
    }
}


@Composable
private fun TermsContent(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xCCFFFFFF).copy(alpha = 0.8f),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(25.dp)
            .height(1000.dp)
            .verticalScroll(scrollState),

    ) {
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc sagittis tellus nisl, vel tempor lacus mollis in. Nullam pretium mi risus, non fringilla odio molestie et. Vivamus et dui ut velit fermentum viverra. Ut faucibus arcu nec pharetra accumsan. Nulla malesuada metus in augue suscipit, eget ornare ex interdum. Nunc sagittis orci sollicitudin lobortis vulputate. Aenean at lectus aliquam, blandit dolor non, tincidunt mi. Suspendisse malesuada arcu sit amet libero ornare maximus. Proin ullamcorper nisl eu ipsum interdum gravida.\n\nSuspendisse sed consequat dui, id auctor est. Sed vel sodales diam. Phasellus eu tincidunt sapien. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut laoreet porttitor ante, sit amet ullamcorper arcu pulvinar et. Fusce id dolor at lectus egestas auctor. Proin rhoncus venenatis euismod. Suspendisse aliquet sit amet magna et porttitor. Aliquam porta tempor felis eget efficitur. Quisque eget porttitor lorem.",
            fontSize = 18.sp,
            lineHeight = 23.sp
        )

        Spacer(modifier = Modifier.height(47.dp))

        Button(
            onClick = {   navController.navigate("register1") },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF7F3E)
            ),
            shape = RoundedCornerShape(6.dp)
        ) {
            Text(
                text = "Close",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(19.dp))

    }
}