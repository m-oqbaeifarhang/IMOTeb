package com.example.imoteb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_start_TestMazaj.setOnClickListener {

         val intent = Intent(this,Test_Mazaj_Activity::class.java)
           startActivity(intent)
        }







        val drawerLayout = drawer
        btn_menu.setOnClickListener { drawerLayout.openDrawer(Gravity.RIGHT) }

    }
}
