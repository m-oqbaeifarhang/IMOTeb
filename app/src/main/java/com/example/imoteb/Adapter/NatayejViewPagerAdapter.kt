package com.example.imoteb.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.imoteb.MezajsTest.TestMezajResultsTextFragment

internal class NatayejViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager)
{
    private val fragments: ArrayList<Fragment>
    private val titles: ArrayList<String>
    init
    {
        fragments = ArrayList<Fragment>()
        titles = ArrayList<String>()
    }

    override fun getItem(position: Int): Fragment
    {
         return TestMezajResultsTextFragment.newInstance(position)
    }

    override fun getCount(): Int
    {
        return fragments.size
    }

    fun addFragment(fragment: Fragment, title: String)
    {
        fragments.add(fragment)
        titles.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence?
    {
        return titles[position]
    }

}

