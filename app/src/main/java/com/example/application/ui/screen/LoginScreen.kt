package com.example.application.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.ui.component.ButtonBlue
import com.example.application.ui.component.ButtonWhite
import com.example.application.ui.theme.ApplicationTheme
import com.example.application.ui.theme.blueWhiteGradient

@Composable
fun LoginScreen() {

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
                    text = "Login",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                // USERNAME
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("Username") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                // PASSWORD
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                )

                // LOGIN BUTTON
                ButtonBlue(
                    text = "Login",
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
                    text = "Don’t have an account? Sign Up",
                    fontSize = 12.sp
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun loginPreview (){
//    ApplicationTheme() {
//        LoginScreen()
//    }
//}