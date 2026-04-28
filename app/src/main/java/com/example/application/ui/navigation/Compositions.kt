package com.example.application.ui.navigation

import androidx.compose.runtime.Composable
import com.example.application.ui.screen.*
import com.example.application.ui.screen.anterin.AnterScreen
import com.example.application.ui.screen.jajanin.JajaninMainPage

@Composable
fun AppNavigation(
    currentRoute: Routes,
    onNavigate: (Routes) -> Unit,
    onBack: () -> Unit
) {
    when (currentRoute) {

        is Routes.LandingRoute -> LandingScreen(
            onLoginClick = { onNavigate(Routes.LoginRoute) },
            onSignUpClick = { onNavigate(Routes.SignUpRoute) }
        )

        is Routes.LoginRoute -> LoginScreen(
            onLoginSuccess = { onNavigate(Routes.DashBoardRoute) },
            onGoToSignUp = { onNavigate(Routes.SignUpRoute) }
        )

        is Routes.SignUpRoute -> SignUpScreen(
            onRegisterSuccess = { onNavigate(Routes.DashBoardRoute) },
            onLoginClick = {
                onNavigate(Routes.LoginRoute) }
        )

        is Routes.DashBoardRoute -> DashboardScreen(
            onProfileClick = { onNavigate(Routes.ProfileRoute) },
            onAnjeminClick = { onNavigate(Routes.AnjeminScreenRoute) },
            onJajaninClick = { onNavigate(Routes.JajaninMainRoute) }
        )

        is Routes.ProfileRoute -> ProfileScreen(
            onBack = onBack,
            onHomeClick = { onNavigate(Routes.DashBoardRoute) }
        )

        is Routes.AnjeminScreenRoute -> AnterScreen(
            onBack = onBack
        )

        is Routes.JajaninMainRoute -> JajaninMainPage(
            onBack = onBack,
            onCategoryClick = { categoryName ->
                onNavigate(Routes.JajaninRestaurantListRoute(categoryName))
            }
        )
        else -> {}
    }
}
