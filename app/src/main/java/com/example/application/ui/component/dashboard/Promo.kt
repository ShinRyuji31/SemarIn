package com.example.application.ui.component.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.R

@Composable
fun PromoSection() {
    // Mock data untuk daftar promo
    val promos = List(5) { R.drawable.banner_promo }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        // Judul Section
        Text(
            text = "Semar Promo Cek!!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        // List Promo Horizontal
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(promos) { promo ->
                Image(
                    painter = painterResource(id = promo),
                    contentDescription = "Banner Promo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(width = 280.dp, height = 140.dp) // Ukuran sedikit lebih lebar agar proporsional
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
        }
    }
}