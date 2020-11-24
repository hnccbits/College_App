package bitsindri.hncc.collegeapp.Adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import bitsindri.hncc.collegeapp.GetterAndSetter.CartItem
import bitsindri.hncc.collegeapp.GetterAndSetter.Food
import bitsindri.hncc.collegeapp.R
import com.amulyakhare.textdrawable.TextDrawable
import org.w3c.dom.Text
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class CrtAdapter(context: Context, itemList: ArrayList<CartItem>): RecyclerView.Adapter<CartViewHolder>() {

    var context: Context
    var itemList: ArrayList<CartItem>

    init {

        this.context = context
        this.itemList = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.cart_item_layout, parent, false
        )
        return CartViewHolder(view)

    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
       val drawable = TextDrawable.builder()
               .buildRound(""+itemList.get(position).quantity,Color.RED)
        holder.cart_item_count.setImageDrawable(drawable)

        val locale = Locale("en","US")
        val fmt = NumberFormat.getCurrencyInstance(locale)
        val price = (itemList.get(position).price).toInt()*(itemList.get(position).quantity).toInt()
        holder.txt_cart_price.setText(fmt.format(price))
        holder.txt_cart_name.setText(itemList.get(position).menu)

    }

    override fun getItemCount(): Int {
        return itemList.size

    }

}

class  CartViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

    val txt_cart_name:TextView
    var txt_cart_price:TextView
    var cart_item_count:ImageView

    init {
        txt_cart_name = itemView.findViewById(R.id.cart_item_name)
        txt_cart_price = itemView.findViewById(R.id.cart_item_price)
        cart_item_count = itemView.findViewById(R.id.cart_item_count)
    }

}
