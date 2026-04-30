package com.example.application.ui.component.jajanin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.application.ui.component.shared.delivery.ItemCard

@Composable
fun JajaninRestaurantList(
    onRestaurantClick: () -> Unit
) {

    Column {

        Text(
            text = "Top Picks",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        restaurantDummy.forEach {
            ItemCard(
                name = it.name,
                address = it.address,
                promo = it.promo,
                rating = it.rating,
                imageRes = it.imageRes,
                onClick = onRestaurantClick
            )
        }
    }
}