package com.example.application.ui.screen.anterin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

enum class AnterStep {
    PICKUP_INPUT,
    PICKUP_MAP,
    DESTINATION_INPUT,
    DESTINATION_MAP,
    DESTINATION_SET,
    FINDING_DRIVER
}

@Composable
fun AnterScreen(onBack: () -> Unit) {

    var currentStep by remember { mutableStateOf(AnterStep.PICKUP_INPUT) }

    Box(modifier = Modifier.fillMaxSize()) {

        when (currentStep) {

            AnterStep.PICKUP_INPUT -> AnterinMainPage(
                mode = MainMode.PICKUP_ONLY,
                onPickupClick = {
                    currentStep = AnterStep.PICKUP_MAP
                },
                onDestinationClick = {},
                onBack = onBack
            )

            AnterStep.PICKUP_MAP -> AnterinSearchPage(
                mode = MapMode.PICKUP,
                onNext = {
                    currentStep = AnterStep.DESTINATION_INPUT
                },
                onBack = {
                    currentStep = AnterStep.PICKUP_INPUT
                }
            )

            AnterStep.DESTINATION_INPUT -> AnterinMainPage(
                mode = MainMode.PICKUP_AND_DESTINATION,
                onPickupClick = {
                    currentStep = AnterStep.PICKUP_MAP
                },
                onDestinationClick = {
                    currentStep = AnterStep.DESTINATION_MAP
                },
                onBack = onBack
            )

            AnterStep.DESTINATION_MAP -> AnterinSearchPage(
                mode = MapMode.DESTINATION,
                onNext = {
                    currentStep = AnterStep.DESTINATION_SET
                },
                onBack = {
                    currentStep = AnterStep.DESTINATION_INPUT
                }
            )

            AnterStep.DESTINATION_SET -> AnterinDestinationSetPage(
                onBack = {
                    currentStep = AnterStep.DESTINATION_INPUT
                },
                onFindDriver = {
                    currentStep = AnterStep.FINDING_DRIVER
                }
            )

            AnterStep.FINDING_DRIVER -> AnterinFindingDriverPage(
                state = DriverState.FINDING,
                onBack = {
                    currentStep = AnterStep.DESTINATION_SET
                }
            )
        }
    }
}
