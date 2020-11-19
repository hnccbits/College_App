package bitsindri.hncc.collegeapp.activities

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import bitsindri.hncc.collegeapp.R
import java.lang.ClassCastException

class CameraDialog:AppCompatDialogFragment() {
     private lateinit var  camera:CheckBox
    private lateinit var gallery:CheckBox
    private lateinit var listener: DialogListener
    var CAMERA_INT = 3
    var GALLERY_INT = 4

    @SuppressLint("InflateParams", "ShowToast")
    override fun onCreateDialog(args: Bundle?): Dialog {


        val builder:AlertDialog.Builder = AlertDialog.Builder(activity)
        val inflator:LayoutInflater = activity?.layoutInflater !!
        val view = inflator.inflate(R.layout.camera_dialog,null)

        camera = view.findViewById(R.id.camera)
        gallery = view.findViewById(R.id.gallery)

        builder.setView(view)
                .setTitle("Source")
                .setNegativeButton("cancel") { dialogInterface: DialogInterface, i: Int ->



                }
                .setPositiveButton("ok") { dialogInterface: DialogInterface, i: Int ->

                    if(gallery.isChecked){

                        //result is transferred to our activity for further processing
                        listener.selectOptions(true,GALLERY_INT)


                    }else if(camera.isChecked){

                        listener.selectOptions(true,CAMERA_INT)

                    }
                    else if (gallery.isChecked && camera.isChecked){
                        Toast.makeText(activity,"select any one",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(activity,"select any one to proceed",Toast.LENGTH_SHORT).show()
                    }

                }

        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = context as DialogListener
        } catch (e: ClassCastException) {
            throw  ClassCastException(context.toString()+"must implement DialogListener")
        }
    }

    //listener for listening for FoundFirstActivity(interaction of dialog and activity)
    public  interface  DialogListener{
        fun selectOptions(b:Boolean,i:Int)
    }




}
