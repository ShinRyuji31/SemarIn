package com.example.application.data.repository

import com.example.application.R
import com.example.application.data.model.MenuFoodItem
import com.example.application.data.model.Restaurant

class JajaninRepository {

    fun getRestaurants(): List<Restaurant> {
        return listOf(
            Restaurant(
                name = "Beard Papa’s",
                address = "Jl. Slamet Riyadi No.120, Laweyan 3.5 km",
                promo = "Diskon ongkir s.d 5rb",
                rating = 4.8,
                imageRes = R.drawable.dummy,
                openTime = "10:00",
                closeTime = "22:00",
                openDays = "Mon-Sun",
                tags = listOf("Bakery", "Dessert")
            ),
            Restaurant(
                name = "Fore Coffee",
                address = "Jl. Kyai Haji Agus Salim 1 km",
                promo = "Gratis es kopi jumbo",
                rating = 4.7,
                imageRes = R.drawable.resto_sate,
                openTime = "07:00",
                closeTime = "23:00",
                openDays = "Daily",
                tags = listOf("Coffee", "Cafe")
            ),
            Restaurant(
                name = "Wingstop",
                address = "Jl. Brigjen Slamet Riyadi 1.4 km",
                promo = "Buy 1 Get 1",
                rating = 4.9,
                imageRes = R.drawable.resto_ayamgeprek,
                openTime = "09:00",
                closeTime = "21:00",
                openDays = "Mon-Sat",
                tags = listOf("Chicken", "Fast Food")
            ),
            Restaurant(
                name = "J.CO Donuts & Coffee",
                address = "Jl. Kapten Mulyadi, Surakarta 2 km",
                promo = "Promo J.Cronut",
                rating = 4.6,
                imageRes = R.drawable.resto_kopikenangan,
                openTime = "08:00",
                closeTime = "22:00",
                openDays = "Daily",
                tags = listOf("Donuts", "Coffee")
            ),
            Restaurant(
                name = "Shihlin",
                address = "Mall Solo Square, Laweyan",
                promo = "Voucher Diskon 10rb",
                rating = 4.5,
                imageRes = R.drawable.dummy,
                openTime = "10:00",
                closeTime = "21:30",
                openDays = "Daily",
                tags = listOf("Snack", "Taiwanese")
            ),
            Restaurant(
                name = "Chatime",
                address = "Solo Grand Mall, Penumping",
                promo = "Buy 2 Get 1 Free",
                rating = 4.4,
                imageRes = R.drawable.dummy,
                openTime = "10:00",
                closeTime = "22:00",
                openDays = "Daily",
                tags = listOf("Milk Tea", "Beverage")
            ),
            Restaurant(
                name = "KFC",
                address = "Jl. Slamet Riyadi No.10, Purwosari",
                promo = "Winger Party 50rb",
                rating = 4.7,
                imageRes = R.drawable.dummy,
                openTime = "24 Hours",
                closeTime = "",
                openDays = "Daily",
                tags = listOf("Chicken", "Fast Food")
            ),
            Restaurant(
                name = "McDonald's",
                address = "Jl. Slamet Riyadi No.20, Sriwedari",
                promo = "Diskon 30% pakai QRIS",
                rating = 4.8,
                imageRes = R.drawable.dummy,
                openTime = "24 Hours",
                closeTime = "",
                openDays = "Daily",
                tags = listOf("Fast Food", "Burger")
            ),
            Restaurant(
                name = "Subway",
                address = "The Park Mall, Solo Baru",
                promo = "Combo Hemat Subway",
                rating = 4.9,
                imageRes = R.drawable.dummy,
                openTime = "10:00",
                closeTime = "22:00",
                openDays = "Daily",
                tags = listOf("Sandwich", "Healthy")
            ),
            Restaurant(
                name = "Gacoan",
                address = "Jl. Slamet Riyadi No.400",
                promo = "Promo Pedas Berlevel",
                rating = 4.5,
                imageRes = R.drawable.dummy,
                openTime = "08:00",
                closeTime = "23:00",
                openDays = "Daily",
                tags = listOf("Noodle", "Spicy")
            )
        )
    }

    fun getMenu(): List<MenuFoodItem> {
        return listOf(
            // Cream Puff Party Collections
            MenuFoodItem("Delight Box", "Rp297.000", R.drawable.dummy, "Cream Puff Party Collections"),
            MenuFoodItem("Family Bundle", "Rp297.000", R.drawable.dummy, "Cream Puff Party Collections"),
            MenuFoodItem("Party Box", "Rp120.000", R.drawable.dummy, "Cream Puff Party Collections"),
            MenuFoodItem("Mini Box", "Rp15.000", R.drawable.dummy, "Cream Puff Party Collections"),
            MenuFoodItem("Super Bundle", "Rp200.000", R.drawable.dummy, "Cream Puff Party Collections"),
            
            // The Eclair
            MenuFoodItem("The Eclair Bestie", "Rp89.000", R.drawable.dummy, "The Eclair"),
            MenuFoodItem("The Eclair", "Rp49.900", R.drawable.dummy, "The Eclair"),
            MenuFoodItem("Eclair Chocolate", "Rp25.000", R.drawable.dummy, "The Eclair"),
            MenuFoodItem("Eclair Vanilla", "Rp25.000", R.drawable.dummy, "The Eclair"),
            
            // Signature Pie Cream Puff
            MenuFoodItem("Durian", "Rp93.000", R.drawable.dummy, "Signature Pie Cream Puff"),
            MenuFoodItem("Cookies & Cream", "Rp75.600", R.drawable.dummy, "Signature Pie Cream Puff"),
            MenuFoodItem("Vanilla Custard", "Rp58.000", R.drawable.dummy, "Signature Pie Cream Puff"),
            
            // Classic Eclair
            MenuFoodItem("Black Thorn", "Rp98.000", R.drawable.dummy, "Classic Eclair"),
            MenuFoodItem("Cookies & Cream", "Rp82.000", R.drawable.dummy, "Classic Eclair"),
            MenuFoodItem("Custard", "Rp68.000", R.drawable.dummy, "Classic Eclair"),

            // Mini Cream Puff
            MenuFoodItem("Black Thorn", "Rp151.700", R.drawable.dummy, "Mini Cream Puff"),
            MenuFoodItem("Vanilla Custard", "Rp102.000", R.drawable.dummy, "Mini Cream Puff"),
            MenuFoodItem("10 pcs", "Rp220.300", R.drawable.dummy, "Mini Cream Puff")
        )
    }
}
