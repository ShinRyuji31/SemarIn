package com.example.application.ui.component.jajanin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JajaninInfoCard(){
    Box(
        modifier = Modifier
            .offset(y = (-20).dp)
            .padding(horizontal = 16.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {

        Column {

            Text(
                "Beard Papa’s",
                fontSize = 18.sp
            )

            Text(
                "Jl. Slamet Riyadi No.120, Laweyan 3.5 km",
                fontSize = 12.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text("Opening Hours:", fontSize = 12.sp)
            Text("10:00 - 22:00 WIB (Mon-Sun)", fontSize = 12.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Text("⭐ 4.8   Bakery & Cake", fontSize = 12.sp)
        }
    }
}