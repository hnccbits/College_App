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

class ReportFragment : Fragment(), DialogInterface.OnClickListener , AdapterView.OnItemSelectedListener {

    lateinit var spinner: Spinner
    lateinit var inchargeName:TextView
    lateinit var inchargePhoto:ImageView

   lateinit var list:ArrayList<String>
    lateinit var root:ArrayList<String>
    var spinnerItem ="Hostel No."

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_report, container, false)

        spinner = view.findViewById(R.id.spinner_report)
        inchargeName = view.findViewById(R.id.inchargeName)
        inchargePhoto = view.findViewById(R.id.inchargePhoto)

        list = ArrayList()
        list.add("Hostel No.")
        list.add("27")
        list.add("23")
        list.add("22")
        list.add("21")
        list.add("20")
        list.add("19")
        list.add("18")
        list.add("17")
        list.add("16")

        root = ArrayList()
        root.add("Select root")
        root.add("Cleanliness report")
        root.add("mess report")
        root.add("electricity issue")

        val rootAdapter = ArrayAdapter<String>(activity as Context,android.R.layout.simple_list_item_1,root)

        rootAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=rootAdapter

        showAlertDialog()

        return view
    }
    @SuppressLint("SetTextI18n")
    private fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(activity as Context)
        val inflator:LayoutInflater = activity?.layoutInflater !!
        val view = inflator.inflate(R.layout.report_dialog_mess,null)

        val spinner = view.findViewById<Spinner>(R.id.spinner)
        val reportAdapter = ArrayAdapter<String>(activity as Context,android.R.layout.simple_list_item_1,list)

        reportAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=reportAdapter

        alertDialog.setView(view)

        alertDialog.setTitle("Choose Hostel")
        alertDialog.setMessage("Your report will be sent to the specific hostel incharge directly")

        alertDialog.setIcon(R.drawable.vector_help_bitians)
        alertDialog.setNegativeButton("Cancel",this)
        alertDialog.setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->

            spinner.onItemSelectedListener=this

        }

        alertDialog.show()
    }

    override fun onClick(dialog: DialogInterface?, which: Int) {

        dialog?.dismiss()

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        spinner.setSelection(position)

        spinnerItem=parent?.selectedItem.toString()

            inchargeName.setText(spinnerItem)
            inchargePhoto.setImageResource(R.drawable.profilepic)



    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

        Toast.makeText(activity as Context,"select hostel first",Toast.LENGTH_SHORT).show()
    }
}