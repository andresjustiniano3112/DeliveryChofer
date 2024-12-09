package com.example.deliverycliente.data.models

import Product

data class OrderDetail(
    val id: Int,
    val quantity: Int,
    val price: String,
    val product: Product
)

