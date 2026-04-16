package com.example.application.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.application.ui.component.ButtonBlue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.application.ui.component.TextFieldOutlineRegular
import com.example.application.ui.theme.blueWhiteGradient

@Composable
fun LoginScreen(navController: NavController) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = blueWhiteGradient())
    ) {

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

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "Login",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(24.dp))

                // 🔥 USERNAME
                TextFieldOutlineRegular(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = "Username"
                )

                // 🔥 PASSWORD
                TextFieldOutlineRegular(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "Password",
                    isPassword = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                ButtonBlue(
                    text = "Login",
                    onClick = {
                        if (username.isNotEmpty() && password.isNotEmpty()) {
                            navController.navigate("dashboard") {
                                popUpTo("landing") { inclusive = true }
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Don’t have an account? Sign Up",
                    modifier = Modifier.clickable {
                        navController.navigate("signup")
                    }
                )
            }
        }
    }
}