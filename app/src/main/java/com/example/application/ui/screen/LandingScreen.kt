package com.example.application.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.application.R
import com.example.application.ui.component.ButtonBlue
import com.example.application.ui.component.ButtonWhite
import com.example.application.ui.theme.blueWhiteGradient

@Composable
fun LandingScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        // 🔵 TOP SECTION (Gradient Background)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(550.dp)
                .background(
                    brush = blueWhiteGradient()
                    )
                )
        {

            // 🚚 IMAGE DELIVERY
            Image(
                painter = painterResource(R.drawable.landing_delivery),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 40.dp)
            )

            // 🌊 CURVE
            Image(
                painter = painterResource(R.drawable.landing_bg_curve),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .align(Alignment.BottomCenter)
            )
        }

        // ⚪ BOTTOM CARD CONTENT
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .align(Alignment.BottomCenter)
                .background(MaterialTheme.colorScheme.background)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 28.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Quick delivery at your home address",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Let us take care of your needs!",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(24.dp))

                ButtonBlue(
                    text = "Login",
                    onClick = {
                        navController.navigate("dashboard")
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                ButtonWhite(
                    text = "Sign Up",
                    onClick = {},
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp)
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun LandingPreview() {
//    ApplicationTheme {
//        LandingScreen()
//    }
//}