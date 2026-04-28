package com.example.application.ui.screen.anterin

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.application.ui.component.Anterin.AnterinBackground
import com.example.application.ui.component.global.Header
import com.example.application.ui.component.global.ButtonBlue
import com.example.application.ui.component.global.SearchBar

enum class MapMode {
    PICKUP,
    DESTINATION
}

@Composable
fun AnterinSearchPage(
    mode: MapMode,
    onNext: () -> Unit,
    onBack: () -> Unit
) {

    val buttonText = when (mode) {
        MapMode.PICKUP -> "Set Pick-Up Location"
        MapMode.DESTINATION -> "Set Destination"
    }

    val placeholder = when (mode) {
        MapMode.PICKUP -> "Search pick-up location"
        MapMode.DESTINATION -> "Search destination"
    }

    Box(modifier = Modifier.fillMaxSize()) {

        AnterinBackground()

        Column {
            Header(
                title = "Anter-In",
                onBack = onBack
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 110.dp)
        ) {
            SearchBar(placeholderText = placeholder)
        }

        ButtonBlue(
            text = buttonText,
            onClick = onNext,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .navigationBarsPadding()
                .padding(16.dp)
                .fillMaxWidth()
                .height(50.dp)
        )

    }
}