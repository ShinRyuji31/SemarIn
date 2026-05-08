package com.example.application.ui.component.jajanin.menu

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.application.data.model.MenuFoodItem

@Composable
fun JajaninMenuSection(
    title: String,
    items: List<MenuFoodItem>
) {
    Column(modifier = Modifier.fillMaxWidth()) {

        JajaninMenuTitle(title)

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(items) { item ->
                JajaninMenuItemCard(
                    name = item.name,
                    price = item.price,
                    imageRes = item.imageRes
                )
            }
        }
    }
}
