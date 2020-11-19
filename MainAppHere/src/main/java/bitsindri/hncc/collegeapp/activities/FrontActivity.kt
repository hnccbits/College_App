package bitsindri.hncc.collegeapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.activities.FoundFirstActivity
import bitsindri.hncc.collegeapp.activities.LostFirstActivity

class FrontActivity : AppCompatActivity() {

   lateinit var cardView: CardView
    lateinit var cardView1: CardView
    lateinit var  toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front)

        cardView = findViewById(R.id.cardView)
        cardView1 = findViewById(R.id.cardView1)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Choose Activity")

        cardView.setOnClickListener(View.OnClickListener { startActivity(Intent(this@FrontActivity, LostFirstActivity::class.java)) })
        cardView1.setOnClickListener(View.OnClickListener { startActivity(Intent(this@FrontActivity, FoundFirstActivity::class.java)) })
    }
}