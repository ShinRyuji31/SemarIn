package com.example.application.ui.screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.application.ui.component.dashboard.*

@Composable
fun DashboardScreen() {

    val scrollState = rememberScrollState()

    val isScrolled = scrollState.value > 50

    val headerHeight by animateDpAsState(
        targetValue = if (isScrolled) 70.dp else 110.dp,
        label = ""
    )

    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = { BottomNavBar() }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.background
                        )
                    )
                )
                .verticalScroll(scrollState)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(headerHeight)
            ) {
                HeaderSection()
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-20).dp)
                    .shadow(
                        8.dp,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .padding(top = 16.dp)
            ) {

                SearchSection()
                ServiceMenu()
                PromoSection()
                RestoSection()
                LastOrderSection()
                BannerSection()

                Spacer(modifier = Modifier.height(80.dp)) // biar nggak ketutup navbar
            }
        }
    }
}