package com.example.imoteb

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.addCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imoteb.Adapter.NatayejViewPagerAdapter
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_damavi.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() , View.OnClickListener ,NavigationView.OnNavigationItemSelectedListener,MezajAdapter.mezajItemClickListener
{
    var navController : NavController? = null
    private var myContext: FragmentActivity? = null
    lateinit var beforeTestmezajquestionfragment: Before_TestMezajQuestionFragment
    var mezaj_model: ArrayList<Mezaj_Model>? = null
    var foods_model: ArrayList<Foods_Model>? = null
    var mezajAdapter: MezajAdapter? = null
    var foodAdapter: FoodsAdapter? = null

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
        /*set Toolbar*/
        if(activity is AppCompatActivity){
            (activity as AppCompatActivity).setSupportActionBar(toolbar)
/*            (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.my_title_string)*/
            initDrawer()
        }

        // ست کردن و نمایش ریسایکلر ویو مزاج
        mezaj_model = ArrayList()
        mezaj_model?.add(Mezaj_Model("مزاج دموی","گرم و تر",R.drawable.ic_spring))
        mezaj_model?.add(Mezaj_Model("مزاج صفراوی","گرم و خشک",R.drawable.ic_summer))
        mezaj_model?.add(Mezaj_Model("مزاج سوداوی","سرد و خشک",R.drawable.ic_autumn))
        mezaj_model?.add(Mezaj_Model("مزاج بلغمی","سرد و تر",R.drawable.ic_snow))
        mezaj_model?.add(Mezaj_Model("مزاج خون","گرم و تر",R.drawable.ic_spring))
        mezaj_model?.add(Mezaj_Model("مزاج ریح","سرد و تر",R.drawable.ic_summer))
        rv_mezaj.layoutManager = LinearLayoutManager(context,LinearLayout.HORIZONTAL,false)
        mezajAdapter = MezajAdapter(mezaj_model!!,this)
        rv_mezaj.adapter = mezajAdapter

        //ست کردن و نمایش ریسایکلر ویوی غذا
        foods_model = ArrayList()
        foods_model?.add(Foods_Model("بارساخ",R.drawable.food_img_a))
        foods_model?.add(Foods_Model("قارین",R.drawable.food_img_b))
        foods_model?.add(Foods_Model("شوربا",R.drawable.food_img_c))
        foods_model?.add(Foods_Model("یتیمچه",R.drawable.food_img_d))
        foods_model?.add(Foods_Model("آش رشته",R.drawable.food_img_f))
        foods_model?.add(Foods_Model("آش دوغ",R.drawable.food_img_e))
        foods_model?.add(Foods_Model("خورشت",R.drawable.food_img_g))
        foods_model?.add(Foods_Model("پلو",R.drawable.food_img_c))
        foods_model?.add(Foods_Model("زرشک پلو",R.drawable.food_img_a))
        foods_model?.add(Foods_Model("یارما شرباسی",R.drawable.food_img_b))
        foods_model?.add(Foods_Model("جیگر",R.drawable.food_img_c))
        foods_model?.add(Foods_Model("شیله",R.drawable.food_img_e))
        foods_model?.add(Foods_Model("ماکارونی",R.drawable.food_img_g))
        foods_model?.add(Foods_Model("قیمه",R.drawable.food_img_f))
        foods_model?.add(Foods_Model("قرومه سبزی",R.drawable.food_img_c))
        rv_food.layoutManager = LinearLayoutManager(context,LinearLayout.HORIZONTAL,false)
        foodAdapter = FoodsAdapter(foods_model!!)
        rv_food.adapter = foodAdapter
    }
    //افزودن کلیک برای آیتم های ریسایکلر ویوی مزاج
    override fun onItemClick(items: Mezaj_Model, position: Int)
    {
//        Toast.makeText(requireContext(),items.mezaj_title,Toast.LENGTH_SHORT).show()

        when(position)
        {
            0 ->  navController!!.navigate(R.id.action_mainFragment_to_damaviFragment)
            1 ->  navController!!.navigate(R.id.action_mainFragment_to_damaviFragment)
            2 ->  navController!!.navigate(R.id.action_mainFragment_to_damaviFragment)
            3 ->  navController!!.navigate(R.id.action_mainFragment_to_damaviFragment)
            4 ->  navController!!.navigate(R.id.action_mainFragment_to_damaviFragment)
            5 ->  navController!!.navigate(R.id.action_mainFragment_to_damaviFragment)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        btn_start_TestMazaj.setOnClickListener(this)
    }

    override fun onClick(v: View?)
    {
        when(v!!.id)
        {
            R.id.btn_start_TestMazaj -> navController!!.navigate(R.id.action_mainFragment_to_before_TestMezajQuestionFragment)
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
                beforeTestmezajquestionfragment = Before_TestMezajQuestionFragment()
                navController!!.navigate(R.id.action_mainFragment_to_before_TestMezajQuestionFragment)
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

}
