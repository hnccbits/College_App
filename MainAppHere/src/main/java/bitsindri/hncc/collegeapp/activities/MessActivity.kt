package bitsindri.hncc.collegeapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.fragments.*
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MessActivity : AppCompatActivity() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var chipNavigationBar: ChipNavigationBar
    lateinit var spinner1:Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mess)

        toolbar = findViewById(R.id.toolbar)
        chipNavigationBar = findViewById(R.id.mess_nav_bar)
        spinner1 = findViewById(R.id.spinner1)

        val weekAdapter = ArrayAdapter<String>(this@MessActivity,android.R.layout.simple_list_item_1,resources.getStringArray(R.array.week_day))

        weekAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter=weekAdapter


        setUpToolbar()

        openHome()

        chipNavigationBar.setItemSelected(R.id.menu_mess, true)

        chipNavigationBar.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {

            override fun onItemSelected(i: Int) {


                when (i) {
                    R.id.menu_mess -> {
                        supportFragmentManager.beginTransaction()
                                .replace(R.id.frameLayout, MessMenuFragment()).commit()

                        supportActionBar?.title = "Menu"
                    }
                    R.id.report -> {
                        supportFragmentManager.beginTransaction()
                                .replace(R.id.frameLayout, ReportFragment()).commit()

                        supportActionBar?.title = "Report"
                    }
                    R.id.update -> {
                        supportFragmentManager.beginTransaction()
                                .replace(R.id.frameLayout, UpdateMessMenuFragment()).commit()

                        supportActionBar?.title = "Change Menu"
                    }

                }
            }
        })

    }

    fun setUpToolbar()
    {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Menu"
        // supportActionBar?.setHomeButtonEnabled(true)
        // supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    fun openHome(){
        val fragment = MessMenuFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
        supportActionBar?.title = "Menu"

    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frameLayout)
        when(frag){
            !is MessMenuFragment -> openHome()

            else ->
                super.onBackPressed()

        }
    }
}