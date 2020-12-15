package bitsindri.hncc.collegeapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import bitsindri.hncc.collegeapp.Custom_Classes.SampleData
import bitsindri.hncc.collegeapp.R
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class FoodDetailActivity : AppCompatActivity() {

    lateinit var collapsingToolbarLayout: CollapsingToolbarLayout

    lateinit var img_food:ImageView
    lateinit var food_name:TextView
    lateinit var food_price:TextView
    lateinit var food_desc:TextView
    lateinit var food_rating:TextView
   lateinit var btn_cart:FloatingActionButton
    lateinit var number_button:ElegantNumberButton


    var menu:String=""
    var cost:String=""
    var rating:String=""
    var image_url:String=""
    var desc=""
    var id =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)


        img_food = findViewById(R.id.img_food)
        food_desc = findViewById(R.id.food_desc)
        food_name = findViewById(R.id.food_name)
        food_price = findViewById(R.id.food_price)
        btn_cart = findViewById(R.id.btn_cart)
        food_rating = findViewById(R.id.food_rating)
        number_button = findViewById(R.id.number_button)

        collapsingToolbarLayout = findViewById(R.id.collapsing)
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapseAppbar)
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar)

        val foodIntent = intent

        menu = foodIntent.getStringExtra("menu").toString()
        cost = foodIntent.getStringExtra("cost").toString()
        rating = foodIntent.getStringExtra("rating").toString()
        image_url = foodIntent.getStringExtra("image_url").toString()
        desc = foodIntent.getStringExtra("desc").toString()
       // id = foodIntent.getStringExtra("id")?.toInt()!!

        food_price.setText(cost)
        food_name.setText(menu)
        food_desc.setText(desc)
        food_rating.setText(rating)
        collapsingToolbarLayout.title = menu

        btn_cart.setOnClickListener{

          Toast.makeText(this,"Item added to cart",Toast.LENGTH_SHORT).show()

        }

    }

}