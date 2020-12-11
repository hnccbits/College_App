package bitsindri.hncc.collegeapp.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bitsindri.hncc.collegeapp.Adapters.ChangeMessMenuViewHolder
import bitsindri.hncc.collegeapp.Adapters.ChangeMessMenuaAdapter
import bitsindri.hncc.collegeapp.Adapters.CrtAdapter
import bitsindri.hncc.collegeapp.Drawer.DrawerAdapter
import bitsindri.hncc.collegeapp.GetterAndSetter.CartItem
import bitsindri.hncc.collegeapp.GetterAndSetter.VotingChangeMenu
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.activities.CameraDialog
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import android.widget.ImageView

import android.widget.Toast
import androidx.core.content.ContextCompat.checkSelfPermission
import bitsindri.hncc.collegeapp.activities.FoundFirstActivity


class UpdateMessMenuFragment : Fragment(),DialogInterface.OnClickListener , AdapterView.OnItemSelectedListener  {

    lateinit var time: ArrayList<String>
    lateinit var spinner: Spinner
    lateinit var recyclerView_change: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var calendar: Calendar
    lateinit var simpleDateFormat: SimpleDateFormat
    var spinner_item = ""
    var uri:Uri? = null

    lateinit var imageView: ImageView
    lateinit var new_menu_name: String
    lateinit var editText: EditText


    @SuppressLint("SimpleDateFormat", "WeekBasedYear")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update_mess_menu, container, false)
        spinner = view.findViewById(R.id.spinner_change)
        recyclerView_change = view.findViewById(R.id.recyclerview_change)
        layoutManager = LinearLayoutManager(activity as Context)

        calendar = Calendar.getInstance()
        simpleDateFormat = SimpleDateFormat("MM-dd-yyyy")

        time = ArrayList()
        time.add("breakfast")
        time.add("launch")
        time.add("evening snacks")
        time.add("dinner")

        val timeAdapter = ArrayAdapter<String>(activity as Context, android.R.layout.simple_list_item_1, time)

        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = timeAdapter

        spinner.onItemSelectedListener = this

        val updatedMenuItems = arrayListOf<VotingChangeMenu>(

                VotingChangeMenu(R.drawable.man, if (spinner_item != "") {
                    spinner_item
                } else {
                    spinner.selectedItem.toString()
                }, simpleDateFormat.format(calendar.time), R.drawable.askinpoppins, R.drawable.vector_mess_report, "Chhoole", "Dhhosa", 5),
                VotingChangeMenu(R.drawable.man, if (spinner_item != "") {
                    spinner_item
                } else {
                    spinner.selectedItem.toString()
                }, simpleDateFormat.format(calendar.time), R.drawable.askinpoppins, R.drawable.vector_mess_report, "Chhoole", "Dhhosa", 7),
                VotingChangeMenu(R.drawable.man, if (spinner_item != "") {
                    spinner_item
                } else {
                    spinner.selectedItem.toString()
                }, simpleDateFormat.format(calendar.time), R.drawable.askinpoppins, R.drawable.vector_mess_report, "Chhoole", "Dhhosa", 0),
                VotingChangeMenu(R.drawable.man, if (spinner_item != "") {
                    spinner_item
                } else {
                    spinner.selectedItem.toString()
                }, simpleDateFormat.format(calendar.time), R.drawable.askinpoppins, R.drawable.vector_mess_report, "Chhoole", "Dhhosa", 15),
                VotingChangeMenu(R.drawable.man, if (spinner_item != "") {
                    spinner_item
                } else {
                    spinner.selectedItem.toString()
                }, simpleDateFormat.format(calendar.time), R.drawable.askinpoppins, R.drawable.vector_mess_report, "Chhoole", "Dhhosa", 10)

        )

        val adapter = ChangeMessMenuaAdapter(activity as Context, updatedMenuItems)

        recyclerView_change.adapter = adapter
        recyclerView_change.layoutManager = layoutManager

        return view
    }

    private fun openDialog() {
        val alertDialog = AlertDialog.Builder(activity as Context)
        val inflator: LayoutInflater = activity?.layoutInflater!!
        val view = inflator.inflate(R.layout.dialog_change, null)

         imageView = view.findViewById<ImageView>(R.id.menu_image)
        val editView = view.findViewById<EditText>(R.id.menu_text)

        new_menu_name = editView.text.toString()
        imageView.setOnClickListener{

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //system is greater than marshmallow
                if (checkSelfPermission(activity as Context,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permissions, UpdateMessMenuFragment.PERMISSION_CODE)
                } else {
                    pickImageFromGallery()
                    imageView.setImageURI(uri)
                }
            } else {
                pickImageFromGallery()
                imageView.setImageURI(uri)
            }
        }

        alertDialog.setView(view)

        alertDialog.setTitle("One more step")
        alertDialog.setMessage("Change Menu ")


        alertDialog.setIcon(R.drawable.ic_action_shopping_cart)

        alertDialog.setNegativeButton("Cancel", this)
        alertDialog.setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->

            //adding to recycler view

            Toast.makeText(activity as Context, "Menu queued for voting", Toast.LENGTH_SHORT).show()

        }

        alertDialog.show()
    }


    override fun onClick(dialog: DialogInterface?, which: Int) {
        dialog?.dismiss()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        openDialog()

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == IMAGE_PICK_CODE && data != null) {
            uri = data.data
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            UpdateMessMenuFragment.PERMISSION_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickImageFromGallery()
                } else {
                    Toast.makeText(activity as Context, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }


    companion object {
        private const val IMAGE_PICK_CODE = 2
        private const val PERMISSION_CODE = 5
    }


}

