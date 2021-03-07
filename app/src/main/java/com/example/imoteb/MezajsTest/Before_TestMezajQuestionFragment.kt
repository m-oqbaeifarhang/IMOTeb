package com.example.imoteb.MezajsTest

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.imoteb.MainActivity
import com.example.imoteb.R
import kotlinx.android.synthetic.main.fragment_before__test_mezaj_question.*

class Before_TestMezajQuestionFragment : Fragment(), View.OnClickListener
{
    var navController: NavController? = null
    var AgeFlag=false
    var GenderFlag = false
    var MaritalStatusFlag = false
    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        Model.MeghadDehiMotaghayerHa()
        val titleQuestions = resources.getStringArray(R.array.QuestionArrayy).toMutableList()
        Model.SetQuestionTitle(titleQuestions)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_before__test_mezaj_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        btn_marhaleye_baad.setOnClickListener(this)

/*        btn_bishtar_bekhanid.setOnClickListener {
            if(more_information_view.visibility == View.GONE)
            {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                more_information_view.visibility = View.VISIBLE
                btn_bishtar_bekhanid.setBackgroundResource(R.drawable.ic_arrow_up)
                motaleye_bishtar.text = "بستن"
            } else
            {
                TransitionManager.beginDelayedTransition(cardView, AutoTransition())
                more_information_view.visibility = View.GONE
                btn_bishtar_bekhanid.setBackgroundResource(R.drawable.ic_arrow_down)
                motaleye_bishtar.text = "مطالعه بیشتر"
            }
        }*/

    }

    //    @RequiresApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(v: View?)
    {
        when(v!!.id)
        {
            R.id.btn_marhaleye_baad ->
            {
                var numberOfPicher =
                    ("13" + snp_vertical_dahgan.value.toString() + snp_vertical_yekan.value.toString()).toInt();
                Model.Age = CalculationOfAge.Calculate(numberOfPicher)
                when
                {
                    numberOfPicher==1300->
                    {
                        Toast.makeText(requireContext(),
                            "تاریخ تولد نمی تواند 1300 باشد.",
                            Toast.LENGTH_SHORT).show()
                    }
                    Model.Age<15->
                    {
                        Toast.makeText(requireContext(),
                            "این تست برای افراد زیر 15 سال صادق نمی باشد.",
                            Toast.LENGTH_SHORT).show()
                    }
                    MaritalStatusFlag == false ->
                    {
                        Toast.makeText(requireContext(),
                            "لطفا وضعیت تاهل خود را انتخاب فرمایید.",
                            Toast.LENGTH_SHORT).show()
                    }
                    GenderFlag == false ->
                    {
                        Toast.makeText(requireContext(),
                            "لطفا جنسیت خود را انتخاب فرمایید.",
                            Toast.LENGTH_SHORT).show()
                    }
                    else ->
                    {
                        navController!!.navigate(R.id.action_before_TestMezajQuestionFragment_to_mezaj_QueriesFragment)
                    }
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        rg_gender.setOnCheckedChangeListener { group, _ ->
            val rdb = rg_gender.findViewById<RadioButton>(group.checkedRadioButtonId)
            Model.Gender = when(rdb.contentDescription.toString())
            {
                R.string.txt_male.toString() -> GenderEnum.Male
                else -> GenderEnum.Female
            }
            GenderFlag = true
        }
        rg_vaziyat_tahhol.setOnCheckedChangeListener { group, _ ->
            val rdb = rg_vaziyat_tahhol.findViewById<RadioButton>(group.checkedRadioButtonId)
            Model.MaritalStatus = when(rdb.contentDescription.toString())
            {
                R.string.married.toString() -> MaritalStatusEnum.Married
                else -> MaritalStatusEnum.Single
            }
            MaritalStatusFlag = true
        }

        if(activity is AppCompatActivity)
        {
            (activity as AppCompatActivity).setSupportActionBar(toolbar_before_test_mezaj_question)
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        }
        toolbar_before_test_mezaj_question.setNavigationOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
    }
}

