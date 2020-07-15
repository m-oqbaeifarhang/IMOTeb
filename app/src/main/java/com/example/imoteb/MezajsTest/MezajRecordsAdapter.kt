package com.example.imoteb.MezajsTest

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.imoteb.Model.MezajResult
import com.example.imoteb.R
import io.realm.RealmQuery
import io.realm.RealmResults

class MezajRecordsAdapter(var items: RealmResults<MezajResult>) :
    RecyclerView.Adapter<MezajRecordsAdapter.ViewHolder>()
{
    lateinit var myContext: Context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var day: TextView = itemView.findViewById(R.id.tv_day)
        var hour: TextView = itemView.findViewById(R.id.tv_hour)
        var am_pm: TextView = itemView.findViewById(R.id.tv_am_pm)
        var linearLayout: LinearLayout = itemView.findViewById(R.id.linearLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.mezaj_records_model, parent, false)
        myContext = parent.context
        return ViewHolder(v)
    }

    override fun getItemCount(): Int
    {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {

        holder.day.setText(items[position]!!.Dam.toString()+" SSS")
        holder.am_pm.setText("AM")
        holder.hour.setText("01:23")
        holder.linearLayout.setOnClickListener {
           var navController = Navigation.findNavController(it)
            Model.Dam = items[position]!!.Dam
            Model.Safra = items[position]!!.Safra
            Model.Soda = items[position]!!.Soda
            Model.Balgham = items[position]!!.Balgham
            navController!!.navigate(R.id.action_mezajRecordsFragment_to_test_mezaj_resultFragment)
        }
    }
}


