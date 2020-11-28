package bitsindri.hncc.collegeapp.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import bitsindri.hncc.collegeapp.R

class MessMenuFragment : Fragment(),DialogInterface.OnClickListener {

    lateinit var breakfast:Button
    lateinit var dinner:Button
    lateinit var snack:Button
    lateinit var launch:Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_mess_menu, container, false)

        breakfast= view.findViewById(R.id.breakfast)
        dinner = view.findViewById(R.id.dinner)
        snack = view.findViewById(R.id.snack)
        launch = view.findViewById(R.id.launch)


        breakfast.setOnClickListener{
            showAlertDialog()
        }
        dinner.setOnClickListener{
            showAlertDialog()
        }
        snack.setOnClickListener{
            showAlertDialog()
        }
        launch.setOnClickListener{
            showAlertDialog()
        }

        return  view
    }

    @SuppressLint("SetTextI18n")
    private fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(activity as Context)
        alertDialog.setTitle("One more step")
        alertDialog.setMessage("View Menu ")

        val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val linearLayout = LinearLayout(activity as Context)
        linearLayout.orientation = LinearLayout.VERTICAL

        val txtMenu = TextView(activity as Context)
        txtMenu.setText("Chhola Bhatura")
        txtMenu.layoutParams = lp

        val imgImage = ImageView(activity as Context)
        imgImage.setImageResource(R.drawable.askinpoppins)
        imgImage.layoutParams = lp

        alertDialog.setView(txtMenu)
        alertDialog.setView(imgImage)

        alertDialog.setIcon(R.drawable.ic_action_shopping_cart)

        alertDialog.setNegativeButton("NO",this)
        alertDialog.setPositiveButton("OK") { dialogInterface: DialogInterface, i: Int ->
            if(txtMenu.text.equals("")){
                Toast.makeText(activity as Context,"Fill the address first", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(activity as Context,"Thank you  ,Order Placed", Toast.LENGTH_SHORT).show()
            }


        }

        alertDialog.show()
    }

    override fun onClick(dialog: DialogInterface?, which: Int) {
        dialog?.dismiss()
    }

}