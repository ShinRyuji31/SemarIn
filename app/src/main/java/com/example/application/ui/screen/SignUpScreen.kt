package com.example.application.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.ui.component.ButtonBlue
import com.example.application.ui.component.ButtonWhite
import com.example.application.ui.component.TextFieldOutlineRegular
import com.example.application.ui.theme.ApplicationTheme
import com.example.application.ui.theme.blueWhiteGradient

@Composable
fun SignUpScreen (){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = blueWhiteGradient()
            )
    ) {

        // CARD
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .align(Alignment.Center)
                .background(
                    color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(24.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // TITLE
                Text(
                    text = "Sign Up",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                // USERNAME
                TextFieldOutlineRegular(
                    text = "Username"
                )

                // PASSWORD
                TextFieldOutlineRegular(
                    text = "Password"
                )

                TextFieldOutlineRegular(
                    text = "Confirm Password"
                )

                // LOGIN BUTTON
                ButtonBlue(
                    text = "Sign Up",
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // OR TEXT
                Text(
                    text = "or login with",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // SOCIAL BUTTON
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    ButtonWhite(
                        text = "G",
                        onClick = {},
                        modifier = Modifier
                            .weight(1f)
                            .height(45.dp)
                    )

                    ButtonBlue(
                        text = "f",
                        onClick = {},
                        modifier = Modifier
                            .weight(1f)
                            .height(45.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // SIGN UP
                Text(
                    text = "Already have an account? Login",
                    fontSize = 12.sp
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SignupPreview (){
//    ApplicationTheme() {
//        SignUpScreen()
//    }
//}
