package com.example.imoteb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MezajAdapter(items: ArrayList<Mezaj_Model>): RecyclerView.Adapter<MezajAdapter.ViewHolder>()
{
    var items: ArrayList<Mezaj_Model>? = null

    init
    {
        this.items =  items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MezajAdapter.ViewHolder
    {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.mezaj_model, parent, false)
        return MezajAdapter.ViewHolder(v)
    }

    override fun getItemCount(): Int
    {
        return this.items!!.size

    }

    override fun onBindViewHolder(holder: MezajAdapter.ViewHolder, position: Int)
    {
        val item = items?.get(position)
        holder.title.text = item?.mezaj_title
        holder.description.text = item?.mezaj_description
        holder.image.setImageResource(item?.image!!)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var title : TextView = itemView.findViewById(R.id.mezaj_title)
        var description : TextView = itemView.findViewById(R.id.mezaj_desc)
        var image : ImageView = itemView.findViewById(R.id.img_mezaj)
    }

}









/*
class MezajAdapter(val title_mezaj: MutableList<String>) : RecyclerView.Adapter<MezajAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MezajAdapter.ViewHolder
    {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.mezaj_model, parent, false)
        return MezajAdapter.ViewHolder(v)
    }


    override fun getItemCount(): Int
    {
        return title_mezaj.size
    }


    override fun onBindViewHolder(holder: MezajAdapter.ViewHolder, position: Int)
    {
        val title: String = title_mezaj[position]
        holder.title.text = title
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var title : TextView = itemView.findViewById(R.id.mezaj_title)
    }
}*/
