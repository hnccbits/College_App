package com.anjali.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anjali.myapplication.R
import com.anjali.myapplication.models.StaticRecyclerViewModel

class StaticRecyclerViewAdapter(val items: ArrayList<StaticRecyclerViewModel>, var row_index: Int =-1):
    RecyclerView.Adapter<StaticRecyclerViewAdapter.StaticRVViewHolder>() {

    class StaticRVViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

        val textView:TextView = itemView.findViewById(R.id.text)
        val imageView:ImageView = itemView.findViewById(R.id.image)
        val linearLayout:LinearLayout = itemView.findViewById(R.id.linearLayout)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StaticRVViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.static_rv_item,parent,false)

        val staticRVViewHolder = StaticRVViewHolder(view)
        return staticRVViewHolder

    }

    override fun onBindViewHolder(holder: StaticRVViewHolder, position: Int) {
     val currentItem =items.get(position)
        holder.imageView.setImageResource(currentItem.getImage())
        holder.textView.setText(currentItem.getText())

        holder.linearLayout.setOnClickListener{
            row_index = position;
            notifyDataSetChanged()
        }

        if(row_index==position)
            holder.linearLayout.setBackgroundResource(R.drawable.static_recycler_view_background)
        else
            holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected)

    }

    override fun getItemCount(): Int {
       return items.size
    }
}