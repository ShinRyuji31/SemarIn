package com.example.application.ui.component.dashboard

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchSection() {

    var text by remember { mutableStateOf("") } // 🔥 state

    OutlinedTextField(
        value = text,
        onValueChange = { text = it }, // 🔥 update value

        placeholder = {
            Text("Cari Kebutuhanmu", fontSize = 14.sp)
        },

        singleLine = true, // 🔥 biar slim

        shape = RoundedCornerShape(40.dp),

        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,

            focusedBorderColor = Color.Transparent, // 🔥 hilangin garis tebal
            unfocusedBorderColor = Color.Transparent
        ),

        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(50.dp) // 🔥 bikin lebih tipis
    )
}