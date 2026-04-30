package com.example.application.ui.screen.jajanin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.application.R
import com.example.application.ui.component.global.Header
import com.example.application.ui.component.jajanin.JajaninInfoCard
import com.example.application.ui.component.jajanin.menu.JajaninMenuSection
import com.example.application.ui.component.jajanin.menu.dummyMenu

@Composable
fun JajaninDetailPage(
    onBack: () -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            item {
                Image(
                    painter = painterResource(id = R.drawable.change_this_to_correct_pic),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    contentScale = ContentScale.Crop
                )
            }

            item {
                Box(
                    modifier = Modifier
                        .offset(y = (-30).dp)
                        .padding(horizontal = 16.dp)
                        .background(
                            Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(16.dp)
                ) {
                    JajaninInfoCard()
                }
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))

                JajaninMenuSection(
                    title = "Cream Puff Party Collections",
                    items = dummyMenu
                )

                JajaninMenuSection(
                    title = "The Eclair",
                    items = dummyMenu
                )

                JajaninMenuSection(
                    title = "Signature Pie Cream Puff",
                    items = dummyMenu
                )

                JajaninMenuSection(
                    title = "Classic Eclair",
                    items = dummyMenu
                )

                JajaninMenuSection(
                    title = "Mini Cream Puff",
                    items = dummyMenu
                )

                Spacer(modifier = Modifier.height(80.dp))
            }
        }

        Box(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Header(
                title = "Jajan-In",
                onBack = onBack
            )
        }
    }
}