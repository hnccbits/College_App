
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

    lateinit var recyclerHomeFirst: RecyclerView

    lateinit var layoutManager: RecyclerView.LayoutManager

    lateinit var recyclerAdapter: HomeRecyclerAdapter

    val displayList= arrayListOf<Food>()


    val menuInfoList = arrayListOf<Food> (

            Food("Ice Cream",R.drawable.askinpoppins.toString(),1),
            Food("Egg",R.drawable.askinpoppins.toString(),2),
            Food("Chicken",R.drawable.askinpoppins.toString(),3),
            Food("Mattan",R.drawable.askinpoppins.toString(),4),
            Food("bread",R.drawable.askinpoppins.toString(),5),
            Food("Italic",R.drawable.askinpoppins.toString(),6),
            Food("Chinese",R.drawable.askinpoppins.toString(),7),
            Food("Japanese",R.drawable.askinpoppins.toString(),8),
            Food("Vegetables",R.drawable.askinpoppins.toString(),9)


    )


    @SuppressLint("ShowToast", "ResourceAsColor")
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_food, container, false)

        displayList.addAll(menuInfoList)

        recyclerHomeFirst = view.findViewById(R.id.recyclerHomeFirst)//initialisation of recycler

        layoutManager = LinearLayoutManager(activity)

        recyclerAdapter = HomeRecyclerAdapter(activity as Context, displayList)

        recyclerHomeFirst.adapter = recyclerAdapter

        recyclerHomeFirst.layoutManager = layoutManager

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
                            if (it.category.toLowerCase(Locale.getDefault()).contains(search)) {
                                displayList.add(it)
                            }
                        }
                        recyclerHomeFirst.adapter?.notifyDataSetChanged()
                    } else {
                        displayList.clear()
                        displayList.addAll(menuInfoList)
                        recyclerHomeFirst.adapter?.notifyDataSetChanged()

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

