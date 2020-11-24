package bitsindri.hncc.collegeapp.activities

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.LocaleList
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bitsindri.hncc.collegeapp.Adapters.CrtAdapter
import bitsindri.hncc.collegeapp.Custom_Classes.Request
import bitsindri.hncc.collegeapp.GetterAndSetter.CartItem
import bitsindri.hncc.collegeapp.R
import info.hoang8f.widget.FButton
import java.text.NumberFormat
import java.util.*

class CartActivity : AppCompatActivity(),DialogInterface.OnClickListener {

    lateinit var recyclerView:RecyclerView
    lateinit var layoutManager: LinearLayoutManager

    lateinit var  txt_total:TextView
    lateinit var place_order: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)


        recyclerView= findViewById(R.id.list_cart)
        txt_total= findViewById(R.id.total)
        place_order=findViewById(R.id.place_order)
        layoutManager= LinearLayoutManager(this)

        val cartItems = arrayListOf<CartItem>(
                CartItem(2,"Baco Tell",300),
                CartItem(3,"Garber Burgers",200),
                CartItem(4,"Pind Tadka",280)
        )

        val adapter = CrtAdapter(this,cartItems)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        var total = 0
        for(cartItem:CartItem in cartItems){
            total += cartItem.price*cartItem.quantity
            val locale = Locale("en","US")
            var fmt = NumberFormat.getCurrencyInstance(locale)

            txt_total.setText(fmt.format(total))

        }

        place_order.setOnClickListener{
            showAlertDialog()
        }



    }

    private fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("One more step")
        alertDialog.setMessage("Enter your address: ")

        val etAddress = EditText(this)
        val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        )

        etAddress.layoutParams = lp
        alertDialog.setView(etAddress)
        alertDialog.setIcon(R.drawable.ic_action_shopping_cart)

        alertDialog.setNegativeButton("NO",this)
        alertDialog.setPositiveButton("YES") { dialogInterface: DialogInterface, i: Int ->
            if(etAddress.text.equals("")){
                Toast.makeText(this,"Fill the address first",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Thank you  ,Order Placed",Toast.LENGTH_SHORT).show()
            }


        }

        alertDialog.show()
    }

    override fun onClick(dialog: DialogInterface?, which: Int) {

       dialog?.dismiss()
    }
}