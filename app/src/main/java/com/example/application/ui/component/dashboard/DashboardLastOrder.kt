package com.example.application.ui.component.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.ui.theme.BlackSoft
import com.example.application.ui.theme.GrayMedium

@Composable
fun DashboardLastOrder() {
    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            "Last Ordered",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = BlackSoft
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .border(
                    1.dp,
                    GrayMedium,
                    RoundedCornerShape(16.dp)
                ),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            )
        ) {
            Row(modifier = Modifier.padding(16.dp)) {

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color.LightGray)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        "Kopi Kenangan",
                        fontWeight = FontWeight.Bold,
                        color = BlackSoft)
                    Text("⭐ 4.8", color = BlackSoft)
                }
            }
        }
    }
}