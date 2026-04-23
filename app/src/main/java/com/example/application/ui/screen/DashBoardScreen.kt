package com.example.application.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// 🌟 HAPUS import NavController
import com.example.application.ui.component.dashboard.*
import com.example.application.ui.component.global.AffordableRestaurant
import com.example.application.ui.component.global.SearchBar

@Composable
// 🌟 PERUBAHAN 1: Ganti NavController dengan 3 parameter fungsi
fun DashboardScreen(
    onProfileClick: () -> Unit,
    onAnjeminClick: () -> Unit,
    onJajaninClick: () -> Unit
) {

    val listState = rememberLazyListState()

    val isScrolled = listState.firstVisibleItemIndex > 0 ||
            listState.firstVisibleItemScrollOffset > 50

    Scaffold(
        bottomBar = {
            // 🌟 PERUBAHAN 2: Oper fungsi onProfileClick ke BottomNavBar
            DashboardBottomNavBar(
                currentTab = 0,
                onHomeClick = { },
                onProfileClick = onProfileClick
            )
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(top = 50.dp)
            ) {

                item {
                    AnimatedVisibility(visible = !isScrolled) {
                        Text(
                            "Hi Jackowi 👋\nNeed Something?",
                            modifier = Modifier.padding(
                                top = 16.dp,
                                bottom = 4.dp,
                                start = 16.dp
                            ),
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }

                stickyHeader {
                    Box(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .padding(vertical = 16.dp)
                    ) {
                        SearchBar(placeholderText = "Cari Kebutuhanmu")
                    }
                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.background)
                            .padding(top = 4.dp)
                    ) {

                        DasboardTopBanner()

                        // 🌟 PERUBAHAN 3: Oper fungsi ke ServiceSection
                        DashboardServiceSection(
                            onAnjeminClick = onAnjeminClick,
                            onJajaninClick = onJajaninClick
                        )

                        DashboardLastOrder()
                        AffordableRestaurant()
                        DashboardBottomBanner()

                        Spacer(modifier = Modifier.height(80.dp))
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            ) {
                DashboardHeader()
            }
        }
    }
}