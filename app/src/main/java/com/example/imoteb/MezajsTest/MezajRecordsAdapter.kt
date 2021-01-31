package com.example.imoteb.MezajsTest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.imoteb.Model.MezajResult
import com.example.imoteb.R
import saman.zamani.persiandate.PersianDate
import saman.zamani.persiandate.PersianDateFormat

class MezajRecordsAdapter(var items: List<MezajResult>) :
    RecyclerView.Adapter<MezajRecordsAdapter.ViewHolder>()
{
    lateinit var myContext: Context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var day: TextView = itemView.findViewById(R.id.actv_day)
        var hour: TextView = itemView.findViewById(R.id.actv_hour)
        var Date: TextView = itemView.findViewById(R.id.actv_date)
        var Title:TextView=itemView.findViewById(R.id.actv_mezaj_result_title)
        var constraintLayout: ConstraintLayout = itemView.findViewById(R.id.cl_all)

    }

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
        var Dam=items[position].Dam
        var Safra=items[position].Safra
        var Soda=items[position].Soda
        var Balgham=items[position].Balgham
        var Date=items[position].Date
        val pdate = PersianDate(Date)
        val pdformaterDate: PersianDateFormat = PersianDateFormat("Y/m/d")
        val pDFormatterTime:PersianDateFormat=PersianDateFormat("g:i")
        val pfDate = pdformaterDate.format(pdate) //1396/05/20
        var pfTime=pDFormatterTime.format(pdate)

        holder.day.setText(pdate.dayName()+" -")
        holder.hour.setText(pfTime)
        holder.Date.setText(pfDate)
    var mezajGhaleb = Mohasebeh_GhalabeHa.Mohasebe(dam = Dam,safra = Safra,soda = Soda,balgham = Balgham)
        val PersianmezajGhalabe = Mohasebeh_GhalabeHa.convertMezajGhalebToPersianText(mezajGhaleb)
        holder.Title.setText(PersianmezajGhalabe)
        holder.constraintLayout.setOnClickListener {
            var navController = Navigation.findNavController(it)
            Model.Dam = Dam
            Model.Safra = Safra
            Model.Soda = Soda
            Model.Balgham = Balgham
            navController!!.navigate(R.id.action_mezajRecordsFragment_to_test_mezaj_resultFragment)
        }
    }
}


