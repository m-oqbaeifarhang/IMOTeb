package com.example.imoteb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MezajAdapter(items: ArrayList<Mezaj_Model> , var clickListener: mezajItemClickListener): RecyclerView.Adapter<MezajAdapter.ViewHolder>()
{
    lateinit var myContext : Context
    var items: ArrayList<Mezaj_Model>? = null

    init
    {
        this.items =  items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MezajAdapter.ViewHolder
    {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.mezaj_model, parent, false)
        myContext = parent.context
        return MezajAdapter.ViewHolder(v)
    }

    override fun getItemCount(): Int
    {
        return this.items!!.size

    }

    override fun onBindViewHolder(holder: MezajAdapter.ViewHolder, position: Int)
    {
//        val item = items?.get(position)
//        holder.title.text = item?.mezaj_title
//        holder.description.text = item?.mezaj_description
//        holder.image.setImageResource(item?.image!!)

//        holder.itemView.setOnClickListener {
//            Toast.makeText(myContext,holder.title.text,Toast.LENGTH_SHORT).show()
//        }

        holder.initialize(items!!.get(position),clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var title : TextView = itemView.findViewById(R.id.mezaj_title)
        var description : TextView = itemView.findViewById(R.id.mezaj_desc)
        var image : ImageView = itemView.findViewById(R.id.img_mezaj)

        fun initialize (item : Mezaj_Model , action : mezajItemClickListener){
            title.text = item.mezaj_title
            description.text = item.mezaj_description
            image.setImageResource(item.image)

            itemView.setOnClickListener {
                action.onItemClick(item,adapterPosition)
            }
        }
    }

    interface mezajItemClickListener{
        fun onItemClick(items: Mezaj_Model , position: Int)
    }

}


