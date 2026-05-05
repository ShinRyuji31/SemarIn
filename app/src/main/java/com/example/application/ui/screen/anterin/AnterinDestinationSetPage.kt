package com.example.application.ui.screen.anterin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.R
import com.example.application.ui.component.global.ButtonBlue
import com.example.application.ui.component.global.Header
import com.example.application.ui.theme.BlackSoft
import com.example.application.ui.theme.BluePrimary
import com.example.application.ui.theme.GrayDark
import com.example.application.ui.theme.WhiteSoft

@Composable
fun AnterinDestinationSetPage(
    onBack: () -> Unit,
    onFindDriver: () -> Unit
) {

    var selectedVehicle by remember { mutableStateOf("Car") }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.background_mapdummy),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Header(
            title = "Anter-In",
            onBack = onBack
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(BluePrimary)
        ) {

            Column {

                Column(
                    modifier = Modifier
                        .background(WhiteSoft)
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {

                    LocationItem(
                        title = "Current Location",
                        subtitle = "Lokananta Bloc, Kerten"
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    LocationItem(
                        title = "Drop Off",
                        subtitle = "Gedung B FMIPA UNS"
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                VehicleItem(
                    name = "Car",
                    capacity = "4",
                    price = "Rp40.320",
                    icon = R.drawable.ic_bike,
                    isSelected = selectedVehicle == "Car",
                    onClick = { selectedVehicle = "Car" }
                )

                VehicleItem(
                    name = "Bike",
                    capacity = "1",
                    price = "Rp20.160",
                    icon = R.drawable.ic_bike,
                    isSelected = selectedVehicle == "Bike",
                    onClick = { selectedVehicle = "Bike" }
                )

                Spacer(modifier = Modifier.height(12.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .navigationBarsPadding()
                ) {
                    ButtonBlue(
                        text = "Find Driver",
                        onClick = onFindDriver,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                            .fillMaxWidth()
                            .height(50.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun LocationItem(title: String, subtitle: String) {

    Row(verticalAlignment = Alignment.CenterVertically) {

        Icon(
            painter = painterResource(id = R.drawable.ic_location),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = BlackSoft
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 13.sp)
            Text(subtitle, fontSize = 12.sp, color = GrayDark)
        }
    }
}

@Composable
fun VehicleItem(
    name: String,
    capacity: String,
    price: String,
    icon: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (isSelected) Color(0xFFD6ECFF) else Color(0xFFF2F2F2)
            )
            .clickable { onClick() }
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = Color.Unspecified
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(name)

            Spacer(modifier = Modifier.width(8.dp))

            Text("👤 $capacity", fontSize = 12.sp)
        }

        Text(
            price,
            fontWeight = FontWeight.Bold,
            color = if (isSelected) BluePrimary else BlackSoft
        )
    }
}