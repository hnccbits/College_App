package bitsindri.hncc.collegeapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import bitsindri.hncc.collegeapp.Custom_Classes.Fee
import bitsindri.hncc.collegeapp.GetterAndSetter.CartItem
import bitsindri.hncc.collegeapp.GetterAndSetter.OrderItem
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.activities.PaymentActivity

class FeeCollectionAdapter(context: Context, itemList: ArrayList<Fee>):RecyclerView.Adapter<FeeViewHolder>() {


    var context: Context
    var itemList: ArrayList<Fee>

    init {

        this.context = context
        this.itemList = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeeViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.type_fee_item, parent, false
        )
        return FeeViewHolder(view)

    }


    override fun getItemCount(): Int {

        return itemList.size
    }

    override fun onBindViewHolder(holder:FeeViewHolder, position: Int) {

        val feeItem = itemList[position]
        holder.fee_type.text = feeItem.event
        holder.type_price.text= feeItem.fee.toString()

        holder.fee_card.setOnClickListener{
            context.startActivity(Intent(context,PaymentActivity::class.java))
        }


    }

}

class  FeeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    val fee_type:TextView
    val type_price:TextView
    val payment_status:CheckBox
    val fee_card:CardView

    init {
        fee_type = itemView.findViewById(R.id.fee_type)
        type_price = itemView.findViewById(R.id.type_price)
        payment_status = itemView.findViewById(R.id.payment_status)
        fee_card = itemView.findViewById(R.id.fee_card)
    }

}