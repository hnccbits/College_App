package bitsindri.hncc.collegeapp.fragments

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*
import java.util.Calendar.DAY_OF_MONTH

class DatePickerFragment :DialogFragment(){

    val cal = Calendar.getInstance()
    val day = cal.get(DAY_OF_MONTH)
    var month =cal.get(Calendar.MONTH)
    val year = cal.get(Calendar.YEAR)

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return DatePickerDialog(activity as Context,activity as DatePickerDialog.OnDateSetListener,year,month,day)//(DatePickerDialog.OnDateSetListener) used as an object of DatePickerDialog.OnDateSetListener interface inherited in mainactivity and used to indicate that the user has finished selecting a date,year month and day have current values not user selected
    }
}