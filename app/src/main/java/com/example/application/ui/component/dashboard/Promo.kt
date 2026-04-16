package com.example.application.ui.component.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PromoSection() {
    Column(modifier = Modifier.padding(16.dp)) {

        Text("Semar Promo Cek!!", fontWeight = FontWeight.Bold)

        LazyRow {
            items(5) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(200.dp, 100.dp)
                        .background(Color.Yellow, RoundedCornerShape(16.dp))
                )
            }
        }
    }
}