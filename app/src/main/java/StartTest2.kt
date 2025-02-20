    import androidx.compose.foundation.Image
    import androidx.compose.foundation.background
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.Button
    import androidx.compose.material3.ButtonDefaults
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.compose.material3.Divider
    import androidx.navigation.NavController
    import com.example.android_strepapp.R

    @Composable
    fun StartTest2(navController: NavController, modifier: Modifier = Modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF5EA6D1))
        ) {
            Image(
                painter = painterResource(id = R.drawable.bgimage11),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 35.dp, bottom = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.backicon),
                            contentDescription = "Go back",
                            modifier = Modifier
                                .size(36.dp)
                                .clickable { navController.navigate("starttest1") }
                        )
                        Spacer(modifier = Modifier.weight(1f)) // This spacer helps distribute space
                    }

                    Text(
                        text = "Good Evening,Jane",
                        color = Color.White,
                        fontSize = 30.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                Spacer(modifier = Modifier.height(84.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {

                Text(
                    text = "  Let's start your \n\n strep throat test",
                    fontSize = 30.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(42.dp))

                Text(
                    text = "It'll take about 5 minutes.",
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(59.dp))

                Text(
                    text = "Test steps",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                TestSteps()

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = { navController.navigate("symptoms1") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFF7F3E)
                    ),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = "Start",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
            }
        }
    }

    @Composable
    fun TestSteps() {
        Column(
            modifier = Modifier.padding(start = 30.dp, end = 30.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Spacer(modifier = Modifier.height(46.dp))

            StepItem(number = "1", text = "Enter symptoms")

            Divider(
                color = Color.White,
                modifier = Modifier
                    .width(337.dp)
                    .padding(vertical = 10.dp)
            )

            StepItem(number = "2", text = "Take throat picture")

            Divider(
                color = Color.White,
                modifier = Modifier
                    .width(337.dp)
                    .padding(vertical = 10.dp)
            )

            StepItem(number = "3", text = "Complete test")
        }
    }

    @Composable
    fun StepItem(number: String, text: String) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFF6921E)
                )
            }

            Text(
                text = text,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }
    }
