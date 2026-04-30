package com.example.application.ui.component.jajanin.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.application.R

@Composable
fun JajaninMenuHorizontalList() {

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(5) {
            JajaninMenuItemCard(
                name = "Delight Box",
                price = "Rp29.000",
                imageRes = R.drawable.change_this_to_correct_pic
            )
        }
    }
}