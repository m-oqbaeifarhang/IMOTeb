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


class MainActivity : AppCompatActivity(){

    lateinit var homeFragment: HomeFragment
    lateinit var pointFragment: PointFragment
    lateinit var shareFragment: ShareFragment
    lateinit var aboutFragment: AboutFragment
    lateinit var call_usFragment: Call_usFragment
    lateinit var testMezajfragment: Test_MezajFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//       navigation_view.setNavigationItemSelectedListener(this)
//
//

        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout,homeFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
    }


}
