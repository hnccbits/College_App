package bitsindri.hncc.collegeapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bitsindri.hncc.collegeapp.GetterAndSetter.CartItem
import bitsindri.hncc.collegeapp.GetterAndSetter.OrderItem
import bitsindri.hncc.collegeapp.R

class OrderStatusAdapter(context: Context, itemList: ArrayList<OrderItem>):RecyclerView.Adapter<OrderViewHolder>() {


    var context: Context
    var itemList: ArrayList<OrderItem>

    init {

        this.context = context
        this.itemList = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.order_layout, parent, false
        )
        return OrderViewHolder(view)

    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {

        val orderItem = itemList[position]
        holder.order_id.text = orderItem.order_id.toString()
        holder.order_phone.text = orderItem.order_phone
        holder.order_status.text = orderItem.order_status.toString()
        holder.order_address.text = orderItem.order_address

    }

    override fun getItemCount(): Int {

        return itemList.size
    }

}

class  OrderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    val order_id: TextView
    val order_status: TextView
    val order_address: TextView
    val order_phone:TextView

    init {
        order_address = itemView.findViewById(R.id.order_address)
        order_id = itemView.findViewById(R.id.order_id)
        order_status = itemView.findViewById(R.id.order_status)
        order_phone = itemView.findViewById(R.id.order_phone)

        itemView.setOnClickListener{

        }
    }

}