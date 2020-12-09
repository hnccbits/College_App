package bitsindri.hncc.collegeapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.drawerlayout.widget.DrawerLayout
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.fragments.FoodFragment
import bitsindri.hncc.collegeapp.fragments.OrderStatusFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class NavigationActivity : AppCompatActivity() {

    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var chipNavigationBar: ChipNavigationBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        toolbar = findViewById(R.id.toolbar)
       chipNavigationBar = findViewById(R.id.menu_nav_bar)

        setUpToolbar()

        openHome()

        chipNavigationBar.setItemSelected(R.id.menu, true)

        chipNavigationBar.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {

            override fun onItemSelected(i: Int) {


                when (i) {
                    R.id.menu -> {
                        supportFragmentManager.beginTransaction()
                                .replace(R.id.frameLayout, FoodFragment()).commit()

                        supportActionBar?.title = "Menu"
                    }
                    R.id.order -> {
                        supportFragmentManager.beginTransaction()
                                .replace(R.id.frameLayout, OrderStatusFragment()).commit()

                        supportActionBar?.title = "Order"
                    }
                    R.id.logOut -> {
                        startActivity(Intent(this@NavigationActivity, LoginActivity::class.java))
                        finish()
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



//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val id = item.itemId
//
//        if (id == R.id.menu){
//            drawerLayout.openDrawer(GravityCompat.START)
//        }
//        return super.onOptionsItemSelected(item)
//    }

    fun openHome(){
        val fragment = FoodFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
        supportActionBar?.title = "Menu"

    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frameLayout)
        when(frag){
            !is FoodFragment -> openHome()

        else ->
        super.onBackPressed()

        }
    }


}

