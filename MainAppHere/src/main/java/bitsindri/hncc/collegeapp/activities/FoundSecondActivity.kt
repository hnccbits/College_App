package bitsindri.hncc.collegeapp.activities;

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat

import androidx.appcompat.widget.Toolbar
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.fragments.DatePickerFragment

class FoundSecondActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener  {

    lateinit var btn_submit: Button
    lateinit var linear_address: LinearLayout
    lateinit var pick_date: LinearLayout
    lateinit var show_date: TextView
    lateinit var switch1: SwitchCompat
    lateinit var switch2: SwitchCompat
    lateinit var  linear_add: LinearLayout
    lateinit var separator: TableRow
    lateinit var content_frame_second: LinearLayout
    lateinit var lost_second: LinearLayout

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_found_second)

        btn_submit = findViewById(R.id.btn_submit)
        linear_address = findViewById(R.id.linear_address)
        pick_date = findViewById(R.id.pick_date)
        show_date = findViewById(R.id.show_date)
        switch1 = findViewById(R.id.switch1)
        switch2 = findViewById(R.id.switch2)
        linear_add = findViewById(R.id.linear_drop)
        separator = findViewById(R.id.separator)
        lost_second = findViewById(R.id.lost_second)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Found Second Activity")

        switch2.setOnClickListener{
            if(switch2.isChecked){

                linear_add.visibility = View.VISIBLE
                separator.visibility = View.VISIBLE

            }
            else{
                linear_add.visibility = View.GONE
                separator.visibility = View.GONE
            }
        }

        pick_date.setOnClickListener {

            val datePicker = DatePickerFragment()
            datePicker.show(supportFragmentManager,"date picker")
        }


        linear_address.setOnClickListener{
            startActivity(Intent(this@FoundSecondActivity, FoundThirdActivity::class.java))
        }

        btn_submit.setOnClickListener{
            startActivity(Intent(this@FoundSecondActivity, FoundDetailActivity::class.java))
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        show_date.setText(" "+dayOfMonth+"/"+month+"/"+year+" ")
    }
}