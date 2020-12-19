package com.example.imoteb.MezajsTest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.imoteb.R
import kotlinx.android.synthetic.main.fragment_mezajs_details.*

class MezajsDetailsFragment : Fragment(),View.OnClickListener
{
    var navController: NavController? = null

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mezajs_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)

/*        if(activity is AppCompatActivity)
        {
            (activity as AppCompatActivity).setSupportActionBar(toolbar_fg_mezaj_detail)
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        }
        toolbar_fg_mezaj_detail.setNavigationOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }*/

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        iv_back.setOnClickListener(this)

        go_to_up.setOnClickListener{
            my_nested.fullScroll(NestedScrollView.FIND_VIEWS_WITH_CONTENT_DESCRIPTION)
//            my_nested.scrollTo(0, my_nested.maxScrollAmount)
//            my_nested.smoothScrollBy(0,10)
//            my_nested.scrollY
        }

        /*        get mezaj information*/
        mezaj_name.text = arguments?.getString("mezaj_title")
        tabe_mezaj.text = arguments?.getString("mezaj_tab")
        cv_mezaj_logo.setImageResource(arguments?.getInt("cv_mezaj_logo")!!)
        mezaj_english_logo.setImageResource(arguments?.getInt("mezaj_english_logo")!!)
        mezaj_english_name.text = arguments?.getString("english_mezaj_title")
//        val imgs = arguments?.getInt("cv_mezaj_logo")
        tv_mezaj_neshaneha.text = arguments?.getString("neshaneha")
        tv_mezaj_kholgokhoo.text = arguments?.getString("kolgokhoo")
        tv_mezaj_bimariha.text = arguments?.getString("bimariha")


    }

    override fun onClick(v: View?)
    {
        when(v!!.id)
        {
            R.id.iv_back -> navController!!.navigate(R.id.action_mezajsDetails_Fragment_to_mainFragment)
        }
    }

}