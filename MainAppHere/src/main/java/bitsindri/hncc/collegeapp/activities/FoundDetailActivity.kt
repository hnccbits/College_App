package bitsindri.hncc.collegeapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import bitsindri.hncc.collegeapp.R
import com.google.android.material.appbar.CollapsingToolbarLayout

class FoundDetailActivity : AppCompatActivity() {

    lateinit var toolbarLayout:Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_found_detail)

        toolbarLayout = findViewById(R.id.toolbar)

        setSupportActionBar(toolbarLayout)
        supportActionBar?.setTitle("Found Detail Activity")
    }
}