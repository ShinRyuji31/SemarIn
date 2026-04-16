package com.example.application.ui.component.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun RestoSection() {
    Column(modifier = Modifier.padding(16.dp)) {

        Text("Semar Resto Termurah", fontWeight = FontWeight.Bold)

        LazyRow {
            items(5) {
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(160.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .height(100.dp)
                                .fillMaxWidth()
                                .background(Color.LightGray)
                        )
                        Text("Kopi Kenangan", fontWeight = FontWeight.Bold)
                        Text("⭐ 4.8 • 1.2km")
                        Text("Free Ongkir")
                    }
                }
            }
        }
    }
}