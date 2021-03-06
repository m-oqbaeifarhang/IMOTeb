package com.example.imoteb.MezajsTest

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.imoteb.Adapter.NatayejViewPagerAdapter
import com.example.imoteb.IntentShare
import com.example.imoteb.MainActivity
import com.example.imoteb.MezajsTest.Mohasebeh_GhalabeHa.Companion.convertMezajGhalebToPersianText
import com.example.imoteb.R
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_test_mezaj_result.*
import java.util.*
import kotlin.collections.ArrayList


class Test_mezaj_resultFragment() : Fragment()
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

        /*     set seekbar     */
/*        nestedScrollView_fragment_test_mezaj_result.setOnScrollChangeListener { v: NestedScrollView?, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int ->
            val totalScrollLenght =
                nestedScrollView_fragment_test_mezaj_result.getChildAt(0).height - nestedScrollView_fragment_test_mezaj_result.height
            progressBar_fragment_test_mezaj_result.apply {
                max = totalScrollLenght
                progress = scrollY
            }
        }*/

//        val rvResultShow : CardView = requireView().findViewById(R.id.cl_result_show)
//        val cvChartShow : CardView = requireView().findViewById(R.id.cv_chart_show)
//        val acivCloseChart : AppCompatImageView = requireView().findViewById(R.id.aciv_close_chart)

//        cvChartShow.setOnClickListener {
//            val animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.translate_anim)
//            rvResultShow.visibility = View.VISIBLE
//            rvResultShow.startAnimation(animation)
//        }
//
//        acivCloseChart.setOnClickListener {
//            val animation = AnimationUtils.loadAnimation(requireActivity(), R.anim.reverse_translate_anim)
//            rvResultShow.visibility = View.GONE
//            rvResultShow.startAnimation(animation)
//        }

        val natayejTablayout = requireView().findViewById(R.id.natayejTablayout) as TabLayout
        val natayejViewPager = requireView().findViewById(R.id.natayejViewPager) as ViewPager
        val natayejViewPagerAdapter = NatayejViewPagerAdapter(requireActivity().supportFragmentManager)
        natayejViewPagerAdapter.addFragment(TestMezajResultsTextFragment(), "توصیه های درمانی")
        natayejViewPagerAdapter.addFragment(TestMezajResultsTextFragment(), "خصوصیات اخلاقی")
        natayejViewPagerAdapter.addFragment(TestMezajResultsTextFragment(), "عوارض غلبه")
        natayejViewPagerAdapter.addFragment(TestMezajResultsTextFragment(), "عوامل غلبه")
        natayejTablayout.tabGravity = TabLayout.GRAVITY_FILL
        natayejViewPager.adapter = natayejViewPagerAdapter
        natayejTablayout.setupWithViewPager(natayejViewPager)
    }

    @SuppressLint("SetTextI18n")
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
        val barDataSet: BarDataSet = BarDataSet(getData(Model.questionTableList), "")
        chart1.description.isEnabled = false
        barDataSet.barBorderWidth = 6f
        barDataSet.barBorderColor = Color.rgb(140, 214, 237)

        //barDataSet.colors = ColorTemplate.COLORFUL_COLORS.toMutableList()
        barDataSet.setColors(Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE)
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

        //        chart1.setBackgroundResource(R.drawable.dam_cv_logo)
        // val CMR = MohasebehMezaj.Calculate(Model.questionTableList)
        chart1.animateXY(2000, 2000);
        chart1.invalidate()
        chart1.setScaleEnabled(false)
        val mg = Mohasebeh_GhalabeHa.Mohasebe(Model.Dam, Model.Safra, Model.Soda, Model.Balgham)
        val mezajGhalabeResult = "نتیجه مزاج شناسی : " + convertMezajGhalebToPersianText(mg)
        actv_mezaj_result_title.text = mezajGhalabeResult
        var date: Date

        btn_ask_question.setOnClickListener {
            Handler().post(Runnable {
                val intentShare = IntentShare.sharePhotoWithText(context = requireContext(),
                    bitmap = chart1.chartBitmap,
                    activity = requireActivity(),
                    text = mezajGhalabeResult)
                startActivity(Intent.createChooser(intentShare, "Choose an app"))
            })
        }
    }
    private fun getData(questionTable: MutableList<QuestionTable>): ArrayList<BarEntry>
    {
        var counter = 0
        val entries: ArrayList<BarEntry> = ArrayList()
        entries.add(BarEntry(0f, Model.Balgham))
        entries.add(BarEntry(1f, Model.Soda))
        entries.add(BarEntry(2f, Model.Safra))
        entries.add(BarEntry(3f, Model.Dam))
        return entries
    }

}


