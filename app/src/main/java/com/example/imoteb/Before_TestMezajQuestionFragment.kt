package com.example.imoteb

import android.content.Intent
import android.os.Bundle
import android.view.Display
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_base_question.*
import kotlinx.android.synthetic.main.fragment_test_mezaj.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Base_questionFragment : Fragment()
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

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            startActivity(Intent(requireContext(), MainActivity::class.java))
            //            val fragment: Fragment = HomeFragment()
            //            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            //            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            //            fragmentTransaction.setCustomAnimations(R.anim.enter_left_to_right,R.anim.exit_left_to_right
            //                ,R.anim.enter_right_to_left,R.anim.exit_right_to_left).replace(R.id.frame_layout, fragment)
            //            fragmentTransaction.addToBackStack(null)
            //            fragmentTransaction.commit()
        }

    }

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base_question, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        btn_next.setOnClickListener {
            Model.Age = txt_GetAge.text.toString().toInt()
            //برخی سوالات برای گروه سنی خواصی است در این قسمت تعداد سوالات مشخص میشود
            if(Model.Age < 35)
            {
                Model.DamCount += 1
                Model.SafraCount += 1
            } else if(Model.Age > 55)
            {
                Model.BalghamCount += 1
            }
            //در این قسمت model.Answer خالی میشود.
            var counter = 0
            Model.Answers.forEach {
                Model.Answers[counter] = -1
                counter++
            }
            val fragment: Fragment = Test_MezajFragment()
            /*            sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)*/
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left,
                R.anim.exit_right_to_left,
                R.anim.enter_left_to_right,
                R.anim.exit_left_to_right).replace(R.id.frame_layout, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        /*set Toolbar*/
        if(activity is AppCompatActivity)
        {
            (activity as AppCompatActivity).setSupportActionBar(toolbar_fg_base_question)
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
            //            (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.my_title_string)
        }
        toolbar_fg_base_question.setNavigationOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
    }

    companion object
    {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = Base_questionFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }
}
