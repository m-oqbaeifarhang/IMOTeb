package com.example.imoteb.MezajsTest

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.imoteb.Adapter.NatayejViewPagerAdapter
import com.example.imoteb.MainActivity
import com.example.imoteb.R
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.android.material.tabs.TabLayout
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)

        val natayejTablayout = requireView().findViewById(R.id.natayejTablayout) as TabLayout
        val natayejViewPager = requireView().findViewById(R.id.natayejViewPager) as ViewPager
        val natayejViewPagerAdapter =
            NatayejViewPagerAdapter(requireActivity().supportFragmentManager)
        natayejViewPagerAdapter.addFragment(TosiyehayePezeshkiFragment(), "توصیه های پزشکی")
        natayejViewPagerAdapter.addFragment(KhususiyatAkhlagiFragment(), "خصوصیات اخلاقی")
        natayejTablayout.tabGravity = TabLayout.GRAVITY_FILL
        natayejViewPager.adapter = natayejViewPagerAdapter
        natayejTablayout.setupWithViewPager(natayejViewPager)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {

        super.onActivityCreated(savedInstanceState)
        /*set Toolbar*/
        if(activity is AppCompatActivity)
        {
            (activity as AppCompatActivity).setSupportActionBar(toolbar_test_mezaj_resultFragmaent)
            toolbar_test_mezaj_resultFragmaent.navigationIcon =
                AppCompatResources.getDrawable(requireContext(),
                    R.drawable.ic_close)
            //            (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.my_title_string)
        }
        toolbar_test_mezaj_resultFragmaent.setNavigationOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

        val barDataSet: BarDataSet = BarDataSet(getData(Model.questionTableList), "راهنما")
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
        val CMR = MohasebehMezaj.Calculate(Model.questionTableList)
        chart1.animateXY(2000, 2000);
        chart1.invalidate()
        val mg = Mohasebeh_GhalabeHa.Mohasebe(CMR.dam, CMR.safra, CMR.soda, CMR.balgham)
        setTitle(mg)

    }

    private fun getData(questionTable: MutableList<QuestionTable>): ArrayList<BarEntry>
    {
        var counter = 0
        val entries: ArrayList<BarEntry> = ArrayList()
        //val CMR = answer?.let { ComputeMezajs(it) }
        val CMR = MohasebehMezaj.Calculate(questionTable)
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