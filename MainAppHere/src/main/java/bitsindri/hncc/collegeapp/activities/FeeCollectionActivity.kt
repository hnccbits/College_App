package bitsindri.hncc.collegeapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bitsindri.hncc.collegeapp.Adapters.CrtAdapter
import bitsindri.hncc.collegeapp.Adapters.FeeCollectionAdapter
import bitsindri.hncc.collegeapp.Custom_Classes.Fee
import bitsindri.hncc.collegeapp.R

class FeeCollectionActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var toolbar: Toolbar
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fee_collection)

        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Fee Collection")

        recyclerView = findViewById(R.id.feeRecyclerView)
        layoutManager= LinearLayoutManager(this)


        val feeItems = arrayListOf<Fee>(
                Fee("Saraswati uja","Rs. 250"),
                Fee("Lohri","Rs. 300"),
                Fee("Holi","Rs. 120"),
                Fee("Durga puja","Rs. 20"),
                Fee("Dipawali","Rs. 30"),
                Fee("Chhat puja","Rs. 250"),
                Fee("Saraswati uja","Rs. 250"),
                Fee("Lohri","Rs. 300"),
                Fee("Holi","Rs. 120"),
                Fee("Durga puja","Rs. 20"),
                Fee("Dipawali","Rs. 30"),
                Fee("Chhat puja","Rs. 250")

        )

        val adapter = FeeCollectionAdapter(this,feeItems)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager


    }
}