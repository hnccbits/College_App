package bitsindri.hncc.collegeapp.activities;

import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.fragments.MapFragment

class LostThirdActivity : AppCompatActivity() {

    lateinit var btn_done: Button
    lateinit var linear_add: LinearLayout
    lateinit var lost_third:LinearLayout
    lateinit var toolbar: Toolbar
   // lateinit var content_frame:FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lost_third)

        btn_done = findViewById(R.id.btn_done)
        linear_add = findViewById(R.id.linear_add)
        lost_third = findViewById(R.id.lost_third)
     //   content_frame = findViewById(R.id.content_frame)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Lost Third Activity")


        btn_done.setOnClickListener(View.OnClickListener { startActivity(Intent(this@LostThirdActivity, LostSecondActivity::class.java)) })

        linear_add.setOnClickListener(View.OnClickListener {

//            lost_third.visibility = View.GONE
//           content_frame.visibility = View.VISIBLE
//           val ft = supportFragmentManager.beginTransaction()
//            ft.replace(R.id.content_frame, MapFragment())
//            ft.commit()

            startActivity(Intent(this,MapActivity::class.java))


        })
    }

//    override fun onBackPressed() {
//        lost_third.visibility = View.VISIBLE
//        content_frame.visibility= View.GONE
//
//    }
}