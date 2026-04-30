package com.example.application.ui.component.jajanin.menu

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JajaninMenuTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier.padding(16.dp),
        fontSize = 14.sp
    )
}