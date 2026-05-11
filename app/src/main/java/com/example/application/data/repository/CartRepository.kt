package com.example.application.data.repository

import com.example.application.data.local.CartDataStore
import com.example.application.data.model.CartItem
import kotlinx.coroutines.flow.Flow

class CartRepository(
    private val dataStore: CartDataStore
) {

    fun getCartItems(): Flow<List<CartItem>> {
        return dataStore.getCartItems()
    }

    suspend fun saveCartItems(
        items: List<CartItem>
    ) {
        dataStore.saveCartItems(items)
    }
}