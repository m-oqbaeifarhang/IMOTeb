package com.example.imoteb

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.imoteb.MezajsTest.Before_TestMezajQuestionFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), View.OnClickListener,
    NavigationView.OnNavigationItemSelectedListener
{
    var navController: NavController? = null
    private var myContext: FragmentActivity? = null
    lateinit var beforeTestmezajquestionfragment: Before_TestMezajQuestionFragment


    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            Toast.makeText(requireContext(), "exit", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onAttach(context: Context)
    {
        super.onAttach(context)
        myContext = context as FragmentActivity
    }

    @SuppressLint("WrongConstant")
    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        //        if(activity is AppCompatActivity){
        //            (activity as AppCompatActivity).setSupportActionBar(main_toolbar)
        //            initDrawer()
        //        }
        navigationDrawer()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btn_start_TestMazaj.setOnClickListener(this)
        rl_dam.setOnClickListener(this)
        rl_safra.setOnClickListener(this)
        rl_soda.setOnClickListener(this)
        rl_balgham.setOnClickListener(this)

        btn_bishtar_bekhanid_content_main_layout.setOnClickListener {
            if(more_information_content_main.visibility == View.GONE)
            {
                androidx.transition.TransitionManager.beginDelayedTransition(
                    cardView_content_main_layout,
                    androidx.transition.AutoTransition())
                more_information_content_main.visibility = View.VISIBLE
                btn_bishtar_bekhanid_content_main_layout.setBackgroundResource(R.drawable.ic_arrow_up)
                motaleye_bishtar_content_main_layout.text = "بستن"
            } else
            {
                androidx.transition.TransitionManager.beginDelayedTransition(
                    cardView_content_main_layout,
                    androidx.transition.AutoTransition())
                more_information_content_main.visibility = View.GONE
                btn_bishtar_bekhanid_content_main_layout.setBackgroundResource(R.drawable.ic_arrow_down)
                motaleye_bishtar_content_main_layout.text = "مطالعه بیشتر"
            }
        }
    }

    override fun onClick(v: View?)
    {
        val bundel = Bundle()
        bundel.putString("dam", "dam description")
        when(v!!.id)
        {
            R.id.rl_dam -> bundel.putString("dam", "dam description")
            R.id.rl_safra -> bundel.putString("safra", "safra description")
            R.id.rl_soda -> bundel.putString("soda", "soda description")
            R.id.rl_balgham -> bundel.putString("balgham", "balgham description")

        }
        when(v.id)
        {
            R.id.btn_start_TestMazaj -> navController!!.navigate(R.id.action_mainFragment_to_before_TestMezajQuestionFragment)
            R.id.rl_dam, R.id.rl_safra, R.id.rl_soda, R.id.rl_balgham -> navController!!.navigate(R.id.action_mainFragment_to_mezajsDetails_Fragment,bundel)
        }
    }

    /*    private fun initDrawer(){
            val toggle = ActionBarDrawerToggle(Activity(),drawer,main_toolbar,R.string.nav_open,R.string.nav_close)
            drawer.addDrawerListener(toggle)
            toggle.syncState()
            navigation_view.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener {
                onNavigationItemSelected(it)
            })
        }*/

    private fun navigationDrawer()
    {
        navigation_view.bringToFront()
        navigation_view.setNavigationItemSelectedListener(this)
        navigation_view.setCheckedItem(R.id.nav_signup)

        btn_menu.setOnClickListener {
            if(drawer_layout.isDrawerVisible(GravityCompat.START))
            {
                drawer_layout.closeDrawer(GravityCompat.START)
            } else drawer_layout.openDrawer(GravityCompat.START)
        }
        animateNavigationDrawer()
    }

    private fun animateNavigationDrawer()
    {
        val endScale = 0.7f
        //        drawer_layout.setScrimColor(resources.getColor(android.R.color.darker_gray))
        drawer_layout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener()
        {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float)
            {
                val diffScaledOffset = slideOffset * (1 - endScale)
                val offsetScale = 1 - diffScaledOffset
                contentView.scaleX = offsetScale
                contentView.scaleY = offsetScale
                val xOffset = drawerView.width * slideOffset
                val xOffsetDiff = contentView.width * diffScaledOffset / 2
                val xTranslation = xOffsetDiff - xOffset
                contentView.translationX = xTranslation
            }
        })
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean
    {
        val fragManager = myContext!!.supportFragmentManager
        when(menuItem.itemId)
        {
            R.id.nav_test ->
            {
                beforeTestmezajquestionfragment = Before_TestMezajQuestionFragment()
                navController!!.navigate(R.id.action_mainFragment_to_before_TestMezajQuestionFragment)
            }
            R.id.nav_mezaj_records ->
            {
                beforeTestmezajquestionfragment = Before_TestMezajQuestionFragment()
                navController!!.navigate(R.id.action_mainFragment_to_mezajRecordsFragment)
            }
            R.id.nav_rate ->
            {
                Toast.makeText(requireContext(), "rate clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_share ->
            {
                Toast.makeText(requireContext(), "share clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_call_us ->
            {
                Toast.makeText(requireContext(), "nav_call_us clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_about ->
            {
                Toast.makeText(requireContext(), "nav_about clicked", Toast.LENGTH_SHORT).show()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
