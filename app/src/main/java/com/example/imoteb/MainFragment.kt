package com.example.imoteb

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.example.imoteb.MezajsTest.Before_TestMezajQuestionFragment
import com.example.imoteb.MezajsTest.MezajDetailFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_before__test_mezaj_question.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() , View.OnClickListener ,NavigationView.OnNavigationItemSelectedListener
{
    var navController : NavController? = null
    private var myContext: FragmentActivity? = null
    lateinit var beforeTestmezajquestionfragment: Before_TestMezajQuestionFragment
    var aaaa = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)

    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            Toast.makeText(requireContext(),"exit", Toast.LENGTH_SHORT).show()
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
        if(activity is AppCompatActivity){
            (activity as AppCompatActivity).setSupportActionBar(toolbar)
            initDrawer()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btn_start_TestMazaj.setOnClickListener(this)
        click.setOnClickListener(this)

        btn_bishtar_bekhanid_content_main_layout.setOnClickListener{
            if(more_information_content_main.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(cardView_content_main_layout , AutoTransition())
                more_information_content_main.visibility = View.VISIBLE
                btn_bishtar_bekhanid_content_main_layout.setBackgroundResource(R.drawable.ic_arrow_up)
                motaleye_bishtar_content_main_layout.text = "بستن"
            } else {
                TransitionManager.beginDelayedTransition(cardView_content_main_layout , AutoTransition())
                more_information_content_main.visibility = View.GONE
                btn_bishtar_bekhanid_content_main_layout.setBackgroundResource(R.drawable.ic_arrow_down)
                motaleye_bishtar_content_main_layout.text = "مطالعه بیشتر"
            }
        }

    }

    override fun onClick(v: View?)
    {
        when(v!!.id)
        {
            R.id.btn_start_TestMazaj -> navController!!.navigate(R.id.action_mainFragment_to_before_TestMezajQuestionFragment)
            R.id.click -> {

                val pairs: Array<Pair<View, String>?> = arrayOfNulls(1)
                pairs[0] = Pair<View, String>(iv_shared_element_start, "imageTransition")
                val options = ActivityOptions.makeSceneTransitionAnimation(context as Activity?, *pairs)
//                navController!!.navigate(R.id.action_mainFragment_to_mezajDetailFragment,options.toBundle())

            }
        }
    }

    private fun initDrawer(){
        val toggle = ActionBarDrawerToggle(Activity(),drawer,toolbar,R.string.nav_open,R.string.nav_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        navigation_view.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener {
            onNavigationItemSelected(it)
        })
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean
    {
        val fragManager = myContext!!.supportFragmentManager
        when(menuItem.itemId)
        {
            R.id.nav_test ->
            {
                beforeTestmezajquestionfragment =
                    Before_TestMezajQuestionFragment()
                navController!!.navigate(R.id.action_mainFragment_to_before_TestMezajQuestionFragment)
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

}
