package com.example.imoteb.MezajsTest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imoteb.R

class MezajRecordsAdapter(items: ArrayList<Mezaj_Records_Model> , var clickListener: mezajRecordsItemClickListener): RecyclerView.Adapter<MezajRecordsAdapter.ViewHolder>()
{
    lateinit var myContext : Context
    var myItems: ArrayList<Mezaj_Records_Model>? = null

    init
    {
        this.myItems =  items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.mezaj_records_model, parent, false)
        myContext = parent.context
        return ViewHolder(v)
    }

    override fun getItemCount(): Int
    {
        return this.myItems!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.initialize(myItems!![position],clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var day : TextView = itemView.findViewById(R.id.tv_day)
        var hour : TextView = itemView.findViewById(R.id.tv_hour)
        var am_pm : TextView = itemView.findViewById(R.id.tv_am_pm)

        fun initialize (item : Mezaj_Records_Model, action : mezajRecordsItemClickListener){
            day.text = item.day
            hour.text = item.hour
            am_pm.text = item.am_pm

            itemView.setOnClickListener {
                action.onItemClick(item,adapterPosition)
            }
        }
    }

    interface mezajRecordsItemClickListener{
        fun onItemClick(items: Mezaj_Records_Model, position: Int)
    }

}


