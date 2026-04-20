package com.example.application.ui.component.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.R

@Composable
fun BannerSection() {

    val banners = listOf(
        R.drawable.promo_semar_ride,
        R.drawable.promo_semar_send
    )

    Column(modifier = Modifier.padding(16.dp)) {

        banners.forEach { banner ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                shape = RoundedCornerShape(16.dp)
            ) {

                Column {

                    // 🔥 IMAGE + TEXT OVERLAY
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(160.dp)
                    ) {

                        Image(
                            painter = painterResource(banner),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                        // 🔥 overlay biar text kebaca
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    androidx.compose.ui.graphics.Brush.verticalGradient(
                                        listOf(
                                            Color.Transparent,
                                            Color.Black.copy(alpha = 0.5f)
                                        )
                                    )
                                )
                        )

                        Text(
                            text = "Semar Ride\nLagi Disini",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(12.dp)
                        )
                    }

                    // 🔽 DESKRIPSI BAGIAN BAWAH
                    Column(
                        modifier = Modifier
                            .background(Color(0xFFF5F5F5))
                            .padding(12.dp)
                    ) {

                        Text(
                            text = "Anjem-In Lagi Disini",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )

                        Text(
                            text = "Saya akan kembali ke Solo sebagai rakyat biasa Saya akan kembali ke Solo sebagai rakyat biasa...",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            maxLines = 2
                        )
                    }
                }
            }
        }
    }
}