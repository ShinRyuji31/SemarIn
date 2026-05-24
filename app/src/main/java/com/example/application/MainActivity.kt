package com.example.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.application.auth.data.repository.UserRepository
import com.example.application.global.ui.navigation.AppNavigation
import com.example.application.global.ui.navigation.Routes
import com.example.application.global.ui.theme.ApplicationTheme
import io.github.jan.supabase.auth.status.SessionStatus

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ApplicationTheme {
                val backStack = remember { mutableStateListOf<Routes>(Routes.LandingRoute) }
                // Use a safe way to get the current route that won't crash during clear()
                val currentRoute = backStack.lastOrNull() ?: Routes.LandingRoute
                
                val repository = remember { UserRepository.getInstance() }
                val sessionStatus by repository.sessionStatus.collectAsState(SessionStatus.Initializing)

                LaunchedEffect(sessionStatus) {
                    when (sessionStatus) {
                        is SessionStatus.Authenticated -> {
                            // If we are on a guest-only screen, move to dashboard
                            if (backStack.any { it is Routes.LandingRoute || it is Routes.LoginRoute || it is Routes.SignUpRoute }) {
                                backStack.clear()
                                backStack.add(Routes.DashBoardRoute)
                            }
                        }
                        is SessionStatus.NotAuthenticated -> {
                            // If we are on a protected screen, move to landing
                            if (backStack.any { it is Routes.DashBoardRoute || it is Routes.ProfileRoute }) {
                                backStack.clear()
                                backStack.add(Routes.LandingRoute)
                            }
                        }
                        else -> {}
                    }
                }
                
                if (sessionStatus !is SessionStatus.Initializing) {
                    AppNavigation(
                        currentRoute = currentRoute,
                        onNavigate = { newRoute ->
                            // Simple logic: if navigating to a "root" screen, clear stack
                            if (newRoute is Routes.DashBoardRoute || newRoute is Routes.LandingRoute) {
                                backStack.clear()
                            }
                            backStack.add(newRoute)
                        },
                        onBack = {
                            if (backStack.size > 1) {
                                backStack.removeAt(backStack.size - 1)
                            }
                        }
                    )
                }
            }
        }
    }
}
