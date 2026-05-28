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
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val userRepository: UserRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ApplicationTheme {
                val backStack = remember { mutableStateListOf<Routes>(Routes.LandingRoute) }
                val currentRoute = backStack.lastOrNull() ?: Routes.LandingRoute
                
                val sessionStatus by userRepository.sessionStatus.collectAsState(SessionStatus.Initializing)

                LaunchedEffect(sessionStatus) {
                    when (sessionStatus) {
                        is SessionStatus.Authenticated -> {
                            if (backStack.any { it is Routes.LandingRoute || it is Routes.LoginRoute || it is Routes.SignUpRoute }) {
                                backStack.clear()
                                backStack.add(Routes.DashBoardRoute)
                            }
                        }
                        is SessionStatus.NotAuthenticated -> {
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
