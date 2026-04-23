package com.example.application.ui.screen.jajanin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.application.ui.component.global.AffordableRestaurant
import com.example.application.ui.component.global.Header
import com.example.application.ui.component.global.SearchBar
import com.example.application.ui.theme.WhiteSoft

@Composable
fun JajaninMainPage(onBack: () -> Unit) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(WhiteSoft)
                .padding(top = 80.dp)
        ) {

            stickyHeader {

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Transparent)
                        .padding(top = 12.dp, bottom = 6.dp)
                ) {

                    SearchBar(
                        placeholderText = "Mau Jajan Apa",
                    )

                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(WhiteSoft)
                        .padding(top = 8.dp)
                ) {

                    AffordableRestaurant()
                    JajaninRestaurantList()

                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
        }

        // 🔝 HEADER (FLOATING)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            Header(
                title = "Jajan-In",
                onBack = onBack
            )
        }
    }
}