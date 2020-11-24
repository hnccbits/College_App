
package bitsindri.hncc.collegeapp.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bitsindri.hncc.collegeapp.Adapters.HomeRecyclerAdapter
import bitsindri.hncc.collegeapp.GetterAndSetter.Food
import bitsindri.hncc.collegeapp.R
import bitsindri.hncc.collegeapp.activities.CartActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*


class FoodFragment : Fragment(){

    lateinit var recyclerHome: RecyclerView

    lateinit var layoutManager: RecyclerView.LayoutManager

    lateinit var recyclerAdapter: HomeRecyclerAdapter

    lateinit var btn_cart:FloatingActionButton

    val displayList= arrayListOf<Food>()


    val menuInfoList = arrayListOf<Food> (

            Food("Pind Tadka","4.1","280", R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",1),
            Food("Garbar Burgers","4.6","200", R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",2),
            Food("Baco Tell","3.4","300", R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",3),
            Food("Heera Mahal","4.2","300",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",4),
            Food("Smokin Chik","4.0","250",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",5),
            Food("Swirley's Shack","3.8","400",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",6),
            Food("Dominoe's Bread","3.6","200",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",7),
            Food("Everything But Food","3.2","150",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",8),
            Food("LFC","4.0","200",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",9),
            Food("Central Terk","5.0","300",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",10),
            Food("Mitti Ke Sandwiches","4.0","250",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",11),
            Food("Pizza Put","4.4","350",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",12),
            Food("Burger Jack","3.7","250",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",13),
            Food("Rotten Tomatoes","3.2","100",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",14),
            Food("NcDonald's","3.6","150",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",15),
            Food("Askin Poppins","4.1","300",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",16),
            Food("Bassa Menu","3.4","200",R.drawable.askinpoppins.toString(),"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries.",17))

    private fun checkFav(food_name: String):Int {

        return 1

    }


    @SuppressLint("ShowToast", "ResourceAsColor")
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_food, container, false)

        displayList.addAll(menuInfoList)

        recyclerHome = view.findViewById(R.id.recyclerHome)//initialisation of recycler

        layoutManager = LinearLayoutManager(activity)

        recyclerAdapter = HomeRecyclerAdapter(activity as Context, displayList)

        recyclerHome.adapter = recyclerAdapter

        recyclerHome.layoutManager = layoutManager

        btn_cart = view.findViewById(R.id.btn_cart)

        btn_cart.setOnClickListener{
            startActivity(Intent(activity,CartActivity::class.java))
        }

        this.setHasOptionsMenu(true)//if menu file is not inflating

        return view
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search, menu)

        val item = menu.findItem(R.id.search)

        if (item != null) {
            val searchView = item.actionView as androidx.appcompat.widget.SearchView
            searchView.setOnQueryTextListener(object :
                    androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if (newText!!.isNotEmpty()) {
                        displayList.clear()
                        val search = newText.toLowerCase(Locale.getDefault())
                        menuInfoList.forEach {
                            if (it.menu.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                        }
                        recyclerHome.adapter?.notifyDataSetChanged()
                    } else {
                        displayList.clear()
                        displayList.addAll(menuInfoList)
                        recyclerHome.adapter?.notifyDataSetChanged()

                    }
                    return true
                }


            })
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.search) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}

