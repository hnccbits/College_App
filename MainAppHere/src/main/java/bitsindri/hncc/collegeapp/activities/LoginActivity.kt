package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import bitsindri.hncc.collegeapp.Adapters.LoginAdapter
import bitsindri.hncc.collegeapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

class LoginActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var fb:FloatingActionButton
    lateinit var google:FloatingActionButton
    lateinit var github:FloatingActionButton
    var v:Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tabLayout = findViewById(R.id.tab_layout)
        viewPager=findViewById(R.id.view_pager)
        fb = findViewById(R.id.fab_fb)
        google = findViewById(R.id.fab_google)
        github = findViewById(R.id.fab_github)

        tabLayout.addTab(tabLayout.newTab().setText("Login"))
        tabLayout.addTab(tabLayout.newTab().setText("Signup"))


        val adapter = LoginAdapter(supportFragmentManager,this,tabLayout.tabCount)
        viewPager.adapter=adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
               viewPager.currentItem= tab?.position!!

            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

        })

        fb.translationY = 300F
        google.translationY=300F
        github.translationY=300F
        tabLayout.translationY=300F

        fb.setAlpha(v)
        google.setAlpha(v)
        github.setAlpha(v)
        tabLayout.setAlpha(v)

        fb.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(400).start()
        google.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(600).start()
        github.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(800).start()
        tabLayout.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(800).start()
    }
}