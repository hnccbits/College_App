package bitsindri.hncc.collegeapp.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bitsindri.hncc.collegeapp.Adapters.HomeRecyclerAdapter
import bitsindri.hncc.collegeapp.Adapters.HomeSecondRecyclerAdapter
import bitsindri.hncc.collegeapp.GetterAndSetter.FoodSecond
import bitsindri.hncc.collegeapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FoodCategoryListActivity : AppCompatActivity() {

    lateinit var btn_cart: FloatingActionButton
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recyclerSecondAdapter:HomeSecondRecyclerAdapter

    var menuDetailList:ArrayList<FoodSecond> = arrayListOf(

            FoodSecond("Pind Tadka","4.1","280", R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",1),
            FoodSecond("Garbar Burgers","4.6","200", R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",2),
            FoodSecond("Baco Tell","3.4","300", R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",3),
            FoodSecond("Heera Mahal","4.2","300",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",4),
            FoodSecond("Smokin Chik","4.0","250",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",5),
            FoodSecond("Swirley's Shack","3.8","400",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",6),
            FoodSecond("Dominoe's Bread","3.6","200",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",7),
            FoodSecond("Everything But Food","3.2","150",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",8),
            FoodSecond("LFC","4.0","200",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",9),
            FoodSecond("Central Terk","5.0","300",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",10),
            FoodSecond("Mitti Ke Sandwiches","4.0","250",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",11),
            FoodSecond("Pizza Put","4.4","350",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",12),
            FoodSecond("Burger Jack","3.7","250",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",13),
            FoodSecond("Rotten Tomatoes","3.2","100",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",14),
            FoodSecond("NcDonald's","3.6","150",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",15),
            FoodSecond("Askin Poppins","4.1","300",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",16),
            FoodSecond("Bassa Menu","3.4","200",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",17))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_category_list)

        btn_cart = findViewById(R.id.btn_cart)
        recyclerView = findViewById(R.id.recyclerHomeSecond)
        layoutManager = LinearLayoutManager(this)

        btn_cart.setOnClickListener{
            startActivity(Intent(this,CartActivity::class.java))
        }

        recyclerSecondAdapter = HomeSecondRecyclerAdapter(this,menuDetailList)
        recyclerView.adapter = recyclerSecondAdapter
        recyclerView.layoutManager = layoutManager
    }
}