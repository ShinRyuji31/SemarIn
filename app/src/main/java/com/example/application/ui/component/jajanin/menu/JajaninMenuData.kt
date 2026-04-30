package com.example.application.ui.component.jajanin.menu

import com.example.application.R

data class MenuFoodItem(
    val name: String,
    val price: String,
    val imageRes: Int
)

val dummyMenu = listOf(
    MenuFoodItem("Delight Box", "Rp29.000", R.drawable.change_this_to_correct_pic),
    MenuFoodItem("Family Bundle", "Rp45.000", R.drawable.change_this_to_correct_pic),
    MenuFoodItem("Eclair Chocolate", "Rp9.000", R.drawable.change_this_to_correct_pic),
    MenuFoodItem("Vanilla Custard", "Rp8.000", R.drawable.change_this_to_correct_pic)
)