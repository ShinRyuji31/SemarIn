package com.example.application.orderhistory.viewmodel

import androidx.lifecycle.ViewModel
import com.example.application.orderhistory.data.model.OrderHistory
import com.example.application.orderhistory.data.repository.OrderHistoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class OrderHistoryViewModel : ViewModel() {
    private val repository = OrderHistoryRepository()

    private val _orders = MutableStateFlow<List<OrderHistory>>(emptyList())
    val orders: StateFlow<List<OrderHistory>> = _orders.asStateFlow()

    init {
        _orders.value = repository.getOrderHistory()
    }
}
