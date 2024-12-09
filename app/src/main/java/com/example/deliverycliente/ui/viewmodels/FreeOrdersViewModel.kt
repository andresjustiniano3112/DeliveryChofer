package com.example.deliverycliente.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliverycliente.data.api.ApiClient
import com.example.deliverycliente.data.api.ApiService
import com.example.deliverycliente.data.models.FreeOrder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FreeOrdersViewModel : ViewModel() {

    private val _freeOrders = MutableLiveData<List<FreeOrder>>()
    val freeOrders: LiveData<List<FreeOrder>> get() = _freeOrders

    fun fetchFreeOrders() {
        val apiService = ApiClient.retrofit.create(ApiService::class.java)
        apiService.getFreeOrders().enqueue(object : Callback<List<FreeOrder>> {
            override fun onResponse(
                call: Call<List<FreeOrder>>,
                response: Response<List<FreeOrder>>
            ) {
                if (response.isSuccessful) {
                    _freeOrders.value = response.body()
                } else {

                }
            }

            override fun onFailure(call: Call<List<FreeOrder>>, t: Throwable) {

            }
        })
    }
}
