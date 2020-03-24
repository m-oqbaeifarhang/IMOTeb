package com.example.imoteb


import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.appcompat.view.menu.MenuView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_home.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener
{
    lateinit var homeFragment: HomeFragment
    lateinit var pointFragment: PointFragment
    lateinit var shareFragment: ShareFragment
    lateinit var aboutFragment: AboutFragment
    lateinit var call_usFragment: Call_usFragment
    lateinit var testMezajfragment: Test_MezajFragment

    private var myContext: FragmentActivity? = null
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onAttach(context: Context)
    {
        super.onAttach(context)

        myContext = context as FragmentActivity

    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        btn_start_TestMazaj.setOnClickListener {
            val fragment: Fragment = Test_MezajFragment()
            val fragmentManager: FragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }

        val drawerLayout = drawer
        btn_menu.setOnClickListener {
            drawerLayout.openDrawer(Gravity.RIGHT)
        }
        navigation_view.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener {
            onNavigationItemSelected(it)
        })
    }

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment

        val result = inflater.inflate(R.layout.fragment_home, container, false)
        return result
    }


    companion object
    {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = HomeFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean
    {
        val fragManager = myContext!!.supportFragmentManager
        when(menuItem.itemId)
        {
            R.id.nav_home ->
            {
                homeFragment = HomeFragment()
                fragManager.beginTransaction().replace(R.id.frame_layout, homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_rate ->
            {
                pointFragment = PointFragment()
                fragManager.beginTransaction().replace(R.id.frame_layout, pointFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_share ->
            {
                shareFragment = ShareFragment()
                fragManager.beginTransaction().replace(R.id.frame_layout, shareFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_about ->
            {
                aboutFragment = AboutFragment()
                fragManager.beginTransaction().replace(R.id.frame_layout, aboutFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.call_us ->
            {
                call_usFragment = Call_usFragment()
                fragManager.beginTransaction().replace(R.id.frame_layout, call_usFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_test ->
            {
                testMezajfragment = Test_MezajFragment()
                fragManager.beginTransaction().replace(R.id.frame_layout, testMezajfragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            else ->
            {
                homeFragment = HomeFragment()
                fragManager.beginTransaction().replace(R.id.frame_layout, homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
        }

        return true
    }
}
