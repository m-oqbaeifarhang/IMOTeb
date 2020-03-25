package com.example.imoteb

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_test_mezaj.*
import kotlinx.android.synthetic.main.fragment_test_mezaj_result.*


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


    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        val answer = arguments?.getIntArray("model")
        var barDataSet: BarDataSet = BarDataSet(getData(answer), "راهنما")
        barDataSet.barBorderWidth = 0f
        barDataSet.colors = ColorTemplate.COLORFUL_COLORS.toMutableList()
        var bardata: BarData = BarData(barDataSet)
        var xAxis: XAxis = chart1.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE
        val Mezajs = arrayOf("بلغم", "سودا", "صفرا", "دم")
        val formatter = IndexAxisValueFormatter(Mezajs)
        xAxis.setGranularity(1f)
        xAxis.setValueFormatter(formatter)
        chart1.data = bardata
        chart1.setFitBars(true)
        chart1.axisLeft.axisMinimum = 0f
        chart1.axisRight.axisMinimum = 0f
        chart1.axisRight.axisMaximum = 10f
        chart1.axisLeft.axisMaximum = 10f
        chart1.axisLeft.labelCount = 10
        chart1.axisRight.labelCount = 10
        val ll = LimitLine(5f, "خط اعتدال")
        ll.lineColor = Color.RED
        ll.lineWidth = 3f
        ll.textColor = Color.BLACK
        ll.textSize = 15f
        chart1.axisLeft.addLimitLine(ll)
        chart1.animateXY(2000, 2000);
        chart1.invalidate();

    }

    private fun getData(answer: IntArray?): ArrayList<BarEntry>
    {
        var dam: Float = 0f
        var safra: Float = 0f
        var soda: Float = 0f
        var balgham: Float = 0f
        var counter = 0
        val entries: ArrayList<BarEntry> = ArrayList()
        (answer)?.forEach {
            if(counter in 0..8) safra += it
            if(counter in 9..17) soda += it
            if(counter in 18..26) dam += it
            if(counter in 27..35) balgham += it
            counter++
        }
        dam = (10 * dam) / 18
        safra = (10 * safra) / 18
        soda = (10 * soda) / 18
        balgham = (10 * balgham) / 18
        entries.add(BarEntry(0f, balgham))
        entries.add(BarEntry(1f, soda))
        entries.add(BarEntry(2f, safra))
        entries.add(BarEntry(3f, dam))
        return entries
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

