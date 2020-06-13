package com.example.imoteb.Adapter

import android.content.Context
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.imoteb.TosiyehayePezeshkiFragment
import com.example.imoteb.KhususiyatAkhlagiFragment

internal class NatayejViewPagerAdapter( fm: FragmentManager) : FragmentPagerAdapter(fm)
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
        return 3
    }

//    override fun getPageTitle(position: Int): CharSequence?
//    {
//        when(position)
//        {
//            0 -> return "aaaaaa"
//            1 -> return "bbbbbb"
//        }
//        return null
//    }



}
