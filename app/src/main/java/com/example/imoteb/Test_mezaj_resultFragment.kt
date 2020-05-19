package com.example.imoteb

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_test_mezaj_result.*

class Test_mezaj_resultFragment : Fragment()
{

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
        /*set Toolbar*/
        if(activity is AppCompatActivity)
        {
            (activity as AppCompatActivity).setSupportActionBar(toolbar_test_mezaj_resultFragmaent)
            toolbar_test_mezaj_resultFragmaent.navigationIcon =
                AppCompatResources.getDrawable(requireContext(), R.drawable.ic_close)
            //            (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.my_title_string)
        }
        toolbar_test_mezaj_resultFragmaent.setNavigationOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

        val barDataSet: BarDataSet = BarDataSet(getData(Model.Answers), "راهنما")
        barDataSet.barBorderWidth = 0f
        barDataSet.colors = ColorTemplate.COLORFUL_COLORS.toMutableList()
        val bardata: BarData = BarData(barDataSet)
        val xAxis: XAxis = chart1.xAxis
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
        val CMR = MohasebehMezaj.Calculate(Model.Answers)
        //        val miangin=(CMR.dam+CMR.safra+CMR.soda+CMR.balgham)/4f
        //        val ll = LimitLine(miangin, "خط اعتدال")
        //        ll.lineColor = Color.RED
        //        ll.lineWidth = 3f
        //        ll.textColor = Color.BLACK
        //        ll.textSize = 15f↓
        //      chart1.axisLeft.addLimitLine(ll)
        chart1.animateXY(2000, 2000);
        chart1.invalidate()
        val mg = Mohasebeh_GhalabeHa.Mohasebe(CMR.dam, CMR.safra, CMR.soda, CMR.balgham)
        setTitle(mg)

    }

    private fun getData(answer: MutableList<Int>): ArrayList<BarEntry>
    {
        var counter = 0
        val entries: ArrayList<BarEntry> = ArrayList()
        //val CMR = answer?.let { ComputeMezajs(it) }
        val CMR = MohasebehMezaj.Calculate(answer)
        entries.add(BarEntry(0f, CMR.balgham))
        entries.add(BarEntry(1f, CMR.soda))
        entries.add(BarEntry(2f, CMR.safra))
        entries.add(BarEntry(3f, CMR.dam))
        //  Model.Answers = null
        return entries
    }

    private fun setTitle(mezajehGhalebehEnum: MezajehGhalebehEnum)
    {
        when(mezajehGhalebehEnum)
        {
            MezajehGhalebehEnum.NaMotabar ->
            {
                title.setText("نتیحه تست: نا معتبر. پاسخ ها را به درستی جواب دهید.")
            }
            //---------------------------------------------
            MezajehGhalebehEnum.GhalabehKamDam ->
            {
                title.setText("غلبه کم دم")
            }
            MezajehGhalebehEnum.GhalabehMotavasetDam ->
            {
                title.setText("غلبه متوسط دم")
            }
            MezajehGhalebehEnum.GhalabehShadidDam ->
            {
                title.setText("غلبه شدید دم")
            }
            //----------------------------------------------
            MezajehGhalebehEnum.GhalabehKamsafra ->
            {
                title.setText("غلبه کم صفرا")

            }
            MezajehGhalebehEnum.GhalabehMotavasetsafra ->
            {
                title.setText("غلبه متوسط صفرا")

            }
            MezajehGhalebehEnum.GhalabehShadidsafra ->
            {
                title.setText("غلبه شدید صفرا")

            }
            //-----------------------------------------------
            MezajehGhalebehEnum.GhalabehKamsoda ->
            {
                title.setText("غلبه کم سودا")
            }
            MezajehGhalebehEnum.GhalabehMotavasetsoda ->
            {
                title.setText("غلبه متوسط سودا")
            }
            MezajehGhalebehEnum.GhalabehShadidsoda ->
            {
                title.setText("غلبه شدید سودا")
            }
            //-----------------------------------------------
            MezajehGhalebehEnum.GhalabehKambalgham ->
            {
                title.setText("غلبه کم بلغم")
            }
            MezajehGhalebehEnum.GhalabehMotavasetbalgham ->
            {
                title.setText("غلبه متوسط بلغم")
            }
            MezajehGhalebehEnum.GhalabehShadidbalgham ->
            {
                title.setText("غلبه شدید بلغم")
            }
            //-------------------------------------------------
            MezajehGhalebehEnum.Rih ->
            {
                title.setText("غلبه ریح")
            }
            //-------------------------------------------------
            MezajehGhalebehEnum.Etedal ->
            {
                title.setText("مزاج شما تقریبا در اعتدال است.")
            }

        }
    }

}
