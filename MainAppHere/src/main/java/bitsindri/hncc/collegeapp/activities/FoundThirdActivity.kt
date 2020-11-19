package bitsindri.hncc.collegeapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import bitsindri.hncc.collegeapp.R
import com.projectubu.personaldashboard.LostSecondActivity

class FoundThirdActivity : AppCompatActivity() {

    lateinit var btn_done: Button
    lateinit var linear_add: LinearLayout
    lateinit var lost_third: LinearLayout
    lateinit var content_frame: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_found_third)

        btn_done = findViewById(R.id.btn_done)
        linear_add = findViewById(R.id.linear_add)
        lost_third = findViewById(R.id.lost_third)
        content_frame = findViewById(R.id.content_frame)

        btn_done.setOnClickListener(View.OnClickListener { startActivity(Intent(this@FoundThirdActivity, LostSecondActivity::class.java)) })

        linear_add.setOnClickListener(View.OnClickListener {

            lost_third.visibility = View.GONE
            content_frame.visibility = View.VISIBLE
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.content_frame, MapFragment())
            ft.commit()


        })
    }

    override fun onBackPressed() {
        lost_third.visibility = View.VISIBLE
        content_frame.visibility= View.GONE

    }
}