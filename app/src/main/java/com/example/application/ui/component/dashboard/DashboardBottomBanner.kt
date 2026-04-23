package com.example.application.ui.component.dashboard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.R
import com.example.application.ui.theme.BlackSoft
import com.example.application.ui.theme.GrayDark
import com.example.application.ui.theme.GrayMedium
import com.example.application.ui.theme.WhiteSoft

@Composable
fun DashboardBottomBanner() {

    val banners = listOf(
        R.drawable.banner_anterin,
        R.drawable.banner_titipin
    )

    Column(modifier = Modifier.padding(16.dp)) {

        banners.forEach { banner ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(
                    1.dp,
                    GrayMedium
                )
            ) {

                Column {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    ) {

                        Image(
                            painter = painterResource(banner),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Column(
                        modifier = Modifier
                            .background(WhiteSoft)
                            .padding(12.dp)
                    ) {

                        Text(
                            text = "Anter-In Lagi Disini",
                            fontWeight = FontWeight.Bold,
                            color = BlackSoft,
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Saya akan kembali ke Solo sebagai rakyat biasa Saya akan kembali ke Solo sebagai rakyat biasa...",
                            fontSize = 12.sp,
                            color = GrayDark,
                            maxLines = 2
                        )
                    }
                }
            }
        }
    }
}