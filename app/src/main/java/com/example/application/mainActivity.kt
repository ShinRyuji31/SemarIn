package com.example.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.application.ui.theme.ApplicationTheme
import androidx.navigation.compose.*
import com.example.application.ui.screen.DashboardScreen
import com.example.application.ui.screen.LandingScreen

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

                    composable("dashboard") {
                        DashboardScreen()
                    }
                }
            }
        }
    }
}