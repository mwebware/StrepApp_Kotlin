import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_strepapp.R

@Composable
fun FaceIdSection() {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 24.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.faceid),
            contentDescription = "FaceId",
            modifier = Modifier
                .offset(x = 0.dp,
                    y = -70.dp)
                .width(30.dp)
                .height(30.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Use Face ID",
            modifier = Modifier
                .offset(x = 0.dp,
                    y = -70.dp),
            fontSize = 12.sp,
            color = Color(0x70000000)
        )

    }
}