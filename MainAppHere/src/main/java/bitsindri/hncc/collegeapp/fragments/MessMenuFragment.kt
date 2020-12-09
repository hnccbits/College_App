package bitsindri.hncc.collegeapp.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.TypedValue
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
        val inflator:LayoutInflater = activity?.layoutInflater !!
        val view = inflator.inflate(R.layout.day_menu_mess,null)

        alertDialog.setView(view)

        alertDialog.setTitle("One more step")
        alertDialog.setMessage("View Menu ")


        alertDialog.setIcon(R.drawable.ic_action_shopping_cart)

        alertDialog.setNegativeButton("Cancel",this)
        alertDialog.setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->

        }

        alertDialog.show()
    }

    override fun onClick(dialog: DialogInterface?, which: Int) {
        dialog?.dismiss()
    }

}