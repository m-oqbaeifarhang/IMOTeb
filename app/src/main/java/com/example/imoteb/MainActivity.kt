package com.example.imoteb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.fragment.app.FragmentTransaction
import com.example.imoteb.R.id.*
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    lateinit var homeFragment: HomeFragment
    lateinit var pointFragment: PointFragment
    lateinit var shareFragment: ShareFragment
    lateinit var aboutFragment: AboutFragment
    lateinit var call_usFragment: Call_usFragment
    lateinit var testMezajfragment: Test_MezajFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation_view.setNavigationItemSelectedListener(this)

        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(frame_layout,homeFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean
    {
        when(menuItem.itemId){
            nav_home ->{
                homeFragment = HomeFragment()
                supportFragmentManager.beginTransaction()
                    .replace(frame_layout,homeFragment)
                    .setTransition(FragmentTransaction
                        .TRANSIT_FRAGMENT_OPEN).commit()
            }
            nav_rate ->{
                pointFragment = PointFragment()
                supportFragmentManager.beginTransaction()
                    .replace(frame_layout,pointFragment)
                    .setTransition(FragmentTransaction
                        .TRANSIT_FRAGMENT_OPEN).commit()
            }
            nav_share ->{
                shareFragment = ShareFragment()
                supportFragmentManager.beginTransaction()
                    .replace(frame_layout,shareFragment)
                    .setTransition(FragmentTransaction
                        .TRANSIT_FRAGMENT_OPEN).commit()
            }
            nav_about ->{
                aboutFragment = AboutFragment()
                supportFragmentManager.beginTransaction()
                    .replace(frame_layout,aboutFragment)
                    .setTransition(FragmentTransaction
                        .TRANSIT_FRAGMENT_OPEN).commit()
            }
            call_us ->{
                call_usFragment = Call_usFragment()
                supportFragmentManager.beginTransaction()
                    .replace(frame_layout,call_usFragment)
                    .setTransition(FragmentTransaction
                        .TRANSIT_FRAGMENT_OPEN).commit()
            }
            nav_test ->{
                testMezajfragment = Test_MezajFragment()
                supportFragmentManager.beginTransaction()
                    .replace(frame_layout,testMezajfragment)
                    .setTransition(FragmentTransaction
                        .TRANSIT_FRAGMENT_OPEN).commit()
            }
            else ->{
                homeFragment = HomeFragment()
                supportFragmentManager.beginTransaction()
                    .replace(frame_layout,homeFragment)
                    .setTransition(FragmentTransaction
                        .TRANSIT_FRAGMENT_OPEN).commit()
            }
        }

        return true
    }
}
