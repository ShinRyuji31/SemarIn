package com.example.application.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.ui.component.dashboard.*

@Composable
fun DashboardScreen() {

    val listState = rememberLazyListState()

    val isScrolled = listState.firstVisibleItemIndex > 0 ||
            listState.firstVisibleItemScrollOffset > 50

    Scaffold(
        bottomBar = { BottomNavBar() }
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
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.background
                            )
                        )
                    )
                    .padding(top = 40.dp)
            ) {

                item {
                    AnimatedVisibility(visible = !isScrolled) {
                        Text(
                            "Hi Jackowi 👋\nNeed Something?",
                            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 16.dp),
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
                        SearchSection()
                    }
                }

                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                MaterialTheme.colorScheme.background,
                            )
                            .padding(top = 8.dp)
                    ) {

                        PromoSection()
                        ServiceMenu()
                        LastOrderSection()
                        RestoSection()
                        BannerSection()

                        Spacer(modifier = Modifier.height(80.dp))
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
            ) {
                HeaderSection()
            }
        }
    }
}