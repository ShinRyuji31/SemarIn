package com.example.application.ui.screen.anterin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.R
import com.example.application.ui.component.global.Header
import com.example.application.ui.theme.BluePrimary

enum class DriverState {
    FINDING,
    FOUND
}

@Composable
fun AnterinFindingDriverPage(
    state: DriverState,
    onBack: () -> Unit
) {

    val title = when (state) {
        DriverState.FINDING -> "Hold on tight."
        DriverState.FOUND -> "Horay!"
    }

    val subtitle = when (state) {
        DriverState.FINDING -> "We are finding a driver for you"
        DriverState.FOUND -> "We have found you a driver"
    }

    val image = when (state) {
        DriverState.FINDING -> R.drawable.logo_coloredbike
        DriverState.FOUND -> R.drawable.ic_star
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                BluePrimary
            )
    ) {

        Column {
            Header(
                title = "Anter-In",
                onBack = onBack
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 120.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(32.dp))

            Icon(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.size(120.dp),
                tint = Color.Unspecified
            )
        }
    }
}