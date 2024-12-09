package com.example.deliverycliente.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliverycliente.databinding.FragmentOrdersBinding
import com.example.deliverycliente.ui.adapters.OrdersAdapter
import com.example.deliverydriver.ui.viewmodels.OrdersViewModel

class OrdersFragment : Fragment() {

    private lateinit var binding: FragmentOrdersBinding
    private val ordersViewModel: OrdersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = OrdersAdapter(listOf())
        binding.ordersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.ordersRecyclerView.adapter = adapter

        ordersViewModel.orders.observe(viewLifecycleOwner) { orders ->
            adapter.updateOrders(orders)
        }

        ordersViewModel.fetchOrders()
    }
}
