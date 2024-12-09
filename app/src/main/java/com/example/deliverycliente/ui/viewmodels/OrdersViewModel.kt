package com.example.deliverydriver.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliverycliente.data.api.ApiClient
import com.example.deliverycliente.data.api.ApiService
import com.example.deliverycliente.data.models.FreeOrder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrdersViewModel : ViewModel() {

    private val _orders = MutableLiveData<List<FreeOrder>>()
    val orders: LiveData<List<FreeOrder>> get() = _orders

    fun fetchOrders() {
        val apiService = ApiClient.retrofit.create(ApiService::class.java)
        apiService.getFreeOrders().enqueue(object : Callback<List<FreeOrder>> {
            override fun onResponse(call: Call<List<FreeOrder>>, response: Response<List<FreeOrder>>) {
                if (response.isSuccessful) {
                    _orders.value = response.body()
                } else {
                    _orders.value = emptyList()
                }
            }

            override fun onFailure(call: Call<List<FreeOrder>>, t: Throwable) {
                _orders.value = emptyList()
            }
        })
    }
}
