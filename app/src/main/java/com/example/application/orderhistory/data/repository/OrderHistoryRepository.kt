package com.example.application.orderhistory.data.repository

import androidx.compose.ui.graphics.Color
import com.example.application.R
import com.example.application.orderhistory.data.model.OrderHistory
import com.example.application.orderhistory.data.model.OrderType

class OrderHistoryRepository {
    fun getOrderHistory(): List<OrderHistory> {
        return listOf(
            OrderHistory(
                id = "1",
                name = "Beard Papa’s",
                details = "Jl. Slamet Riyadi No. 120, Laweyan 3.5 km",
                dateTime = "23 April 2026, 12:30 WIB",
                price = 247200,
                imageRes = R.drawable.dummy,
                type = OrderType.FOOD,
                themeColor = Color(0xFFFFD600) // Yellowish
            ),
            OrderHistory(
                id = "2",
                name = "Subway",
                details = "Ruko Letjend Sutoyo, Surakarta 1.2 km",
                dateTime = "22 April 2026, 12:30 WIB",
                price = 96000,
                imageRes = R.drawable.dummy, // Replace with Subway if exists
                type = OrderType.FOOD,
                themeColor = Color(0xFF008938) // Green
            ),
            OrderHistory(
                id = "3",
                name = "Anter-In Bike",
                details = "Gedung B FMIPA UNS - Lokananta Bloc 8.4 km",
                dateTime = "22 April 2026, 09:30 WIB",
                price = 20160,
                imageRes = R.drawable.ic_bike,
                type = OrderType.ANTERIN,
                themeColor = Color.White
            )
        )
    }
}
