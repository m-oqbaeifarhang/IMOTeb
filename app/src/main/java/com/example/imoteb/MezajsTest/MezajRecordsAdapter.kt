package com.example.imoteb.MezajsTest

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imoteb.Model.MezajResult
import com.example.imoteb.R
import io.realm.RealmQuery
import io.realm.RealmResults

class MezajRecordsAdapter(var items: RealmResults<MezajResult> , var clickListener: mezajRecordsItemClickListener): RecyclerView.Adapter<MezajRecordsAdapter.ViewHolder>()
{
    lateinit var myContext : Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.mezaj_records_model, parent, false)
        myContext = parent.context
        return ViewHolder(v)
    }

    override fun getItemCount(): Int
    {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
       // holder.initialize(items[position],clickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var day : TextView = itemView.findViewById(R.id.tv_day)
        var hour : TextView = itemView.findViewById(R.id.tv_hour)
        var am_pm : TextView = itemView.findViewById(R.id.tv_am_pm)

        fun initialize (item : MezajResult, action : mezajRecordsItemClickListener){
            day.text = "day"
            hour.text = "hour"
            am_pm.text = "AM"
            itemView.setOnClickListener {
                action.onItemClick(item,adapterPosition)

            }
        }
    }

    interface mezajRecordsItemClickListener{
        fun onItemClick(items: MezajResult, position: Int)
    }

}


