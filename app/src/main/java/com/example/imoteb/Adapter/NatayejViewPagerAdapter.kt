package com.example.imoteb.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.imoteb.TosiyehayePezeshkiFragment
import com.example.imoteb.KhususiyatAkhlagiFragment

internal class NatayejViewPagerAdapter( fm: FragmentManager) : FragmentPagerAdapter(fm!!)
{
    override fun getItem(position: Int): Fragment
    {
        return when (position)
        {
            0 -> { TosiyehayePezeshkiFragment() }
            1 -> { KhususiyatAkhlagiFragment() }
            else -> { TosiyehayePezeshkiFragment() }
        }
    }

    override fun getCount(): Int
    {
        return 2
    }
}

//
//private val myContext: Context,