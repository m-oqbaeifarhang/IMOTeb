package com.example.imoteb.MezajsTest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imoteb.R

class MezajAdapter(items: ArrayList<Mezaj_Model> , var clickListener: mezajItemClickListener): RecyclerView.Adapter<MezajAdapter.ViewHolder>()
{
    lateinit var myContext : Context
    var items: ArrayList<Mezaj_Model>? = null

    init
    {
        this.items =  items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.mezaj_model, parent, false)
        myContext = parent.context
        return ViewHolder(v)
    }

    override fun getItemCount(): Int
    {
        return this.items!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.initialize(items!!.get(position),clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var title : TextView = itemView.findViewById(R.id.mezaj_title)
        var description : TextView = itemView.findViewById(R.id.mezaj_desc)
        var image : ImageView = itemView.findViewById(R.id.img_mezaj)

        fun initialize (item : Mezaj_Model, action : mezajItemClickListener){
            title.text = item.mezaj_title
            description.text = item.mezaj_description
            image.setImageResource(item.image)

            itemView.setOnClickListener {
                action.onItemClick(item,adapterPosition)
            }
        }
    }

    interface mezajItemClickListener{
        fun onItemClick(items: Mezaj_Model, position: Int)
    }

}


