package com.example.application.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Routes : NavKey {

    @Serializable
    data object LandingRoute : Routes

    @Serializable
    data object LoginRoute : Routes

    @Serializable
    data object SignUpRoute : Routes

    @Serializable
    data object DashBoardRoute : Routes

    @Serializable
    data object ProfileRoute : Routes

    @Serializable
    data object AnjeminScreenRoute : Routes

    @Serializable
    data object JajaninMainRoute : Routes

    @Serializable
    data class JajaninRestaurantListRoute(
        val category: String
    ) : Routes
}