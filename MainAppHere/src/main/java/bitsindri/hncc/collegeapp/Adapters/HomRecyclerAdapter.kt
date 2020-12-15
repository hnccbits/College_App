package bitsindri.hncc.collegeapp.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import bitsindri.hncc.collegeapp.Adapters.homeFeedAdapter.FeedHolder
import bitsindri.hncc.collegeapp.GetterAndSetter.Food
import bitsindri.hncc.collegeapp.GetterAndSetter.feed
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.activities.FoodCategoryListActivity
import bitsindri.hncc.collegeapp.activities.FoodDetailActivity

class HomeRecyclerAdapter(context: Context, itemList: ArrayList<Food>) : RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder>() {

    var context: Context
    var itemList: ArrayList<Food>

    //whenever object for above class is created code inside initializer block is created
    init {
        this.context = context
        this.itemList = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        //responsible for creating initial 10 views
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_home_single_row, parent, false
        )
        return HomeViewHolder(view)//object of homeviewholder class

    }

    override fun getItemCount(): Int {

        return itemList.size


    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {


        val food = itemList[position]
        holder.imgimage_url.setImageResource(food.image_url.toInt())
        holder.txtcategory.text = food.category

        val FoodHolder = holder as HomeViewHolder

        holder.food_main_layout.setOnClickListener{

            val intent = Intent(context, FoodCategoryListActivity::class.java)
            intent.putExtra("category",food.category)
            intent.putExtra("image_url",food.image_url)
            context.startActivity(intent)

        }




    }


    class HomeViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        //initialisation of various views of food data class

        val txtcategory: TextView
        val imgimage_url: ImageView
        val food_main_layout:CardView

        init {
            txtcategory = itemView.findViewById(R.id.txtcategory)
            imgimage_url = itemView.findViewById(R.id.imgimage_url)
            food_main_layout= itemView.findViewById(R.id.food_main_layout)
        }


    }
}




















