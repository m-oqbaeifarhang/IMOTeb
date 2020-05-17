package com.example.imoteb

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_before__test_mezaj_question.*
import kotlinx.android.synthetic.main.questions_model.*

class Before_TestMezajQuestionFragment : Fragment(), View.OnClickListener
{
    var navController: NavController? = null

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_before__test_mezaj_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btn_marhaleye_baad.setOnClickListener(this)
    }

    override fun onClick(v: View?)
    {
        when(v!!.id)
        {
            R.id.btn_marhaleye_baad ->
            {
                if(txt_GetAge.length() == 0)
                {
                    val toast = Toast.makeText(requireContext(), R.string.sen_input, Toast.LENGTH_LONG)
                    val view: View = toast.view
                    //                    view.findViewById(android.R.id.message).setTextColor(Color.YELLOW)
                    view.setBackgroundResource(R.color.blue_dark)
                    toast.show()
                } else
                {
                    Model.Age = txt_GetAge.text.toString().toInt()
                    //در این قسمت model.Answer خالی میشود.
                    var counter = 0
                    //            Model.Answers.forEach {
                    //                Model.Answers[counter] = -1
                    //                counter++
                    //            }
                    navController!!.navigate(R.id.action_before_TestMezajQuestionFragment_to_mezaj_QueriesFragment)
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

        rg_jensiyyat.setOnCheckedChangeListener { group, _ ->
            val rdb = rg_jensiyyat.findViewById<RadioButton>(group.checkedRadioButtonId)
            Model.Sex = rg_jensiyyat.indexOfChild(rdb).toString().toBoolean()
        }

        rg_vaziyat_tahhol.setOnCheckedChangeListener { group, _ ->
            val rdb = rg_vaziyat_tahhol.findViewById<RadioButton>(group.checkedRadioButtonId)
            Model.Tahol = rg_vaziyat_tahhol.indexOfChild(rdb).toString().toBoolean()
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
