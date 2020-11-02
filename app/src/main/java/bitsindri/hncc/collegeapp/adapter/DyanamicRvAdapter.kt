package com.anjali.myapplication.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anjali.myapplication.DynamiRVInterface.LoadMore
import com.anjali.myapplication.models.DynamicRVModelClass
import com.anjali.myapplication.R

class ItemVIewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    val name:TextView = itemView.findViewById(R.id.name)
    val details:TextView = itemView.findViewById(R.id.details)
    val ratingBar:RatingBar = itemView.findViewById(R.id.rating)
}

class LoadingViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

//  val progress_bar:ProgressBar = itemView.findViewById(R.id.progress_bar)

}

class DyanamicRvAdapter(recyclerView: RecyclerView,val activity:Activity,val items:List<DynamicRVModelClass>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    val VIEW_TYPE_ITEM = 0
    val VIEW_TYPE_LOADING = 1
    lateinit var loadMore: LoadMore
    val visibleThreshold=5
    var lastVisibleItem:Int = -1
    var totalItemCount:Int=0
    var isLoading:Boolean = false

    lateinit var view: RecyclerView.ViewHolder

    init {
        val layoutManager:LinearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
        recyclerView.addOnScrollListener(object :RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                totalItemCount = layoutManager.itemCount
                lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {

                    if (loadMore != null) {
                        loadMore.onLoadMore()
                        isLoading = true
                    }
                }
            }
        })


    }

    override fun getItemViewType(position:Int):Int{
        return VIEW_TYPE_ITEM
    }

    @JvmName("setLoadMore1")
    fun setLoadMore(loadMore: LoadMore){
        this.loadMore = loadMore
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if(viewType == VIEW_TYPE_ITEM){
            val view = LayoutInflater.from(activity).inflate(R.layout.dyanamic_rv_item,parent,false)
            return LoadingViewHolder(view)

        }else if(viewType==VIEW_TYPE_LOADING){
            val view = LayoutInflater.from(activity).inflate(R.layout.dynamic_rv_progress_bar,parent,false)
            return LoadingViewHolder(view)
        }

        return  view

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ItemVIewHolder){
            val item = items.get(position)
            val viewHolder = holder
            viewHolder.name.setText(item.getName())
        }
//        else if(holder is LoadingViewHolder){
//
//         holder.progress_bar
//
//        }

    }

    override fun getItemCount(): Int {

        return  items.size
    }

    fun setLoaded(){
        isLoading = false
    }
}