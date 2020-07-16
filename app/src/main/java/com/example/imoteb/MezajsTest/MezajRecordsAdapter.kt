package com.example.imoteb.MezajsTest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.imoteb.Model.MezajResult
import com.example.imoteb.R
import io.realm.RealmResults
import saman.zamani.persiandate.PersianDate
import saman.zamani.persiandate.PersianDateFormat
import java.time.format.DateTimeFormatter

class MezajRecordsAdapter(var items: List<MezajResult>) :
    RecyclerView.Adapter<MezajRecordsAdapter.ViewHolder>()
{
    lateinit var myContext: Context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var day: TextView = itemView.findViewById(R.id.tv_day)
        var hour: TextView = itemView.findViewById(R.id.tv_hour)
        var Date: TextView = itemView.findViewById(R.id.tv_date)
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
        val pdate = PersianDate(items[position]!!.Date)
        val pdformaterDate: PersianDateFormat = PersianDateFormat("Y/m/d")
        val pDFormatterTime:PersianDateFormat=PersianDateFormat("g:i")
        val pfDate = pdformaterDate.format(pdate) //1396/05/20
        var pfTime=pDFormatterTime.format(pdate)
        holder.day.setText(pdate.dayName()+" -")
        holder.hour.setText(pfTime)
        holder.Date.setText(pfDate)
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


