package com.example.imoteb.MezajsTest

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.imoteb.MainActivity
import com.example.imoteb.R
import kotlinx.android.synthetic.main.fragment_mezajs_details.*

class MezajsDetails_Fragment : Fragment()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

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



        if(activity is AppCompatActivity)
        {
            (activity as AppCompatActivity).setSupportActionBar(toolbar_fg_mezaj_detail)
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        }
        toolbar_fg_mezaj_detail.setNavigationOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

        if(arguments != null)
        {
            // The getPrivacyPolicyLink() method will be created automatically.
//            val url: String = mezajURL.fromBundle(arguments).mezaj_name()
        }

        val title = (requireArguments().get("safra"))as String
        mezaj_name.text = title
//        descerption.setText()
    }

}