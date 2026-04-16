package com.example.application.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.example.application.ui.component.dashboard.BannerSection
import com.example.application.ui.component.dashboard.BottomNavBar
import com.example.application.ui.component.dashboard.HeaderSection
import com.example.application.ui.component.dashboard.LastOrderSection
import com.example.application.ui.component.dashboard.PromoSection
import com.example.application.ui.component.dashboard.RestoSection
import com.example.application.ui.component.dashboard.SearchSection
import com.example.application.ui.component.dashboard.ServiceMenu
import com.example.application.ui.theme.ApplicationTheme

@Composable
fun DashboardScreen() {

    Scaffold(
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
                .verticalScroll(rememberScrollState())
        ) {

            HeaderSection()
            SearchSection()
            ServiceMenu()
            PromoSection()
            RestoSection()
            LastOrderSection()
            BannerSection()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashBoardPreview (){
    ApplicationTheme() {
        DashboardScreen()
    }
}