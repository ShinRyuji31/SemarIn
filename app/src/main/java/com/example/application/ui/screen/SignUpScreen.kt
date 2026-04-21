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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.application.ui.component.global.ButtonBlue
import com.example.application.ui.component.global.TextFieldOutlineRegular
import com.example.application.ui.theme.blueWhiteGradient
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.clickable
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import com.example.application.R
import com.example.application.ui.component.global.ButtonSocial

@Composable
fun SignUpScreen(navController: NavController) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }

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

                Text("Sign Up", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Username",
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = Bold,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(2.dp))

                TextFieldOutlineRegular(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = "Username"
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Password",
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = Bold,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(2.dp))

                TextFieldOutlineRegular(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = "Password"
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Confirm Password",
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = Bold,
                    fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(2.dp))

                TextFieldOutlineRegular(
                    value = confirm,
                    onValueChange = { confirm = it },
                    placeholder = "Confirm Password"
                )

                Spacer(modifier = Modifier.height(16.dp))

                ButtonBlue(
                    text = "Sign Up",
                    onClick = {
                        if (username.isNotEmpty() &&
                            password.isNotEmpty() &&
                            password == confirm
                        ) {
                            navController.navigate("dashboard")
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    ButtonSocial(icon = R.drawable.logo_google)
                    ButtonSocial(icon = R.drawable.logo_facebook)

                }

                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Already have an account? Login",
                    modifier = Modifier.clickable {
                        navController.navigate("login")
                    }
                )
            }
        }
    }
}