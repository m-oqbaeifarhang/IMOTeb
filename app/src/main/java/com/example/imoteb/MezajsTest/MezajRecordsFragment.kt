package com.example.imoteb.MezajsTest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imoteb.MainActivity
import com.example.imoteb.R
import kotlinx.android.synthetic.main.fragment_before__test_mezaj_question.*
import kotlinx.android.synthetic.main.fragment_mezaj_queries.*
import kotlinx.android.synthetic.main.fragment_mezaj_records.*
import kotlinx.android.synthetic.main.fragment_test_mezaj_result.*

@Suppress("UNREACHABLE_CODE")
class MezajRecordsFragment : Fragment(),MezajRecordsAdapter.mezajRecordsItemClickListener
{
    var mezajRecordsModel: ArrayList<Mezaj_Records_Model>? = null
    var mezajRecordsAdapter: MezajRecordsAdapter? = null

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mezaj_records, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        /*     set seekbar     */
        nestedScrollView_fragment_mezaj_records.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            val totalScrollLenght =
                nestedScrollView_fragment_mezaj_records.getChildAt(0).height - nestedScrollView_fragment_mezaj_records.height
            progressBar_fragment_mezaj_records.apply {
                max = totalScrollLenght
                progress = scrollY
            }
        }
    }

    @SuppressLint("WrongConstant")
    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        if(activity is AppCompatActivity)
        {
            (activity as AppCompatActivity).setSupportActionBar(toolbar_fg_mezaj_records)
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
            toolbar_fg_mezaj_records.navigationIcon = AppCompatResources.getDrawable(requireContext(), R.drawable.ic_close)
        }
        toolbar_fg_mezaj_records.setNavigationOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

        rv_mezaj_records.setHasFixedSize(true)
        rv_mezaj_records.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL,false)
        mezajRecordsModel = ArrayList()
        mezajRecordsModel?.add(Mezaj_Records_Model("شنبه","16","بعد از ظهر"))
        mezajRecordsModel?.add(Mezaj_Records_Model("یکشنبه","07","قبل از ظهر"))
        mezajRecordsModel?.add(Mezaj_Records_Model("دوشنبه","17","بعد از ظهر"))
        mezajRecordsModel?.add(Mezaj_Records_Model("سه شنبه","22","بعد از ظهر"))
        mezajRecordsModel?.add(Mezaj_Records_Model("چهارشنبه","13","بعد از ظهر"))
        mezajRecordsModel?.add(Mezaj_Records_Model("پنجشنبه","14","بعد از ظهر"))
        mezajRecordsModel?.add(Mezaj_Records_Model("جمعه","08","قبل از ظهر"))
        mezajRecordsModel?.add(Mezaj_Records_Model("جمعه","08","قبل از ظهر"))
        mezajRecordsModel?.add(Mezaj_Records_Model("جمعه","08","قبل از ظهر"))
        mezajRecordsModel?.add(Mezaj_Records_Model("جمعه","08","قبل از ظهر"))
        mezajRecordsAdapter = MezajRecordsAdapter(mezajRecordsModel!!,this)
        rv_mezaj_records.adapter = mezajRecordsAdapter

    }
    override fun onItemClick(items: Mezaj_Records_Model, position: Int)
    {
        Toast.makeText(context,position.toString(), Toast.LENGTH_SHORT).show()
    }

}