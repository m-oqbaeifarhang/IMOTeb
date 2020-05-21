package com.example.imoteb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FoodsAdapter (food_items : ArrayList<Foods_Model> ) : RecyclerView.Adapter<FoodsAdapter.ViewHolder>()
{
    lateinit var myContext : Context
    var items: ArrayList<Foods_Model>? = null
    init
    {
        this.items = food_items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsAdapter.ViewHolder
    {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.food_model,parent,false)
        myContext = parent.context
        return FoodsAdapter.ViewHolder(v)
    }

    override fun getItemCount(): Int
    {
        return items!!.size
    }

    override fun onBindViewHolder(holder: FoodsAdapter.ViewHolder, position: Int)
    {
         val item = items?.get(position)
         holder.title.text = item?.food_name
         holder.image.setImageResource(item?.food_img!!)

         holder.itemView.setOnClickListener {
             Toast.makeText(myContext,holder.title.text,Toast.LENGTH_SHORT).show()
         }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var title : TextView = itemView.findViewById(R.id.food_name)
        var image : ImageView = itemView.findViewById(R.id.food_img)
    }

}