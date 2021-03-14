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
        aciv_back_fragment_mezajs_details.setOnClickListener(this)

        aciv_go_to_up.setOnClickListener{
            my_nested.fullScroll(NestedScrollView.FIND_VIEWS_WITH_CONTENT_DESCRIPTION)
//            my_nested.scrollTo(0, my_nested.maxScrollAmount)
//            my_nested.smoothScrollBy(0,10)
//            my_nested.scrollY
        }

        /*        get mezaj information*/
        actv_title_mezaj.text = arguments?.getString("mezaj_title")
        actv_tabe_mezaj.text = arguments?.getString("mezaj_tab")
        aciv_mezaj_logo.setImageResource(arguments?.getInt("cv_mezaj_logo")!!)
        mezaj_english_logo.setImageResource(arguments?.getInt("mezaj_english_logo")!!)
        mezaj_english_name.text = arguments?.getString("english_mezaj_title")
//        val imgs = arguments?.getInt("cv_mezaj_logo")
        actv_desc_naeshanehaye_mezaj.text = arguments?.getString("neshaneha")
        actv_desc_kholgokhuye_mezaj.text = arguments?.getString("kolgokhoo")
        actv_desc_bimarihaye_mezaj.text = arguments?.getString("bimariha")
        actv_desc_darman_mezaj.text = arguments?.getString("darman")


    }

    override fun onClick(v: View?)
    {
        when(v!!.id)
        {
            R.id.aciv_back_fragment_mezajs_details -> navController!!.navigate(R.id.action_mezajsDetails_Fragment_to_mainFragment)
        }
    }

}