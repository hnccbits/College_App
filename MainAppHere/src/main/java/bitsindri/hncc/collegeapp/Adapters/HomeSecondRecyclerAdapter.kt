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
import bitsindri.hncc.collegeapp.GetterAndSetter.FoodSecond
import bitsindri.hncc.collegeapp.GetterAndSetter.feed
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.activities.FoodDetailActivity

class HomeSecondRecyclerAdapter(context: Context, itemList: ArrayList<FoodSecond>) : RecyclerView.Adapter<HomeSecondRecyclerAdapter.HomeSecondViewHolder>() {

    var context: Context
    var itemList: ArrayList<FoodSecond>


    lateinit var userId:String

    var heartColor = "white"

    //whenever object for above class is created code inside initializer block is created
    init {
        this.context = context
        this.itemList = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeSecondViewHolder {

        //responsible for creating initial 10 views
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_food_category_list, parent, false
        )
        return HomeSecondViewHolder(view)//object of homeviewholder class

    }

    override fun getItemCount(): Int {

        return itemList.size


    }

    override fun onBindViewHolder(holder: HomeSecondViewHolder, position: Int) {


        val food = itemList[position]
        holder.txtname.text = food.menu
        holder.imgimage_url.setImageResource(food.image_url.toInt())
        holder.txtcost_for_one.text = food.cost_for_one
        holder.txtrating.text = food.rating

        val FoodHolder = holder as HomeSecondViewHolder

        holder.food_main_layout.setOnClickListener{

            val intent = Intent(context, FoodDetailActivity::class.java)
            intent.putExtra("menu",food.menu)
            intent.putExtra("cost",food.cost_for_one)
            intent.putExtra("rating",food.rating)
            intent.putExtra("image_url",food.image_url)
            intent.putExtra("desc",food.description)
            intent.putExtra("id",food.id)
            context.startActivity(intent)

        }




    }


    class HomeSecondViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {

        //initialisation of various views of food data class

        val txtname: TextView
        var txtcost_for_one: TextView
        val txtrating: TextView
        val imgimage_url: ImageView
        val imgFav: ImageView
        val food_main_layout:CardView

        init {
            txtname = itemView.findViewById(R.id.txtname)
            txtcost_for_one = itemView.findViewById(R.id.txtcost_for_one)
            txtrating = itemView.findViewById(R.id.txtrating)
            imgimage_url = itemView.findViewById(R.id.image_url)
            imgFav = itemView.findViewById(R.id.imgFav)
            food_main_layout= itemView.findViewById(R.id.food_second_layout)
        }


    }
}






















