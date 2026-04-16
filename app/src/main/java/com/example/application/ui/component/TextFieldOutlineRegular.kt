package com.example.application.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldOutlineRegular (
    text: String
){
    OutlinedTextField(
        value = text,
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    )
}