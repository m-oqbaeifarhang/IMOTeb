package com.example.imoteb


import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Pair
import android.view.*
import android.widget.Toast
import androidx.activity.addCallback
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import bikar.AboutFragment
import bikar.Call_usFragment
import bikar.PointFragment
import bikar.ShareFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_main.*
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
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            Toast.makeText(requireContext(),"exit",Toast.LENGTH_SHORT).show()
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
            val fragment: Fragment = Base_questionFragment()
/*            sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)*/
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left
                ,R.anim.enter_left_to_right,R.anim.exit_left_to_right).replace(R.id.frame_layout, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        /*set Toolbar*/
        if(activity is AppCompatActivity){
            (activity as AppCompatActivity).setSupportActionBar(toolbar)
/*            (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.my_title_string)*/
            initDrawer()
        }
//        card_dam.setOnClickListener {
//            val pairs: Array<Pair<View, String>?> = arrayOfNulls(2)
//            pairs[0] = Pair<View, String>(img_dam, "imageTransition")
//            pairs[1] = Pair<View, String>(title_dam, "nameTransition")
//            val fragment1: Fragment = Mezaj_damFragment()
//            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
//            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
//                .addSharedElement(img_dam,img_dam.transitionName)
//                .replace(R.id.frame_layout, fragment1)
//                .addToBackStack(null)
//                fragmentTransaction.commit()
//        }
/*        SupportFragmentManager().beginTransaction().addSharedElement(sharedElement, transitionName)
            .replace(R.id.container, newFragment)
            .addToBackStack(null)
            .commit()*/
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
            R.id.nav_signup ->
            {
                homeFragment = HomeFragment()
                fragManager.beginTransaction().setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left
                    ,R.anim.enter_left_to_right,R.anim.exit_left_to_right).replace(R.id.frame_layout, homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_rate ->
            {
                pointFragment = PointFragment()
                fragManager.beginTransaction().setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left
                    ,R.anim.enter_left_to_right,R.anim.exit_left_to_right).replace(R.id.frame_layout, pointFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_share ->
            {
                shareFragment = ShareFragment()
                fragManager.beginTransaction().setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left
                    ,R.anim.enter_left_to_right,R.anim.exit_left_to_right).replace(R.id.frame_layout, shareFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_about ->
            {
                aboutFragment = AboutFragment()
                fragManager.beginTransaction().setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left
                    ,R.anim.enter_left_to_right,R.anim.exit_left_to_right).replace(R.id.frame_layout, aboutFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.call_us ->
            {
                call_usFragment = Call_usFragment()
                fragManager.beginTransaction().setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left
                    ,R.anim.enter_left_to_right,R.anim.exit_left_to_right).replace(R.id.frame_layout, call_usFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            R.id.nav_test ->
            {
                testMezajfragment = Test_MezajFragment()
                fragManager.beginTransaction().setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left
                    ,R.anim.enter_left_to_right,R.anim.exit_left_to_right).replace(R.id.frame_layout, testMezajfragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
            else ->
            {
                homeFragment = HomeFragment()
                fragManager.beginTransaction().setCustomAnimations(R.anim.enter_right_to_left,R.anim.exit_right_to_left
                    ,R.anim.enter_left_to_right,R.anim.exit_left_to_right).replace(R.id.frame_layout, homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}