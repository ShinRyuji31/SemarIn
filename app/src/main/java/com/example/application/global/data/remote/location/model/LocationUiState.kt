package com.example.application.global.data.remote.location.model

data class LocationUiState(
    val isLoading: Boolean = false,
    val locationName: String = "",
    val error: String? = null
)
