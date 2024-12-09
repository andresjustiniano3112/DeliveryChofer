package com.example.deliverycliente.data.api

import androidx.room.Index
import com.example.deliverycliente.data.models.FreeOrder
import com.example.deliverycliente.data.models.LoginResponse
import com.example.deliverycliente.data.models.Restaurant
import com.example.deliverycliente.data.models.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("users/login")
    fun loginUser(@Body loginRequest: Map<String, String>): Call<LoginResponse>

    @POST("users")
    fun registerUser(@Body registerRequest: Map<String, String>): Call<Void>


    @GET("orders/free")
    fun getFreeOrders(): Call<List<FreeOrder>>

    @GET("restaurants/{id}")
    fun getRestaurant(@Path("id") id: Int): Call<Restaurant>


    @GET("me")
    fun getUserDetails(): Call<UserResponse>


    @POST("orders")
    fun placeOrder(@Body order: HashMap<String, Any>): Call<Void>







}
