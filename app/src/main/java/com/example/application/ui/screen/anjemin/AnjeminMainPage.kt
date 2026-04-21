package com.example.application.ui.screen.anjemin

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application.R
import com.example.application.ui.component.anjemin.AnjeminBackground
import com.example.application.ui.component.anjemin.AnjeminHeader
import com.example.application.ui.theme.BlackSoft
import com.example.application.ui.theme.GrayMedium
import com.example.application.ui.theme.WhiteSoft

enum class MainMode {
    PICKUP_ONLY,
    PICKUP_AND_DESTINATION
}

@Composable
fun AnjeminMainPage(
    mode: MainMode,
    onPickupClick: () -> Unit,
    onDestinationClick: () -> Unit
) {

    var pickup by remember { mutableStateOf("") }
    var destination by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        AnjeminBackground()

        Column {
            AnjeminHeader(onBack = {})
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(horizontal = 16.dp)
                .offset(y = 40.dp)
                .background(
                    WhiteSoft,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(16.dp)
        ) {

            Column {

                Text("Pick Up", fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(6.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onPickupClick() }
                ) {
                    OutlinedTextField(
                        value = pickup,
                        onValueChange = { pickup = it },
                        placeholder = { Text("Current Location", color = BlackSoft) },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth(),
                        enabled = false,
                        colors = OutlinedTextFieldDefaults.colors(
                            disabledBorderColor = GrayMedium,
                            disabledContainerColor = Color.White
                        )
                    )
                }

                if (mode == MainMode.PICKUP_AND_DESTINATION) {

                    Spacer(modifier = Modifier.height(12.dp))

                    Text("Drop Off", fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(6.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onDestinationClick() }
                    ) {
                        OutlinedTextField(
                            value = destination,
                            onValueChange = { destination = it },
                            placeholder = { Text("Choose Destination", color = BlackSoft) },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth(),
                            enabled = false,
                            colors = OutlinedTextFieldDefaults.colors(
                                disabledBorderColor = GrayMedium,
                                disabledContainerColor = Color.White
                            )
                        )
                    }
                }

                // 🔹 HISTORY
                Spacer(modifier = Modifier.height(12.dp))

                Text("History", fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(8.dp))

                HistoryItem("Gg. Kutai Utara No. 1, Sumber")
                HistoryItem("Faculty of Law UNS, Jl. Ir. Sutami No.36A")
                HistoryItem("Lokananta Bloc, Kerten")
            }
        }
    }
}

@Composable
fun HistoryItem(text: String) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 6.dp)
    ) {

        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(Color(0xFFBFE9FF)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(text, fontSize = 12.sp)
    }
}