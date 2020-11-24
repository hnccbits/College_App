package bitsindri.hncc.collegeapp.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bitsindri.hncc.collegeapp.Adapters.OrderStatusAdapter
import bitsindri.hncc.collegeapp.GetterAndSetter.OrderItem
import bitsindri.hncc.collegeapp.R

class OrderStatusFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        lateinit var orderRecyclerView: RecyclerView
        lateinit var layoutManager: LinearLayoutManager

        val view = inflater.inflate(R.layout.fragment_order_status, container, false)


        orderRecyclerView = view.findViewById(R.id.list_orders)
        layoutManager = LinearLayoutManager(activity)

        val orderItems = arrayListOf<OrderItem>(
                OrderItem("1234","1234567890","237 bhagat chowk ,dhanbad","On Way")
        )

        val adapter = OrderStatusAdapter(activity as Context,orderItems)

        orderRecyclerView.adapter = adapter
        orderRecyclerView.layoutManager = layoutManager

        return view
    }

}