package com.example.application.ui.component.dashboard

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.R

@Composable
fun ServiceMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ServiceCard("Antar-in", R.drawable.ic_bike)
        ServiceCard("Jajan-in", R.drawable.ic_cutlery)
        ServiceCard("Jastip-in", R.drawable.ic_bag)
        ServiceCard("All", R.drawable.ic_all)
    }
}

@Composable
fun ServiceCard(text: String, iconRes: Int) {
    Card(
        modifier = Modifier.size(80.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        border = androidx.compose.foundation.BorderStroke(
            2.dp,
            Color.Gray
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                tint = Color.Black,
                contentDescription = text,
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text, fontSize = 12.sp, color = Color.Black)
        }
    }
}