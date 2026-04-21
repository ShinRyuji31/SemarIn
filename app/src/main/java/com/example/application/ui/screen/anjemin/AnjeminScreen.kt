package com.example.application.ui.screen.anjemin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

enum class AnjemStep {
    PICKUP_INPUT,
    PICKUP_MAP,
    DESTINATION_INPUT,
    DESTINATION_MAP,
    DESTINATION_SET,
    FINDING_DRIVER
}

@Composable
fun AnjemScreen(navController: NavController) {

    var currentStep by remember { mutableStateOf(AnjemStep.PICKUP_INPUT) }

    Box(modifier = Modifier.fillMaxSize()) {

        when (currentStep) {

            AnjemStep.PICKUP_INPUT -> AnjeminMainPage(
                mode = MainMode.PICKUP_ONLY,
                onPickupClick = {
                    currentStep = AnjemStep.PICKUP_MAP
                },
                onDestinationClick = {}
            )

            AnjemStep.PICKUP_MAP -> AnjeminSearchPage(
                mode = MapMode.PICKUP,
                onNext = {
                    currentStep = AnjemStep.DESTINATION_INPUT
                },
                onBack = {
                    currentStep = AnjemStep.PICKUP_INPUT
                }
            )

            AnjemStep.DESTINATION_INPUT -> AnjeminMainPage(
                mode = MainMode.PICKUP_AND_DESTINATION,
                onPickupClick = {
                    currentStep = AnjemStep.PICKUP_MAP
                },
                onDestinationClick = {
                    currentStep = AnjemStep.DESTINATION_MAP
                }
            )

            AnjemStep.DESTINATION_MAP -> AnjeminSearchPage(
                mode = MapMode.DESTINATION,
                onNext = {
                    currentStep = AnjemStep.DESTINATION_SET
                },
                onBack = {
                    currentStep = AnjemStep.DESTINATION_INPUT
                }
            )

            AnjemStep.DESTINATION_SET -> AnjeminDestinationSetPage(
                onBack = {
                    currentStep = AnjemStep.DESTINATION_INPUT
                },
                onFindDriver = {
                    currentStep = AnjemStep.FINDING_DRIVER
                }
            )

            AnjemStep.FINDING_DRIVER -> AnjeminFindingDriverPage(
                state = DriverState.FINDING,
                onBack = {
                    currentStep = AnjemStep.DESTINATION_SET
                }
            )
        }
    }
}