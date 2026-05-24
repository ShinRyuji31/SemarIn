package com.example.application.auth.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("user_id")
    val id: String,
    val username: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("last_name")
    val lastName: String? = null,
    @SerialName("sso_email")
    val email: String,
    @SerialName("phone_number")
    val phoneNumber: String,
    @SerialName("profile_pic")
    val profilePic: String? = null,
    val password: String? = null // Included to match user's custom DB schema
)

@Serializable
data class Customer(
    @SerialName("user_id")
    val userId: String,
    @SerialName("customer_tier")
    val customerTier: String = "Regular"
)
