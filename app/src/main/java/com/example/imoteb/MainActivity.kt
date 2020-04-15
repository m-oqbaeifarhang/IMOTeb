package com.example.imoteb

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentTransaction
import com.example.imoteb.R.id.*
import com.example.imoteb.R.id.drawer
import com.example.imoteb.R.id.toolbar
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_home.*


class MainActivity : AppCompatActivity(){

    lateinit var homeFragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
//        {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
//        }


        if(android.os.Build.VERSION.SDK_INT >= 21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        }

        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout,homeFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

    }

}
