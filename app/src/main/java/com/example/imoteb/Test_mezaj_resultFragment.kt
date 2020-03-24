package com.example.imoteb

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate





// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Test_mezaj_resultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Test_mezaj_resultFragment : Fragment()
{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_mezaj_result, container, false)
    }


    var chart: BarChart? = null
    var BARENTRY: ArrayList<BarEntry>? = null
    var BarEntryLabels: ArrayList<String>? = null
    var Bardataset: BarDataSet? = null
    var BARDATA: BarData? = null
    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        BARENTRY = ArrayList()

        BarEntryLabels = ArrayList()

        AddValuesToBARENTRY()

        AddValuesToBarEntryLabels()

        Bardataset = BarDataSet(BARENTRY, "Projects")

        BARDATA = BarData( Bardataset)

        Bardataset!!.setColors(*ColorTemplate.COLORFUL_COLORS)

        chart!!.data = BARDATA

        chart!!.animateY(3000)

    }
    fun AddValuesToBARENTRY()
    {
        BARENTRY!!.add(BarEntry(2f, 0.toFloat()))
        BARENTRY!!.add(BarEntry(4f, 1.toFloat()))
        BARENTRY!!.add(BarEntry(6f, 2.toFloat()))
        BARENTRY!!.add(BarEntry(8f, 3.toFloat()))
        BARENTRY!!.add(BarEntry(7f, 4.toFloat()))
        BARENTRY!!.add(BarEntry(3f, 5.toFloat()))
    }

    fun AddValuesToBarEntryLabels()
    {
        BarEntryLabels!!.add("January")
        BarEntryLabels!!.add("February")
        BarEntryLabels!!.add("March")
        BarEntryLabels!!.add("April")
        BarEntryLabels!!.add("May")
        BarEntryLabels!!.add("June")
    }



    companion object
    {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = Test_mezaj_resultFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}
