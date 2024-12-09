package com.example.deliverycliente.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deliverycliente.data.models.FreeOrder
import com.example.deliverycliente.databinding.ItemOrderBinding


class OrdersAdapter(
    private var orders: List<FreeOrder>
) : RecyclerView.Adapter<OrdersAdapter.OrderViewHolder>() {

    inner class OrderViewHolder(private val binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(freeOrder: FreeOrder) {
            binding.orderId.text = "Pedido: ${freeOrder.id}"
            binding.orderDetails.text = "Restaurante: ${freeOrder.restaurant_name ?: "Desconocido"}"
            binding.orderAddress.text = "Dirección: ${freeOrder.address}"
            binding.orderDate.text = "Fecha: ${freeOrder.created_at ?: "Sin fecha"}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        holder.bind(orders[position])
    }

    override fun getItemCount(): Int = orders.size

    fun updateOrders(newOrders: List<FreeOrder>) {
        orders = newOrders
        notifyDataSetChanged()
    }
}
