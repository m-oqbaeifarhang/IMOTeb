package com.example.imoteb

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_test_mezaj.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Test_MezajFragment : Fragment()
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
//        btn_back.setOnClickListener {
//            val intent = Intent(btn_start_TestMazaj.context, btn_start_TestMazaj::class.java)
//            startActivity(intent)
//        }




    }

    @SuppressLint("WrongConstant")
    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        val titleQuestions = resources.getStringArray(R.array.QuestionArrayy)
        rv_questions.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        rv_questions.setItemViewCacheSize(titleQuestions.size)
        var model = Model(titleQuestions)
        model.titleQuestionsList = titleQuestions
        val questionAapter = QuestionsAdapter(context, model)
        rv_questions.adapter = questionAapter

        btn_result.setOnClickListener {
            //val list = mutableListOf<Int>()
            var counter = 0
            if(model.Answers.contains(-1))
            {

                (model.Answers).forEach {
                    if(it == -1)
                    {
                        val text = model.titleQuestionsList[counter].replace("* ", "")
                        model.titleQuestionsList[counter] = "* " + text
                        rv_questions.adapter = questionAapter
                    }
                    counter++
                }

            } else
            {

                btn_result.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putIntArray("model",model.Answers)
                    val fragment: Fragment = Test_mezaj_resultFragment()
                    fragment.arguments=bundle
                    val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
                    val fragmentTransaction: FragmentTransaction =
                        fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.frame_layout, fragment)
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
               }
            }

            btn_back.setOnClickListener {
                val fragment: Fragment = HomeFragment()
                val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.frame_layout, fragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()

            }

        }
    }

    @SuppressLint("WrongConstant")
    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_test_mezaj, container, false)


    }


    companion object
    {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = Test_MezajFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}
