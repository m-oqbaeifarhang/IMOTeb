package com.example.imoteb

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
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

abstract class MainFragment : Fragment(), View.OnClickListener,
    NavigationView.OnNavigationItemSelectedListener
{
    var navController: NavController? = null
    private var myContext: FragmentActivity? = null
    lateinit var beforeTestmezajquestionfragment: Before_TestMezajQuestionFragment
    var bundle_mezaj_dam : Bundle ?=null
    var bundle_mezaj_safra : Bundle ?=null
    var bundle_mezaj_soda : Bundle ?=null
    var bundle_mezaj_balgham : Bundle ?=null

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
        requireActivity().onBackPressedDispatcher.addCallback(this) {
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

        btn_bishtar_bekhanid.setOnClickListener {
            if(more_information_content_main.visibility == View.GONE)
            {
                androidx.transition.TransitionManager.beginDelayedTransition(
                    cardView_content_main_layout,
                    androidx.transition.AutoTransition())
                more_information_content_main.visibility = View.VISIBLE
                btn_bishtar_bekhanid.setBackgroundResource(R.drawable.ic_arrow_up)
                motaleye_bishtar_content_main_layout.text = "بستن"
            } else
            {
                androidx.transition.TransitionManager.beginDelayedTransition(
                    cardView_content_main_layout,
                    androidx.transition.AutoTransition())
                more_information_content_main.visibility = View.GONE
                btn_bishtar_bekhanid.setBackgroundResource(R.drawable.ic_arrow_down)
                motaleye_bishtar_content_main_layout.text = "بیشتر"
            }
        }

        bundle_mezaj_dam = Bundle()
        bundle_mezaj_safra = Bundle()
        bundle_mezaj_soda = Bundle()
        bundle_mezaj_balgham = Bundle()

        val dam_title = requireActivity().getString(R.string.txt_dam_title) as String
        val dam_mezaj_tab = requireActivity().getString(R.string.txt_dam_mezaj_tab) as String
        val english_dam_title = requireActivity().getString(R.string.txt_dam_title_english) as String
        val dam_neshaneha = requireActivity().getString(R.string.txt_dam_neshaneha) as String
        val dam_kholgokhoo = requireActivity().getString(R.string.txt_dam_kholgokhoo) as String
        val dam_bimariha = requireActivity().getString(R.string.txt_dam_bimariha) as String

        val safra_title = requireActivity().getString(R.string.txt_safra_title) as String
        val safra_mezaj_tab = requireActivity().getString(R.string.txt_safra_mezaj_tab) as String
        val english_safra_title = requireActivity().getString(R.string.txt_safra_title_english) as String
        val safra_neshaneha = requireActivity().getString(R.string.txt_safra_neshaneha) as String
        val safra_kholgokhoo = requireActivity().getString(R.string.txt_safra_kholgokhoo) as String
        val safra_bimariha = requireActivity().getString(R.string.txt_safra_bimariha) as String

        val soda_title = requireActivity().getString(R.string.txt_soda_title) as String
        val soda_mezaj_tab = requireActivity().getString(R.string.txt_soda_mezaj_tab) as String
        val english_soda_title = requireActivity().getString(R.string.txt_soda_title_english) as String
        val soda_neshaneha = requireActivity().getString(R.string.txt_soda_neshaneha) as String
        val soda_kholgokhoo = requireActivity().getString(R.string.txt_soda_kholgokhoo) as String
        val soda_bimariha = requireActivity().getString(R.string.txt_soda_bimariha) as String

        val balgham_title = requireActivity().getString(R.string.txt_balgham_title) as String
        val balgham_mezaj_tab = requireActivity().getString(R.string.txt_balgham_mezaj_tab) as String
        val english_balgham_title = requireActivity().getString(R.string.txt_balgham_title_english) as String
        val balgham_neshaneha = requireActivity().getString(R.string.txt_balgham_neshaneha) as String
        val balgham_kholgokhoo = requireActivity().getString(R.string.txt_balgham_kholgokhoo) as String
        val balgham_bimariha = requireActivity().getString(R.string.txt_balgham_bimariha) as String


        bundle_mezaj_dam!!.putString("mezaj_title", dam_title)
        bundle_mezaj_dam!!.putString("english_mezaj_title", english_dam_title)
        bundle_mezaj_dam!!.putString("mezaj_tab", dam_mezaj_tab)
        bundle_mezaj_dam!!.putInt("cv_mezaj_logo", R.drawable.dam_cv_logo)
        bundle_mezaj_dam!!.putInt("mezaj_english_logo", R.drawable.dam_logo)
        bundle_mezaj_dam!!.putString("neshaneha",dam_neshaneha)
        bundle_mezaj_dam!!.putString("kolgokhoo",dam_kholgokhoo)
        bundle_mezaj_dam!!.putString("bimariha",dam_bimariha)

        bundle_mezaj_safra!!.putString("mezaj_title",safra_title)
        bundle_mezaj_safra!!.putString("english_mezaj_title", english_safra_title)
        bundle_mezaj_safra!!.putString("mezaj_tab", safra_mezaj_tab)
        bundle_mezaj_safra!!.putInt("cv_mezaj_logo", R.drawable.safra_cv_logo)
        bundle_mezaj_safra!!.putInt("mezaj_english_logo", R.drawable.safra_logo)
        bundle_mezaj_safra!!.putString("neshaneha",safra_neshaneha)
        bundle_mezaj_safra!!.putString("kolgokhoo",safra_kholgokhoo)
        bundle_mezaj_safra!!.putString("bimariha",safra_bimariha)

        bundle_mezaj_soda!!.putString("mezaj_title",soda_title)
        bundle_mezaj_soda!!.putString("english_mezaj_title", english_soda_title)
        bundle_mezaj_soda!!.putString("mezaj_tab", soda_mezaj_tab)
        bundle_mezaj_soda!!.putInt("cv_mezaj_logo", R.drawable.soda_cv_logo)
        bundle_mezaj_soda!!.putInt("mezaj_english_logo", R.drawable.soda_logo)
        bundle_mezaj_soda!!.putString("neshaneha",soda_neshaneha)
        bundle_mezaj_soda!!.putString("kolgokhoo",soda_kholgokhoo)
        bundle_mezaj_soda!!.putString("bimariha",soda_bimariha)

        bundle_mezaj_balgham!!.putString("mezaj_title",balgham_title)
        bundle_mezaj_balgham!!.putString("english_mezaj_title", english_balgham_title)
        bundle_mezaj_balgham!!.putString("mezaj_tab", balgham_mezaj_tab)
        bundle_mezaj_balgham!!.putInt("cv_mezaj_logo", R.drawable.balgham_cv_logo)
        bundle_mezaj_balgham!!.putInt("mezaj_english_logo", R.drawable.balgham_logo)
        bundle_mezaj_balgham!!.putString("neshaneha",balgham_neshaneha)
        bundle_mezaj_balgham!!.putString("kolgokhoo",balgham_kholgokhoo)
        bundle_mezaj_balgham!!.putString("bimariha",balgham_bimariha)

    }

    override fun onClick(v: View?)
    {
        when(v!!.id)
        {
            R.id.btn_start_TestMazaj -> navController!!.navigate(R.id.action_mainFragment_to_before_TestMezajQuestionFragment)
            R.id.rl_dam -> navController!!.navigate(R.id.action_mainFragment_to_mezajsDetails_Fragment,bundle_mezaj_dam)
            R.id.rl_safra -> navController!!.navigate(R.id.action_mainFragment_to_mezajsDetails_Fragment,bundle_mezaj_safra)
            R.id.rl_soda -> navController!!.navigate(R.id.action_mainFragment_to_mezajsDetails_Fragment,bundle_mezaj_soda)
            R.id.rl_balgham -> navController!!.navigate(R.id.action_mainFragment_to_mezajsDetails_Fragment,bundle_mezaj_balgham)
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
//        val fragManager = myContext!!.supportFragmentManager
        when(menuItem.itemId)
        {
            R.id.nav_test ->
            {
                beforeTestmezajquestionfragment = Before_TestMezajQuestionFragment()
                navController!!.navigate(R.id.action_mainFragment_to_before_TestMezajQuestionFragment)
            }
/*            R.id.nav_mezaj_records ->
            {
                beforeTestmezajquestionfragment = Before_TestMezajQuestionFragment()
                navController!!.navigate(R.id.action_mainFragment_to_mezajRecordsFragment)
            }*/
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
