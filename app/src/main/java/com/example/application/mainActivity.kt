package com.example.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.application.ui.theme.ApplicationTheme
import androidx.navigation.compose.*
import com.example.application.ui.screen.DashboardScreen
import com.example.application.ui.screen.LandingScreen
import com.example.application.ui.screen.LoginScreen
import com.example.application.ui.screen.ProfileScreen
import com.example.application.ui.screen.SignUpScreen
import com.example.application.ui.screen.anjemin.AnjemScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ApplicationTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "landing"
                ) {
                    composable("landing") {
                        LandingScreen(navController)
                    }

                    composable("login") {
                        LoginScreen(navController)
                    }

                    composable("signup") {
                        SignUpScreen(navController)
                    }

                    composable("dashboard") {
                        DashboardScreen(navController)
                    }

                    composable("profile") {
                        ProfileScreen(navController)
                    }

                    composable("anjem") {
                        AnjemScreen(navController)
                    }
                }
            }
        }
    }
}