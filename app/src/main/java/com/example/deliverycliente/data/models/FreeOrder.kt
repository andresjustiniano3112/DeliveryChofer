package com.example.deliverycliente.data.models

data class FreeOrder(
    val id: Int,
    val user_id: Int,
    val restaurant_id: Int,
    val total: String,
    val latitude: String,
    val longitude: String,
    val address: String,
    val created_at: String,
    val restaurant_name: String? // Campo opcional
)

