package com.example.imoteb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_mezaj_queries.*


class Mezaj_QueriesFragment : Fragment(), View.OnClickListener
{
    var navController: NavController? = null

    //lateinit var titleQuestions: MutableList<String>
    lateinit var questionAapter: QuestionsAdapter

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mezaj_queries, container, false)
    }

    @SuppressLint("WrongConstant")
    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        /*set Toolbar*/
        if(activity is AppCompatActivity)
        {
            (activity as AppCompatActivity).setSupportActionBar(toolbar_test_mezajFragment)
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        }
        toolbar_test_mezajFragment.setNavigationOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

        rv_questions.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        rv_questions.setItemViewCacheSize(32)
        val titleQuestionList =
            ConfigurationQuestionsAndAnswers.ConfigurationQuestionByAge(Model.Age)
        questionAapter = QuestionsAdapter(context)


       var  mLinearLayoutManager =  LinearLayoutManager(requireContext())
        rv_questions.setLayoutManager(mLinearLayoutManager)


        rv_questions.adapter = questionAapter
        mLinearLayoutManager.scrollToPositionWithOffset(25,0)
        mLinearLayoutManager.scrollToPosition(25)
        rv_questions.scrollToPosition(25)
        rv_questions.smoothScrollToPosition(25)
        rv_questions.layoutManager!!.smoothScrollToPosition(rv_questions,RecyclerView.State(),25)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btn_moshahedeh_natije.setOnClickListener(this)
    }

    override fun onClick(v: View?)
    {
        if(v!!.id == R.id.btn_moshahedeh_natije)
        {
            if(Model.questionTableList.any { a -> a.Choosed == false })
            {
                if(Model.questionTableList.any { a -> a.Choosed })
                {
                    Toast.makeText(context,
                        "لطفا به سوالات قرمز شده پاسخ دهید.",
                        Toast.LENGTH_SHORT).show()

                } else
                {
                    Toast.makeText(context, "لطفا به سوالات پاسخ دهید.", Toast.LENGTH_SHORT).show()
                }
                rv_questions.adapter = questionAapter


            } else
            {
                navController!!.navigate(R.id.action_mezaj_QueriesFragment_to_test_mezaj_resultFragment)
            }
        }
    }

}
